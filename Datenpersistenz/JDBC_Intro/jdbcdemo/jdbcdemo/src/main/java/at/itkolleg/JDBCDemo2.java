package at.itkolleg;

import java.math.BigDecimal;
import java.sql.*;

public class JDBCDemo2 {
    public static void main(String[] args) {
        selectAll();
        insertHobby("Schwimmen", new BigDecimal(0));
        selectAll();


    }

    public static void selectAll() {
        String connectionURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pw = "";

        try (Connection conn = DriverManager.getConnection(connectionURL, user, pw)) {
            String sqlstatement = "SELECT * FROM hobbies";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlstatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String bezeichnung = rs.getString("bezeichnung");
                BigDecimal betrag = rs.getBigDecimal("beitrag");
                System.out.printf("Hobby: ID %d, Bezeichnung: %s, Betrag: %s %n", id, bezeichnung, betrag.toString());
            }

        } catch (SQLException e) {
            System.out.println("Fehler " + e.getMessage());

        }

    }

    public static void insertHobby(String bezeichnung, BigDecimal beitrag) {
        String connectionURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pw = "";

        try (Connection conn = DriverManager.getConnection(connectionURL, user, pw)) {
            String sqlstatement = "INSERT INTO `hobbies` (`id`, `bezeichnung`, `beitrag`) VALUES (NULL, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlstatement);

            try {
                preparedStatement.setString(1, bezeichnung);
                preparedStatement.setBigDecimal(2, beitrag);
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println("Datensätze hinzugefügt: " + affectedRows);

            } catch (SQLException e) {
                System.out.println("Fehler beim Insert " + e.getMessage());
            }


        } catch (SQLException e) {
            System.out.println("Fehler " + e.getMessage());

        }
    }
}

