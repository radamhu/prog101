/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gepnaplo2;

import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author t1
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txtGepszuro;

    @FXML
    private ComboBox<String> cbxIdo;

    @FXML
    private TextField txtNevszuro;

    @FXML
    private CheckBox chkProb;

    @FXML
    private TableView<String> Bejelentkezes;

    @FXML
    private TableColumn<Bejelentkezes, String> oGep;
    
    @FXML
    private TableView<Bejelentkezes> tblGepek;
    
    @FXML
    private TableColumn<Bejelentkezes, String> oIdo;

    @FXML
    private TableColumn<Bejelentkezes, String> oNev;

    @FXML
    private TableColumn<Bejelentkezes, String> oAllapot;

    @FXML
    private TableColumn<Bejelentkezes, String> oOsztaly;

    @FXML
    private TableColumn<String, String> oIskola;

    public String lekerdez() {
        String q = "";
        if (!txtGepszuro.getText().isEmpty()) {
            q += " gepnev LIKE '" + txtGepszuro.getText() + "' AND ";
        }
        switch (cbxIdo.getSelectionModel().getSelectedIndex()) {
            case 0:
                q += " TIMEDIFF(NOW(),ido)<'00:45' AND";
                break;
            case 1:
                q += " DATE(ido)=DATE(NOW()) AND";
                break;
            case 2:
                q += " DATEDIFF(NOW(),ido)<=7 AND";
            case 3:
                q += " DATEDIFF(NOW(),ido)<=30 AND";
                break;
        }
        if (!txtNevszuro.getText().isEmpty()) {
            q += " nev LIKE '" + txtNevszuro.getText() + "' AND";
        }
      
        if (chkProb.isSelected()) {
            q += " allapot NOT LIKE '%Rendben%'";
        } else {
            q += " allapot LIKE '%'";
        }
        return "SELECT gepnev,iskola,osztaly,nev,ido,allapot FROM gepek WHERE " + q + " ORDER BY ido DESC;";

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
                DB ab = new DB();

        cbxIdo.getItems().addAll("Ezen az órán", "Ma", "7 napja", "30 napja");
        cbxIdo.setValue("Ezen az órán");
        oGep.setCellValueFactory(new PropertyValueFactory<>("gepnev"));
        oIdo.setCellValueFactory(new PropertyValueFactory<>("ido"));
        oNev.setCellValueFactory(new PropertyValueFactory<>("nev"));
        oAllapot.setCellValueFactory(new PropertyValueFactory<>("allapot"));
        oOsztaly.setCellValueFactory(new PropertyValueFactory<>("osztaly"));
        oIskola.setCellValueFactory(new PropertyValueFactory<>("iskola"));
        ab.beolvas(tblGepek.getItems(), lekerdez());
                ab.torol();

        txtGepszuro.textProperty().addListener(e -> ab.beolvas(tblGepek.getItems(), lekerdez()));
        cbxIdo.valueProperty().addListener(e -> ab.beolvas(tblGepek.getItems(), lekerdez()));
        txtNevszuro.textProperty().addListener(e -> ab.beolvas(tblGepek.getItems(), lekerdez()));
        chkProb.selectedProperty().addListener(e -> ab.beolvas(tblGepek.getItems(), lekerdez()));

    }

}
