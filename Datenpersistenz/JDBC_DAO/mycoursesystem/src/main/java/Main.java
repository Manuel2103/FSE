import dataaccess.MySqlBuchungRepository;
import dataaccess.MySqlCourseRepository;
import dataaccess.MySqlStudentRepository;
import ui.Cli;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Cli myCli = null;
        try {
            myCli = new Cli(new MySqlCourseRepository(), new MySqlStudentRepository(), new MySqlBuchungRepository());
            myCli.start();
        } catch (SQLException e) {
            System.out.println("Datenbankfehler " + e.getMessage() + " SQL-State: " + e.getSQLState());
        } catch (ClassNotFoundException e) {
            System.out.println("Datenbankfehler " + e.getMessage());
        }



    }
}
