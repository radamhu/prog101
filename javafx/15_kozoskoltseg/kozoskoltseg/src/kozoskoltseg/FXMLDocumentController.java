package kozoskoltseg;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import panel.Panel;

/**
 *
 * @author Joe
 */
public class FXMLDocumentController implements Initializable {
    DB ab = new DB();
    
    @FXML
    private TableView<Dij> tblDij;

    @FXML
    private TableColumn<Dij, String> oDatum;

    @FXML
    private TableColumn<Dij, Integer> oDij;

    @FXML
    private DatePicker dpKezdet;

    @FXML
    private TextField txtHavidij;

    @FXML
    private TextField txtOsszes;

    @FXML
    private TableView<Lakas> tblLakas;

    @FXML
    private TableColumn<Lakas, String> oEpulet;

    @FXML
    private TableColumn<Lakas, String> oAjto;

    @FXML
    private TableColumn<Lakas, String> oNev;

    @FXML
    private TableColumn<Lakas, Integer> oTerulet;

    @FXML
    private TextField txtEpulet;

    @FXML
    private TextField txtAjto;

    @FXML
    private TextField txtNev;

    @FXML
    private TextField txtTerulet;

    @FXML
    private TextField txtBefizetes;

    @FXML
    private TextField txtEgyenleg;

    @FXML
    private TableView<Befizetes> tblBefizet;

    @FXML
    private TableColumn<Befizetes, String> oNev2;

    @FXML
    private TableColumn<Befizetes, String> oDatum2;

    @FXML
    private TableColumn<Befizetes, Integer> oOsszeg;

    @FXML
    private TextField txtOsszeg;

    @FXML
    private DatePicker dpDatum;

    @FXML
    private ComboBox<String> cbxNev;

    @FXML
    void befizet_hozzaad() {
        String nev = cbxNev.getValue();
        if (nev == null) {
            Panel.hiba("Hiba!", "Válaszd ki a befizető nevét!");
            cbxNev.requestFocus();
            return;
        }
        LocalDate datum = dpDatum.getValue();
        if (datum == null) {
            Panel.hiba("Hiba!", "Add meg a dátumot!");
            dpDatum.requestFocus();
            return;
        }
        if (datum.isAfter(LocalDate.now())) {
            Panel.hiba("Hiba!", "A dátum nem lehet a mainál újabb!");
            dpDatum.requestFocus();
            return;
        }
        int osszeg;
        try {
            osszeg = Integer.parseInt(txtOsszeg.getText());
            if (osszeg < 0) {
                Panel.hiba("Hiba!", "Az összeg nem lehet negatív!");
                txtOsszeg.requestFocus();
                return;
            }
        } catch (NumberFormatException ex) {
            Panel.hiba("Hiba!", "Az összeg nem szám");
            txtOsszeg.requestFocus();
            return;
        }
        String v = ab.befizet_hozzaad(lakas_id(nev), datum, osszeg);
        if (v.isEmpty()) {
            ab.befizetes_be(tblBefizet.getItems());
            lakas_tablabol(tblLakas.getSelectionModel().getSelectedIndex());
        } else {
            Panel.hiba("Hiba!", v);
        }
        cbxNev.requestFocus();
    }

    @FXML
    void befizet_torol() {

    }

