package at.itkolleg;

import java.sql.*;

public class JDBCDemo {

    public static void main(String[] args) {
        System.out.println("JDBC Demo!");
        //INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, 'Manuel Foidl', 'manue@foidl'), (NULL, 'max muster', 'max@muster');
        selectAlldemo();
        insertStudentDemo();
        selectAlldemo();
    }
    public static void insertStudentDemo(){
        System.out.println("Insert Demo mit JDBC");
        String connectionURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pw = "";
        try (Connection conn = DriverManager.getConnection(connectionURL,"root", "")){
            System.out.println("Verbindung zur DB hergestellt!");
            //SQL Statement vorbereiten
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, ?, ?)");
            try {
                preparedStatement.setString(1, "Peter Zeck");
                preparedStatement.setString(2, "p.zeck@gmail.com");
                int rowAffected = preparedStatement.executeUpdate();
                System.out.println("Datensätze eingefügt: " + rowAffected);

            }catch (SQLException ex) {
                System.out.println("Fehler im der SQL-INSERT Statement: " + ex.getMessage());
            }
        }catch (SQLException e)
        {
            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
        }
    }


    public static void selectAlldemo(){
        System.out.println("Select Demo mit JDBC");
        String sqlSelectAllPersons = "SELECT * FROM `student`";
        String connectionURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pw = "";
        try (Connection conn = DriverManager.getConnection(connectionURL,"root", "")){
            System.out.println("Verbindung zur DB hergestellt!");
            //SQL Statement vorbereiten
            PreparedStatement preparedStatement = conn.prepareStatement(sqlSelectAllPersons);
            //Abfrage executen
            ResultSet rs = preparedStatement.executeQuery();
            //Durch das ResultSet iterieren mit .next()
            while (rs.next()){
               int id = rs.getInt("id");
               String name = rs.getString("name");
               String email = rs.getString("email");
               System.out.println("Student aus der DB: ID: " + id + " Name: " + name + " EMAIL: " + email);
            }
        }catch (SQLException e)
        {
            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
        }
    }
}
