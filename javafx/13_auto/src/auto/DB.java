package auto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;

public class DB {

    final String db = "jdbc:sqlite:auto.db";
    
    public void betolt(ObservableList<Esemeny> lista) {
        String p = "SELECT * FROM kiadasok";
        try (Connection kapcs = DriverManager.getConnection(db);
             PreparedStatement ekp = kapcs.prepareStatement(p)) {
            ResultSet eredmeny = ekp.executeQuery();
            lista.clear();
            while (eredmeny.next()) {
                lista.add(new Esemeny(
                    eredmeny.getInt("az"),
                    eredmeny.getString("kiadas"),
                    eredmeny.getInt("ar"),
                    eredmeny.getString("datum"),
                    eredmeny.getInt("km"),
                    eredmeny.getString("megjegyzes")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void uj(String kiadas, int ar, String datum, int km, String megjegyzes) {        
        String p = "INSERT INTO kiadasok (kiadas,ar,datum,km,megjegyzes) VALUES (?,?,?,?,?);";
        try (Connection kapcs = DriverManager.getConnection(db);
             PreparedStatement ekp = kapcs.prepareStatement(p)) {
            ekp.setString(1, kiadas);
            ekp.setInt(2, ar);
            ekp.setString(3, datum);
            ekp.setInt(4, km);
            ekp.setString(5, megjegyzes);
            ekp.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    
    public void modosit(int az, String kiadas, int ar, String datum, int km, String megjegyzes) {        
        String p = "UPDATE kiadasok SET kiadas=?,ar=?,datum=?,km=?,megjegyzes=? WHERE az=?;";
        try (Connection kapcs = DriverManager.getConnection(db);
             PreparedStatement ekp = kapcs.prepareStatement(p)) {
            ekp.setString(1, kiadas);
            ekp.setInt(2, ar);
            ekp.setString(3, datum);
            ekp.setInt(4, km);
            ekp.setString(5, megjegyzes);
            ekp.setInt(6, az);
            ekp.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    
    public void torol(int az) {
        String p = "DELETE FROM kiadasok WHERE az=?;";
        try (Connection kapcs = DriverManager.getConnection(db);
             PreparedStatement ekp = kapcs.prepareStatement(p)) {
            ekp.setInt(1, az);
            ekp.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
    }
}
