package dolgozok;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
    final String dbUrl1 = "jdbc:mysql://localhost:3306/";
    final String dbUrl2 = "jdbc:mysql://localhost:3306/dolgozok"
        + "?useUnicode=true&characterEndcoding=UTF-8";
    final String user = "root";
    final String pass = "";

    public DB() {
        String s1 = "CREATE DATABASE IF NOT EXISTS dolgozok";
        String s2 = "USE dolgozok";
        String s3 = "CREATE TABLE IF NOT EXISTS adatok (" +
                "id int(4) NOT NULL AUTO_INCREMENT," +
                "nev varchar(50), " +
                "szulido date," +
                "fizetes int(7)," +
                "PRIMARY KEY(id)" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4" +
                " COLLATE=utf8mb4_hungarian_ci;";
        try (Connection kapcs = DriverManager.getConnection(dbUrl1, user, pass);
            PreparedStatement ekp1 = kapcs.prepareStatement(s1);
            PreparedStatement ekp2 = kapcs.prepareStatement(s2);
            PreparedStatement ekp3 = kapcs.prepareStatement(s3)) {
            ekp1.execute();
            ekp2.execute();
            ekp3.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void lista() {
        String s = "SELECt * FROM adatok";
        try (Connection kapcs = DriverManager.getConnection(dbUrl2, user, pass);
            PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ResultSet eredmeny = ekp.executeQuery();
            while (eredmeny.next()) {                
                System.out.printf("%2d %-50s %s %10d\n",
                        eredmeny.getInt("id"),
                        eredmeny.getString("nev"),
                        eredmeny.getDate("szulido"),
                        eredmeny.getInt("fizetes"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

