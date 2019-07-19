package kozoskoltseg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.collections.ObservableList;
import static panel.Panel.hiba;

/**
 *
 * @author Joe
 */
public class DB {
    final String db = "jdbc:mysql://127.0.0.1:3306/tarsashaz" +
                      "?useLegacyDatetimeCode=false&serverTimezone=UTC";
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
            lista.sort((n1,n2)->n1.compareTo(n2));
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
            hiba("Hiba!",ex.getMessage());
        }
    }

    public String dij_hozzaad(LocalDate datum, int nmdij) {
        String s = "INSERT INTO koltseg (datum, nmdij) "
                + "VALUES(?,?);";
        
        try (Connection kapcs = DriverManager.getConnection(db,user,pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setString(1, datum.toString());
            ekp.setInt(2, nmdij);
            ekp.executeUpdate();
            return "";
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    } 
    
    public String lakas_hozzaad (String epulet, String ajto, int terulet, String nev) {
        String s = "INSERT INTO lakasok (epulet, ajto, terulet, nev)"
                + "VALUES(?,?,?,?);";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setString(1, epulet);
            ekp.setString(2, ajto);
            ekp.setInt(3, terulet);
            ekp.setString(4, nev);
            ekp.executeUpdate();
            return "";
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
    
    public String befizet_hozzaad(int lakasid, LocalDate datum, int osszeg) {
        String s = "INSERT INTO befizetesek (lakasid, datum, osszeg)"
                + "VALUES(?,?,?);";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareCall(s)) {
            ekp.setInt(1, lakasid);
            ekp.setString(2, datum.toString());
            ekp.setInt(3, osszeg);
            ekp.executeUpdate();
            return "";
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
    
    public String lakas_modosit (int lakasid, String epulet, String ajto, 
                                int terulet, String nev) {
        String s = "UPDATE lakasok SET epulet=?, ajto=?, terulet=?, nev=? "
                + "WHERE lakasid=?;";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setString(1, epulet);
            ekp.setString(2, ajto);
            ekp.setInt(3, terulet);
            ekp.setString(4, nev);
            ekp.setInt(5, lakasid);
            ekp.executeUpdate();
            return "";
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
}
