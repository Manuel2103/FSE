package at.itkolleg;

import java.math.BigDecimal;
import java.nio.channels.FileLock;
import java.sql.*;
import java.util.Formatter;

public class JDBCDemo2 {
    public static void main(String[] args) {
        selectAll();

    }

    public static void selectAll(){
        String connectionURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pw = "";

        try(Connection conn = DriverManager.getConnection(connectionURL, user, pw)){
            String sqlstatement = "SELECT * FROM hobbies";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlstatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String bezeichnung = rs.getString("bezeichnung");
                BigDecimal betrag = rs.getBigDecimal("beitrag");
                System.out.printf("Hobby: ID %d, Bezeichnung: %s, Betrag: %s %n", id, bezeichnung, betrag.toString());
            }

        }catch (SQLException e){
            System.out.println("Fehler " + e.getMessage());

        }

    }
}

