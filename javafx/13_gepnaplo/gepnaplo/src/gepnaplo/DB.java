/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gepnaplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author adamr
 */
public class DB {
    final String db = "jdbc:mysql://localhost:3306/gepnaplo" +
            "?useLegacyDatetimeCode=false&serverTimezone=UTC";
    final String DB_DRV =  "com.mysql.jdbc.Driver";
    final String user = "tanulo";
    String pass = "tanulo";

    public void beir(String iskola, String osztaly, String nev, String allapot) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String p = "INSERT INTO gepek (gepnev,iskola,osztaly,nev,ido,allapot)"
                + " VALUES (?,?,?,?,?,?); ";

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(p)) {
            ekp.setString(1, Seged.gepnev());
            ekp.setString(2, iskola);
            ekp.setString(3, osztaly);
            ekp.setString(4, nev);
            ekp.setString(5, Seged.datumido());
            ekp.setString(6, allapot);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
