package szotar;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static panel.Panel.hiba;
import static panel.Panel.igennem;

/**
 *
 * @author Joe
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Tab tabSzotar;

    @FXML
    private TextField txtLeckeSzuro;

    @FXML
    private TextField txtAngolSzuro;

    @FXML
    private TextField txtMagyarSzuro;

    @FXML
    private TableView<Szo> tblSzavak;

    @FXML
    private TableColumn<Szo, String> oLecke;

    @FXML
    private TableColumn<Szo, String> oAngol;

    @FXML
    private TableColumn<Szo, String> oMagyar;

    @FXML
    private TextField txtLecke;

    @FXML
    private TextField txtAngol;

    @FXML
    private TextField txtMagyar;
    
    @FXML
    void hozzaad() {
        String lecke = txtLecke.getText();
        if (lecke.length() < 1 || lecke.length() > 10) {
            hiba("Hiba!", "A lecke hossza 1-10 karakter lehet!");
            txtLecke.requestFocus();
            return;
        }
        String angol = txtAngol.getText();
        if (angol.length() < 1 || angol.length() > 60) {
            hiba("Hiba!", "Az angol mező hossza 1-60 karakter lehet!");
            txtAngol.requestFocus();
            return;
        }
        String magyar = txtMagyar.getText();
        if (magyar.length() < 1 || magyar.length() > 60) {
            hiba("Hiba!", "A magyar mező hossza 1-60 karakter lehet!");
            txtMagyar.requestFocus();
            return;
        }
        String s = ab.hozzaad(lecke, angol, magyar);
        if (s.isEmpty()) {
            beolvas();  
            uj();
        } 
        else {
            hiba("Hiba!", s);
        }
    }

    @FXML
    void modosit() {
        int index = tblSzavak.getSelectionModel().getSelectedIndex();
        if (index == -1)
            return;
        int id = tblSzavak.getItems().get(index).getSzoID();

                String lecke = txtLecke.getText();
        if (lecke.length() < 1 || lecke.length() > 10) {
            hiba("Hiba!", "A lecke hossza 1-10 karakter lehet!");
            txtLecke.requestFocus();
            return;
        }
        String angol = txtAngol.getText();
        if (angol.length() < 1 || angol.length() > 60) {
            hiba("Hiba!", "Az angol mező hossza 1-60 karakter lehet!");
            txtAngol.requestFocus();
            return;
        }
        String magyar = txtMagyar.getText();
        if (magyar.length() < 1 || magyar.length() > 60) {
            hiba("Hiba!", "A magyar mező hossza 1-60 karakter lehet!");
            txtMagyar.requestFocus();
            return;
        }
        
        String s = ab.modosit(id, lecke, angol, magyar);
        if (s.isEmpty()) {
            beolvas();  
            for (int i = 0; i < tblSzavak.getItems().size(); i++) {
                if (tblSzavak.getItems().get(i).getSzoID() == id) {
                    tblSzavak.getSelectionModel().select(i);
                    break;
                }
            }                                               
        } 
        else {
            hiba("Hiba!", s);
        }
    }

    @FXML
    void szuro_torol() {
        txtLeckeSzuro.clear();
        txtAngolSzuro.clear();
        txtMagyarSzuro.clear();
        tblSzavak.requestFocus();
    }

    @FXML
    void torol() {
        int index = tblSzavak.getSelectionModel().getSelectedIndex();
        if (index == -1)
            return;
        if (!igennem("Törlés", "Biztosan törölni szeretnéd ezt a szót?"))
            return;
        int id = tblSzavak.getItems().get(index).getSzoID();
        String v = ab.torol(id);
        if (v.isEmpty())
            beolvas();
        else
            hiba("Hiba!",v);
    }

    @FXML
    void uj() {
        //txtLecke.clear();
        txtAngol.clear();
        txtMagyar.clear();
        txtLecke.requestFocus();
        tblSzavak.getSelectionModel().select(null);
    }

    DB ab = new DB();

    private void beolvas() {
        String szuro1 = "'%" + txtLeckeSzuro.getText() + "%'";
        String szuro2 = "'%" + txtAngolSzuro.getText() + "%'";
        String szuro3 = "'%" + txtMagyarSzuro.getText() + "%'";
        String s = "SELECT * FROM szavak "
                 + "WHERE lecke LIKE " + szuro1
                 + "AND   angol LIKE " + szuro2
                 + "AND  magyar LIKE " + szuro3
                 + " ORDER BY angol;";
        ab.beolvas(tblSzavak.getItems(), s);
    }

    private void tablabol(int i) {
        if (i == -1)
            return;
        Szo sz = tblSzavak.getItems().get(i);
        txtLecke.setText("" + sz.getLecke());
        txtAngol.setText("" + sz.getAngol());
        txtMagyar.setText("" + sz.getMagyar());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        oLecke.setCellValueFactory(new PropertyValueFactory<>("lecke"));
        oAngol.setCellValueFactory(new PropertyValueFactory<>("angol"));
        oMagyar.setCellValueFactory(new PropertyValueFactory<>("magyar"));
        
        beolvas();
        
        txtLeckeSzuro.textProperty().addListener(e -> beolvas());
        txtAngolSzuro.textProperty().addListener(e -> beolvas());
        txtMagyarSzuro.textProperty().addListener(e -> beolvas());
        
        tblSzavak.getSelectionModel().selectedIndexProperty().addListener(
                (o,regi,uj) -> tablabol(uj.intValue())
        );
        
        cbxValaszt.getItems().addAll("Angol -> Magyar", "Magyar -> Angol");
        cbxValaszt.setValue("Angol -> Magyar");
    }

// tanulás
    @FXML
    private ComboBox<String> cbxValaszt;

    @FXML
    private Button btnIndit;

    @FXML
    private Button btnTudtam;

    @FXML
    private Button btnNemTudtam;

    @FXML
    private Label lblFelso;

    @FXML
    private Label lblAlso;

    @FXML
    private Label lblHanyvan;

    private ArrayList<Szo> lista;
    private Random vg = new Random();
    private int index;
    
    @FXML
    void indit() {
        if (btnIndit.getText().equals("Indít")) {
            tabSzotar.setDisable(true);
            cbxValaszt.setDisable(true);
            btnIndit.setText("Megállít");
            lista = new ArrayList<>(tblSzavak.getItems());
            nem_tudtam();
        } else {
            tabSzotar.setDisable(false);
            cbxValaszt.setDisable(false);
            btnIndit.setText("Indít");
            lblFelso.setText("?");
            lblAlso.setText("?");
            lblHanyvan.setText("");
            btnTudtam.setDisable(true);
            btnNemTudtam.setDisable(true);
        }
    }

    @FXML
    void mutat() {
        if (lblFelso.getText().equals("?"))
            return;
        if (cbxValaszt.getSelectionModel().getSelectedIndex() == 0)
            lblAlso.setText(lista.get(index).getMagyar());        
        else
            lblAlso.setText(lista.get(index).getAngol());
        btnTudtam.setDisable(false);
        btnNemTudtam.setDisable(false);
    }

    @FXML
    void nem_tudtam() {
        lblHanyvan.setText("Még " + lista.size() + " szó.");
        index = vg.nextInt(lista.size());
        if (cbxValaszt.getSelectionModel().getSelectedIndex() == 0)
            lblFelso.setText(lista.get(index).getAngol());        
        else
            lblFelso.setText(lista.get(index).getMagyar());
        lblAlso.setText("?");
        btnTudtam.setDisable(true);
        btnNemTudtam.setDisable(true);
    }

    @FXML
    void tudtam() {
        lista.remove(index);
        if (lista.isEmpty()) {
            hiba("Gratulálok!", "Minden szót megtanultál!");
            indit();
            return;
        }
        nem_tudtam();
    }
}
