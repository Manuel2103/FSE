package dataaccess;

import domain.Course;
import domain.CourseType;
import util.Assert;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class MySqlCourseRepository implements MyCourseRepository {

    private Connection con;

    public MySqlCourseRepository() throws SQLException, ClassNotFoundException {
        this.con = MysqlDatabaseConnection.getConnection("jdbc:mysql://localhost:3306/kurssystem", "root", "");
    }

    /**
     * Fügt einen Course zur Datenbank hinzu.
     *
     * @param entity das Course Objekt das hinzugefügt werden soll
     * @return ein Optional vom Typ Course.
     */
    @Override
    public Optional<Course> insert(Course entity) {
        Assert.notNull(entity);
        try {
            //Objektrelationales Mapping
            String sql = "INSERT INTO `courses` (`name`, `description`, `hours`, `begindate`, `enddate`, `coursetype`) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setInt(3, entity.getHours());
            preparedStatement.setDate(4, entity.getBeginDate());
            preparedStatement.setDate(5, entity.getEndDate());
            preparedStatement.setString(6, entity.getCourseType().toString());
            int affectedRows = preparedStatement.executeUpdate();
            //Prüfen, ob das Einfügen funktioniert hat.
            if (affectedRows == 0) {
                return Optional.empty();
            }
            //Die neu erstellte ID lassen wir uns zurückgeben.
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                //Für die Rückgabe verwenden wird die zuvor erstellte Funktion getById
                return this.getById(generatedKeys.getLong(1));
            } else {
                return Optional.empty();
            }
        } catch (SQLException sqlException) {
            throw new DatabaseException(sqlException.getMessage());
        }
    }

    /**
     * Gibt einen Course zurück, der zuvor durch die ID eindeutig bestimmt worden ist.
     *
     * @param id ID des zur suchenden Course
     * @return Course
     */
    @Override
    public Optional<Course> getById(Long id) {
        //Utility Klasse für die NULL Prüfung der ID
        Assert.notNull(id);
        //Mithilfe einer Hilfsmethode wird geprüft, ob ein mit dieser ID existiert.
        if (countCoursesInDbWithId(id) == 0) {
            return Optional.empty();
        } else {
            try {
                String sql = "SELECT * FROM `courses` WHERE `id` = ? ";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                //Erstellen eines Course Objekts mit dem Ergebnis der Abfrage
                Course course = new Course(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("hours"),
                        resultSet.getDate("begindate"),
                        resultSet.getDate("enddate"),
                        CourseType.valueOf(resultSet.getString("coursetype"))
                );
                return Optional.of(course);

            } catch (SQLException sqlException) {
                throw new DatabaseException(sqlException.getMessage());
            }
        }
    }

    /**
     * Hilfmethode die überprüft, ob ein Course mit der ID verfügbar ist.
     *
     * @param id ID eines Course
     * @return Anzahl der Ergebnisse
     */
    private int countCoursesInDbWithId(Long id) {
        try {
            String countSql = "SELECT COUNT(*) FROM `courses`WHERE `id`=?";
            PreparedStatement preparedStatement = con.prepareStatement(countSql);
            preparedStatement.setLong(1, id);
            ResultSet resultSetCount = preparedStatement.executeQuery();
            resultSetCount.next();
            int coursecount = resultSetCount.getInt(1);
            return coursecount;
        } catch (SQLException sqlException) {
            throw new DatabaseException(sqlException.getMessage());
        }
    }

    /**
     * Erstellt eine Liste von Courses und gibt diese zurück
     *
     * @return Liste von courses
     */
    @Override
    public List<Course> getAll() {
        String sql = "SELECT * FROM `courses`";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Course> courseList = new ArrayList<>();
            while (resultSet.next()) {
                //Die Daten, die von der Datenbank kommen, werden einem neuen Course übergeben und in eine Liste hinzugefügt.
                //Objektrelationales Mapping
                courseList.add(new Course(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getString("description"),
                                resultSet.getInt("hours"),
                                resultSet.getDate("begindate"),
                                resultSet.getDate("enddate"),
                                CourseType.valueOf(resultSet.getString("coursetype"))
                        )
                );
            }
            return courseList;
        } catch (SQLException e) {
            throw new DatabaseException("Database error occured!");
        }

    }

    /**
     * Aktualisiert einen Course in der Datenbank.
     * @param entity Course der veränder werden soll
     * @return Optional von Type Course
     */
    @Override
    public Optional<Course> update(Course entity) {

        Assert.notNull(entity);

        String sql = "UPDATE `courses` SET `name` = ?, `description` = ?, `hours` = ?, `begindate` = ?, `enddate` = ?, `coursetype` = ? WHERE `courses`.`id` = ?";
        //Prüfen, ob der mitgegebene Course in der Datenbank existiert.
        if (countCoursesInDbWithId(entity.getId()) == 0) {
            return Optional.empty();
        } else {
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, entity.getName());
                preparedStatement.setString(2, entity.getDescription());
                preparedStatement.setInt(3, entity.getHours());
                preparedStatement.setDate(4, entity.getBeginDate());
                preparedStatement.setDate(5, entity.getEndDate());
                preparedStatement.setString(6, entity.getCourseType().toString());
                preparedStatement.setLong(7, entity.getId());

                int affectedRows = preparedStatement.executeUpdate();
                if (affectedRows == 0) {
                    return Optional.empty();
                } else {
                    return this.getById(entity.getId());
                }
            } catch (SQLException sqlException) {
                throw new DatabaseException(sqlException.getMessage());
            }
        }
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Course> findAllCoursesByName(String name) {
        return null;
    }

    @Override
    public List<Course> findAllCoursesByDescription(String description) {
        return null;
    }

    @Override
    public List<Course> findAllCoursesByDescriptionOrName(String searchText) {
        return null;
    }

    @Override
    public List<Course> findAllCoursesByCourseType(CourseType courseType) {
        return null;
    }

    @Override
    public List<Course> findAllCoursesByStartDate(Date startDate) {
        return null;
    }

    @Override
    public List<Course> findAllRunningCourses() {
        return null;
    }
}
