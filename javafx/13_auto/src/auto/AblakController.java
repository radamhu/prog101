package auto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Joe
 */
public class AblakController implements Initializable {

    @FXML
    private ComboBox<String> cbxKiadas;

    @FXML
    private TextField txtAr;

    @FXML
    private DatePicker dpDatum;

    @FXML
    private TextField txtKm;

    @FXML
    private TextField txtMegjegyzes;

    @FXML
    private void ok() {
        int ar, km;
        try {
            ar = Integer.parseInt(txtAr.getText());
            if (ar < 0) {
                hiba("Számformátum","Az ár nem lehet negatív!");
                return;
            }
        } catch (NumberFormatException ex) {
            hiba("Számformátum","Az ár nem szám!");
            return;
        }
        try {
            km = Integer.parseInt(txtKm.getText());
            if (km < 0) {
                hiba("Számformátum","A kilométer nem lehet negatív!");
                return;
            }
        } catch (NumberFormatException ex) {
            hiba("Számformátum","A kilométer nem szám!");
            return;
        }
        if (az < 1)
            ab.uj(cbxKiadas.getValue(), ar, dpDatum.getValue().toString(), 
                  km, txtMegjegyzes.getText());
        else {            
            ab.modosit(az, cbxKiadas.getValue(), ar, dpDatum.getValue().toString(), 
                       km, txtMegjegyzes.getText());
        }
        megse();
    }

    @FXML
    private void megse() {
        Window ablak = txtKm.getScene().getWindow();
        ablak.hide();
    }

    private int az;
    
    public void setEsemeny(Esemeny es) {
        this.az = es.getAz();
        cbxKiadas.setValue(es.getKiadas());
        txtAr.setText("" + es.getAr());
        dpDatum.setValue(LocalDate.parse(es.getDatum()));
        txtKm.setText("" + es.getKm());
        txtMegjegyzes.setText(es.getMegjegyzes());
    }
    
    private DB ab;
    
    public void setDB(DB ab) {
        this.ab = ab;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxKiadas.getItems().addAll("tankolás","biztosítás","javítás","parkolás");
    }    

    private void hiba(String cim, String uzenet) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(cim);
        alert.setHeaderText(null);
        alert.setContentText(uzenet);
        alert.showAndWait();
    }
        
}