    @FXML
    void dij_hozzaad() {
        LocalDate kezdet = dpKezdet.getValue();
        if (kezdet == null) {
            Panel.hiba("Hiba!", "Add meg a kezdő dátumot!");
            dpKezdet.requestFocus();
            return;
        }
        if (kezdet.getDayOfMonth() != 1) {
            Panel.hiba("Hiba", "A díj csak 1-én változhat!");
            dpKezdet.requestFocus();
            return;
        }
        String s = txtHavidij.getText();
        if (s.isEmpty()) {
            Panel.hiba("Hiba!", "Add meg  díjat!");
            txtHavidij.requestFocus();
            return;
        }
        int dij;
        try {
            dij = Integer.parseInt(txtHavidij.getText());
            if ((dij < 0)) {
                Panel.hiba("Hiba!", "A díj nem lehet negativ");
                txtHavidij.requestFocus();
                return;
            }
        } catch (NumberFormatException ex) {
            Panel.hiba("Hiba!", "A díj nem szám!");
            txtHavidij.requestFocus();
            return;
        }
        String v = ab.dij_hozzaad(kezdet, dij);
        if (v.isEmpty()) {
            ab.koltseg_be(tblDij.getItems());
            for (int i = 0; i < tblDij.getItems().size(); i++) {
                if (tblDij.getItems().get(i).getDatum().equals(kezdet.toString())) {
                    tblDij.getSelectionModel().select(i);
                    break;
                }
            }
            txtOsszes.setText("" + osszes_dij());
            lakas_tablabol(tblLakas.getSelectionModel().getSelectedIndex());
        } else 
            Panel.hiba("Hiba!", v);
    }

    @FXML
    void dij_torol() {

    }

    @FXML
    void export() {

    }

    @FXML
    void lakas_hozzaad() {
        String epulet = txtEpulet.getText().toUpperCase();
        if (epulet.length() != 1 || !"ABCD".contains(epulet)) {
            Panel.hiba("Hiba!", "Az épület csak A, B, C és D lehet!");
            txtEpulet.requestFocus();
            return;
        }
        String ajto = txtAjto.getText();
        if (ajto.length() < 1 || ajto.length() > 2) {
            Panel.hiba("Hiba!", "Az ajtó 1 vagy 2 karakter hosszú lehet");
            txtAjto.requestFocus();
            return;
        }
        String nev = txtNev.getText();
        if (nev.length() < 1 || nev.length() > 50) {
            Panel.hiba("Hiba!", "A név 1-50 karakter hosszú lehet");
            txtNev.requestFocus();
            return;
        }
        int  terulet;
        try {
            terulet = Integer.parseInt(txtTerulet.getText());
            if (terulet < 20) {
                Panel.hiba("Hiba!", "A terület nem lehet 20-nál kisebb!");
                txtTerulet.requestFocus();
                return;
            }
        } catch (NumberFormatException ex) {
            Panel.hiba("Hiba!", " A terület nem számít!");
            txtTerulet.requestFocus();
            return;
        }
        String v = ab.lakas_hozzaad(epulet, ajto, terulet, nev);
        if (v.isEmpty()) {
            ab.lakas_be(tblLakas.getItems(), cbxNev.getItems());
            for (int i = 0; i < tblLakas.getItems().size(); i++) {
                if (tblLakas.getItems().get(i).getNev().equals(nev)) {
                    tblLakas.getSelectionModel().select(i);
                    break;
                }
            }
        } else 
            Panel.hiba("Hiba!", v);
        txtEpulet.requestFocus();
    }
    
