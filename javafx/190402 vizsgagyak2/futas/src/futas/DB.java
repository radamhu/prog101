package futas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import static panel.Panel.hiba;

/**
 *
 * @author Joe
 */
public class DB {
    final String db = "jdbc:mysql://localhost:3306/futas" +
                      "?useUnicode=true&characterEncoding=UTF-8";
    final String user = "futo";		
    final String pass = "futo";
    
    public void beolvas(ObservableList<Edzes> tabla) {
        String s = "SELECT * FROM naplo ORDER BY datum;";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
             PreparedStatement ekp = kapcs.prepareStatement(s)) {
            tabla.clear();
            ResultSet eredmeny = ekp.executeQuery();
            while (eredmeny.next()) {
                tabla.add(new Edzes(
                    eredmeny.getInt("futasId"),
                    eredmeny.getDate("datum"),
                    eredmeny.getInt("tav"),
                    eredmeny.getInt("ido")
                ));
            }
        } catch (SQLException ex) {
            hiba("Hiba!",ex.getMessage());
        }
    }    

    public String hozzaad(Date datum, int tav, int ido) {
        String s = "INSERT INTO naplo (datum, tav, ido) "
                 + "VALUES(?,?,?);";

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
             PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setDate(1, datum);            
            ekp.setInt(2, tav);
            ekp.setInt(3, ido);
            ekp.executeUpdate();
            return "";
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }    
    
    public String modosit(int id, Date datum, int tav, int ido) {
        String s = "UPDATE naplo SET datum=?, tav=?, ido=? "
                 + "WHERE futasID=?";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setDate(1, datum);
            ekp.setInt(2, tav);
            ekp.setInt(3, ido);
            ekp.setInt(4, id);
            ekp.executeUpdate();
            return "";
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
    
    public String torol(int id) {
        String s = "DELETE FROM naplo WHERE futasID=?;";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setInt(1, id);
            ekp.executeUpdate();
            return "";
        } catch (SQLException ex) {
            return ex.getMessage();
        }                
    }
}
