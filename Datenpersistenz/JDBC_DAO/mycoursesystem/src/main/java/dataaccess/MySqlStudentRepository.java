package dataaccess;

import domain.Klasse;
import domain.Student;
import util.Assert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MySqlStudentRepository implements MyStudentRepository {
    Connection con;

    public MySqlStudentRepository() throws SQLException, ClassNotFoundException {
        this.con = MysqlDatabaseConnection.getConnection("jdbc:mysql://localhost:3306/kurssystem", "root", "");
    }

    @Override
    public Optional<Student> insert(Student entity) {
        return Optional.empty();
    }

    /**
     * Gibt den Studenten zurück, der die mitgegebene ID besitzt
     * @param id Mitgegebene id des Studenten
     * @return Optional eines Studenten
     */
    @Override
    public Optional<Student> getById(Long id) {

        Assert.notNull(id);
        String sql = "SELECT * FROM `student` WHERE `id` = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Student student = new Student(
                    resultSet.getLong(1),
                    resultSet.getString(2),
                    Klasse.valueOf(resultSet.getString(3)),
                    resultSet.getDate(4));
            return Optional.of(student);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * Gibt alle Studenten zurück
     * @return Gibt eine Liste von Studenten zurück
     */
    @Override
    public List<Student> getAll() {

        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM `student`";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                students.add(new Student(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        Klasse.valueOf(resultSet.getString(3)),
                        resultSet.getDate(4)
                ));
            }
            return students;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public Optional<Student> update(Student entity) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Student> getStudentsByDate(Date date) {
        return null;
    }

    @Override
    public List<Student> getStudentsOrderByDate() {
        return null;
    }

}
