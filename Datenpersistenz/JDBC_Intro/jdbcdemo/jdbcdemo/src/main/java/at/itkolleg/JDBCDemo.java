package at.itkolleg;

import java.sql.*;

public class JDBCDemo {

    public static void main(String[] args) {
        System.out.println("JDBC Demo!");
        selectAlldemo();
        insertStudentDemo("Maxine Musterfrau", "testitest@testy.tt");
        selectAlldemo();
        updateStudentDemo(1,"Neuer Name", "neueremail@neu.neu");
        selectAlldemo();
        deleteStudentDemo(5);
        selectAlldemo();
    }

    public static void deleteStudentDemo(int studentID){
        System.out.println("Delete Demo mit JDBC");
        String connectionURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pw = "";
        try (Connection conn = DriverManager.getConnection(connectionURL,"root", "")){
            System.out.println("Verbindung zur DB hergestellt!");
            //SQL Statement vorbereiten
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM `student` WHERE `student`.`id` = ?");
            try {
                //Fragezeichen auffüllen
                preparedStatement.setInt(1, studentID);
                // Statement ausführen
                int rowAffected = preparedStatement.executeUpdate();
                System.out.println("Anzahl der gelöschten Zeilen" + rowAffected);
            }catch (SQLException ex) {
                System.out.println("Fehler im der SQL-Delete Statement: " + ex.getMessage());
            }
        }catch (SQLException e)
        {
            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
        }
    }

    public static void updateStudentDemo(int id, String neuername, String neueemail){
        System.out.println("Update Demo mit JDBC");
        String connectionURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pw = "";
        try (Connection conn = DriverManager.getConnection(connectionURL,"root", "")){
            System.out.println("Verbindung zur DB hergestellt!");
            //SQL Statement vorbereiten
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE `student`SET `name` = ?, `email`= ? WHERE `student`.`id` = ?");
            try {

                preparedStatement.setString(1, neuername);
                preparedStatement.setString(2, neueemail);
                preparedStatement.setInt(3, id);
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println(affectedRows + " Datensätze geändert.");

            }catch (SQLException ex) {
                System.out.println("Fehler im der SQL-update Statement: " + ex.getMessage());
            }
        }catch (SQLException e)
        {
            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
        }
    }

    public static void insertStudentDemo(String name, String email){
        System.out.println("Insert Demo mit JDBC");
        String connectionURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pw = "";
        try (Connection conn = DriverManager.getConnection(connectionURL,"root", "")){
            System.out.println("Verbindung zur DB hergestellt!");
            //SQL Statement vorbereiten
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, ?, ?)");
            try {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
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
