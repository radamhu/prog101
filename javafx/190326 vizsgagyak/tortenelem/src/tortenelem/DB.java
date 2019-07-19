package tortenelem;

import java.sql.Connection;
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
    final String db = "jdbc:mysql://localhost:3306/tortenelem" +
                      "?useUnicode=true&characterEncoding=UTF-8";
    final String user = "tanulo";		
    final String pass = "tanulo";
    
    public void beolvas(ObservableList<Evszam> tabla, String s) {
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
             PreparedStatement ekp = kapcs.prepareStatement(s)) {
            tabla.clear();
            ResultSet eredmeny = ekp.executeQuery();
            while (eredmeny.next()) {
                tabla.add(new Evszam(
                    eredmeny.getInt("evId"),
                    eredmeny.getInt("ev"),
                    eredmeny.getString("esemeny")
                ));
            }
        } catch (SQLException ex) {
            hiba("Hiba!",ex.getMessage());
        }
    }    

    public String hozzaad(int ev, String esemeny) {
        String s = "INSERT INTO evszamok (ev, esemeny) "
                 + "VALUES(?,?);";

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
             PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setInt(1, ev);            
            ekp.setString(2, esemeny);
            ekp.executeUpdate();
            return "";
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }    
    
    public String modosit(int id, int ev, String esemeny) {
        String s = "UPDATE evszamok SET ev=?, esemeny=? "
                 + "WHERE evid=?";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setInt(1, ev);
            ekp.setString(2, esemeny);
            ekp.setInt(3, id);
            ekp.executeUpdate();
            return "";
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
    
    public String torol(int id) {
        String s = "DELETE FROM evszamok WHERE evid=?;";
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
