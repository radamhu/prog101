package kozoskoltseg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author Joe
 */
public class DB {
    final String db = "jdbc:mysql://localhost:3306/tarsashaz" +
                      "?useUnicode=true&characterEncoding=UTF-8";
    final String user = "kepviselo";		
    final String pass = "kepviselo";
    
    public void koltseg_be(ObservableList<Dij> tabla) {
        String s = "SELECT * FROM koltseg ORDER BY datum;";

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
             PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ResultSet eredmeny = ekp.executeQuery();
            tabla.clear();
            while (eredmeny.next()) {
                tabla.add(new Dij(
                    eredmeny.getInt("koltsegid"),
                    eredmeny.getString("datum"),
                    eredmeny.getInt("nmdij")
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    
    public void lakas_be(ObservableList<Lakas> tabla, 
                         ObservableList<String> lista) {
        String s = "SELECT * FROM lakasok ORDER BY epulet, ajto;";

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
             PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ResultSet eredmeny = ekp.executeQuery();
            tabla.clear();
            lista.clear();
            while (eredmeny.next()) {
                tabla.add(new Lakas(
                    eredmeny.getInt("lakasid"),
                    eredmeny.getString("epulet"),
                    eredmeny.getString("ajto"),
                    eredmeny.getInt("terulet"),
                    eredmeny.getString("nev")
                ));
                lista.add(eredmeny.getString("nev"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    
    
    public void befizetes_be(ObservableList<Befizetes> tabla) {
        String s = "SELECT befizid,befizetesek.lakasid,datum,osszeg,nev "
                 + "FROM befizetesek "
                 + "JOIN lakasok ON befizetesek.lakasid=lakasok.lakasid "
                 + "ORDER BY datum,nev;";

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
             PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ResultSet eredmeny = ekp.executeQuery();
            tabla.clear();
            while (eredmeny.next()) {
                tabla.add(new Befizetes(
                    eredmeny.getInt("befizid"),
                    eredmeny.getInt("lakasid"),
                    eredmeny.getString("nev"),
                    eredmeny.getString("datum"),
                    eredmeny.getInt("osszeg")
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    
}
