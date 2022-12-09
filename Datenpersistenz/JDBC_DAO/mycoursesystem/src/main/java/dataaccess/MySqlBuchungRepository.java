package dataaccess;

import domain.Buchung;
import domain.Course;
import domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MySqlBuchungRepository implements MyBuchungRepository{

    Connection con;

    public MySqlBuchungRepository() throws SQLException, ClassNotFoundException {
        this.con = MysqlDatabaseConnection.getConnection("jdbc:mysql://localhost:3306/kurssystem", "root", "");
    }

    @Override
    public Optional<Buchung> insert(Buchung entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Buchung> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Buchung> getAll() {
        ArrayList<Buchung> buchungsListe = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `buchungen`";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            MyCourseRepository course = null;
            MyStudentRepository student =null;
            Optional<Student> oStudent;
            Optional<Course> oCourse;
            try {
                course = new MySqlCourseRepository();
                student = new MySqlStudentRepository();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (resultSet.next()){
                oStudent =  student.getById(resultSet.getLong(2));
                oCourse = course.getById(resultSet.getLong(3));
                buchungsListe.add(new Buchung(
                        resultSet.getLong(1),
                        oCourse.get(),
                        oStudent.get(),
                        resultSet.getBoolean(4)
                ));
            }
            return buchungsListe;

        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage());
        }
    }

    @Override
    public Optional<Buchung> update(Buchung entity) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Buchung> getAllStudentsForBuchungById(Long id) {
        return null;
    }
}
