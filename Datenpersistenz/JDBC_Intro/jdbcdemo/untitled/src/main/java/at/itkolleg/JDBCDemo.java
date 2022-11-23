package at.itkolleg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo {

    public static void main(String[] args) {
        System.out.println("JDBC Demo!");
        //INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, 'Manuel Foidl', 'manue@foidl'), (NULL, 'max muster', 'max@muster');
        selectAlldemo();
    }
    public static void selectAlldemo(){
        System.out.println("Select Demo mit JDBC");
        String sqlSelectAllPersons = "SELECT * FROM `student`";
        String connectionURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pw = "";
        try (Connection conn = DriverManager.getConnection(connectionURL,"root", "")){

            System.out.println("Verbindung zur DB hergestellt!");
        }catch (SQLException e)
        {
            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());

        }
    }
}
