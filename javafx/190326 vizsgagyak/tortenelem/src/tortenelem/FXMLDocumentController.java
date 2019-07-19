package tortenelem;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import panel.Panel;
import static panel.Panel.hiba;
import static panel.Panel.igennem;

/**
 *
 * @author Joe
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TableView<Evszam> tblEvek;

    @FXML
    private TableColumn<Evszam, Integer> oEv;

    @FXML
    private TableColumn<Evszam, String> oEsemeny;

    @FXML
    private TextField txtKeres;

    @FXML
    private TextField txtEv;

    @FXML
    private TextField txtEsemeny;

    @FXML
    void hozzaad() {
        String s = txtEv.getText();
        int ev;
        try {
            ev = Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            Panel.hiba("Hiba!", "Hibás év!");
            txtEv.requestFocus();
            return;
        }
        s = txtEsemeny.getText();
        if (s.length() < 1 || s.length() > 80) {
            Panel.hiba("Hiba!", "Az esemény hossza 1-80 karakter lehet!");
            txtEv.requestFocus();
            return;
        }
        s = ab.hozzaad(ev, s);
        if (s.isEmpty()) {
            beolvas();  
            uj();
        } 
        else {
            Panel.hiba("Hiba!", s);
        }
    }

    @FXML
    void szuro_torol() {
        txtKeres.clear();
    }

    @FXML
    void modosit() {
        int index = tblEvek.getSelectionModel().getSelectedIndex();
        if (index == -1)
            return;
        int id = tblEvek.getItems().get(index).getId();
        
        String s = txtEv.getText();
        int ev;
        try {
            ev = Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            Panel.hiba("Hiba!", "Hibás év!");
            txtEv.requestFocus();
            return;
        }
        s = txtEsemeny.getText();
        if (s.length() < 1 || s.length() > 80) {
            Panel.hiba("Hiba!", "Az esemény hossza 1-80 karakter lehet!");
            txtEv.requestFocus();
            return;
        }
        s = ab.modosit(id, ev, s);
        if (s.isEmpty()) {
            beolvas();  
            for (int i = 0; i < tblEvek.getItems().size(); i++) {
                if (tblEvek.getItems().get(i).getId() == id) {
                    tblEvek.getSelectionModel().select(i);
                    break;
                }
            }                                               
        } 
        else {
            Panel.hiba("Hiba!", s);
        }
    }

    @FXML
    void torol() {
        int index = tblEvek.getSelectionModel().getSelectedIndex();
        if (index == -1)
            return;
        if (!igennem("Törlés", "Biztosan törölni szeretnéd ezt az évszámot?"))
            return;
        int id = tblEvek.getItems().get(index).getId();
        String v = ab.torol(id);
        if (v.isEmpty())
            beolvas();
        else
            hiba("Hiba!",v);
    }

    @FXML
    void uj() {
        txtEv.clear();
        txtEsemeny.clear();
        txtEv.requestFocus();
        tblEvek.getSelectionModel().select(null);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        oEv.setCellValueFactory(new PropertyValueFactory<>("ev"));
        oEsemeny.setCellValueFactory(new PropertyValueFactory<>("esemeny"));
        
        beolvas();
        
        txtKeres.textProperty().addListener(e -> beolvas());

        tblEvek.getSelectionModel().selectedIndexProperty().addListener(
                (o,regi,uj) -> tablabol(uj.intValue())
        );
        
    }    
 
    DB ab = new DB();
    
    private void beolvas() {
        String szuro = "'%" + txtKeres.getText() + "%'";
        String s = "SELECT * FROM evszamok WHERE esemeny LIKE " 
                 + szuro + " ORDER BY ev;";
        ab.beolvas(tblEvek.getItems(), s);        
    }
    
    private void tablabol(int i) {
        if (i == -1)
            return;
        Evszam esz = tblEvek.getItems().get(i);
        txtEv.setText("" + esz.getEv());
        txtEsemeny.setText(esz.getEsemeny());        
    }
}
