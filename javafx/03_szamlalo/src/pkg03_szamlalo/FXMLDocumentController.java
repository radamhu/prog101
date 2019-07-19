package pkg03_szamlalo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class FXMLDocumentController implements Initializable {
    
    private int egyik=0;
    private int masik=0;
    
    @FXML
    private Label lblEgyik;

    @FXML
    private Label lblMasik;

    /**
     * A grafikus felületen a programok futását az események (events) irányítják. 
     * Ezek közül leggyakoribb, amikor a felhasználó rákattint valamire, például egy gombra. 
     * Ez egy ActionEvent. 
     * Az események kezelésére eseménykezelő osztályt kell létrehozni, 
     * amely implementálja az EventHandler<T> interface-t, 
     * a benne megadott handle metódus felülírásával.
     */
    @FXML
    void handleButtonAction1(ActionEvent event) {
        egyik++;
        lblEgyik.setText("" + egyik);
    }

    @FXML
    void handleButtonAction2(ActionEvent event) {
        masik++;
        lblMasik.setText("" + masik);
    } 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