    private int lakas_id(String nev) {
        ObservableList<Lakas> lista = tblLakas.getItems();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNev().equals(nev))
                return lista.get(i).getLakasid();
        }
        return -1;
    }

    @FXML
    void lakas_modosit() {
        int index = tblLakas.getSelectionModel().getSelectedIndex();
        if (index == -1) {
            return;
        }
        int id = tblLakas.getItems().get(index).getLakasid();
        String epulet = txtEpulet.getText().toUpperCase();
        if (epulet.length() != 1 || !"ABCD".contains(epulet)) {
            Panel.hiba("Hiba!", "Az épület csak A, B, C vagy D lehet!");
            txtEpulet.requestFocus();
            return;
        }
        String ajto = txtAjto.getText();
        if (ajto.length() < 1 || ajto.length() > 2) {
            Panel.hiba("Hiba!", "Az ajtó 1 vagy 2 karakter hosszú lehet!");
            txtAjto.requestFocus();
            return;
        }
        String nev = txtNev.getText();
        if (nev.length() < 1  || nev.length() > 50 ) {
            Panel.hiba("Hiba!", "A név 1-50 karakter hosszú lehet!");
            txtNev.requestFocus();
            return;
        }
        int terulet;
        try {
            terulet = Integer.parseInt(txtTerulet.getText());
            if (terulet < 20) {
                Panel.hiba("Hiba!", "A erületn nem lehet 20-ná kissebb");
                txtTerulet.requestFocus();
                return;
            }
        } catch (NumberFormatException ex) {
            Panel.hiba("Hiba!", "A terület nem szám!");
            txtTerulet.requestFocus();
            return;
        }
        String v = ab.lakas_modosit(id, epulet, ajto, terulet, nev);
        if (v.isEmpty()) {
            ab.lakas_be(tblLakas.getItems(), cbxNev.getItems());
            for (int i = 0; i < tblLakas.getItems().size(); i++) {
                if (tblLakas.getItems().get(i).getNev().equals(nev)) {
                    tblLakas.getSelectionModel().select(i);
                    break;
                }
            }
        } else {
            Panel.hiba("Hiba!", v);
        }

    }

    @FXML
    void lakas_torol() {

    }

    @FXML
    void lakas_uj() {
        txtEpulet.clear();
        txtAjto.clear();
        txtNev.clear();
        txtTerulet.clear();
        txtEpulet.requestFocus();
        tblLakas.getSelectionModel().select(null);
    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        oDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        oDij.setCellValueFactory(new PropertyValueFactory<>("nmdij"));
        
        oEpulet.setCellValueFactory(new PropertyValueFactory<>("epulet"));
        oAjto.setCellValueFactory(new PropertyValueFactory<>("ajto"));
        oNev.setCellValueFactory(new PropertyValueFactory<>("nev"));
        oTerulet.setCellValueFactory(new PropertyValueFactory<>("terulet"));
        
        oNev2.setCellValueFactory(new PropertyValueFactory<>("nev"));
        oDatum2.setCellValueFactory(new PropertyValueFactory<>("datum"));
        oOsszeg.setCellValueFactory(new PropertyValueFactory<>("osszeg"));
        
        ab.koltseg_be(tblDij.getItems());
        ab.lakas_be(tblLakas.getItems(), cbxNev.getItems());
        ab.befizetes_be(tblBefizet.getItems());
        
        tblLakas.getSelectionModel().selectedIndexProperty().addListener(
                (o,regi,uj) -> lakas_tablabol(uj.intValue())
        );
        
//        System.out.println(dij(LocalDate.of(2017,2,5)));
//        System.out.println(dij(LocalDate.of(2018,2,6)));
//        System.out.println(dij(LocalDate.of(2019,3,5)));

        txtOsszes.setText("" + osszes_dij());
    }    
    
    private int dij(LocalDate datum) {
        ObservableList<Dij> lista = tblDij.getItems();
        int i = 0;
        while (i < lista.size()-1) {
            if (LocalDate.parse(lista.get(i+1).getDatum()).isAfter(datum))
                break;
            i++;
        }
        return lista.get(i).getNmdij();
    }
    
    private int osszes_dij() {
        LocalDate ma = LocalDate.now();
        LocalDate d = LocalDate.parse(tblDij.getItems().get(0).getDatum());
        int osszeg = 0;
        while (d.isBefore(ma)) {
            osszeg += dij(d);
            d = d.plusMonths(1);
        }
        return osszeg;
    }
    
    private void lakas_tablabol(int i) {
        if (i == -1)
            return;
        Lakas lak = tblLakas.getItems().get(i);
        txtEpulet.setText(lak.getEpulet());
        txtAjto.setText(lak.getAjto());
        txtNev.setText(lak.getNev());
        txtTerulet.setText("" + lak.getTerulet());
        int befizetes = osszes_befizetes(lak.getLakasid());
        txtBefizetes.setText("" + befizetes);
        txtEgyenleg.setText("" + 
          (befizetes - Integer.parseInt(txtOsszes.getText())*lak.getTerulet()));
    }
    
    private int osszes_befizetes(int lakasid) {
        ObservableList<Befizetes> lista = tblBefizet.getItems();
        int osszeg = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getLakasid() == lakasid)
                osszeg += lista.get(i).getOsszeg();
        }
        return osszeg;
    }
}
