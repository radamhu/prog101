
package gepnaplo2;

import com.mysql.jdbc.PreparedStatement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javafx.application.Platform;
import javafx.collections.ObservableList;


public class DB {
    Properties ini = new Properties();
    String db, user, pass;
    public DB() {
    try (FileInputStream be = new FileInputStream("gepnaplo2.ini")) {
        ini.load(be);
        db = "jdbc:mysql://" + ini.getProperty("ip") + "/gepnaplo?useUnicode=true&characterEncoding=UTF-8";
        user = ini.getProperty("user");
        pass = "tanar" + ini.getProperty("pass");
       } catch (IOException ex) {
           System.out.println(ex.getMessage());
          Platform.exit();
       }
    
}
    public void torol() {
        final String p = "DELETE FROM gepek WHERE DATEDIFF(NOW(),ido)>30;";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
            PreparedStatement ekp = (PreparedStatement) kapcs.prepareStatement(p)) {
         ekp.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        
    }
    }
public void beolvas(ObservableList<Bejelentkezes> lista, String p) {
    try (Connection kapcs = DriverManager.getConnection(db, user, pass);
            PreparedStatement ekp = (PreparedStatement) kapcs.prepareStatement(p)) {
        ResultSet eredmeny = ekp.executeQuery();
        lista.clear();
        while (eredmeny.next()) {
            lista.add( new Bejelentkezes(
            eredmeny.getString("gepnev"),
            eredmeny.getString("ido"),
            eredmeny.getString("nev"),
            eredmeny.getString("allapot"),
            eredmeny.getString("osztaly"),
            eredmeny.getString("iskola")
            ));
        }
        
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    
}

    private FileInputStream FileInputStream(String gepnaplo2ini) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
