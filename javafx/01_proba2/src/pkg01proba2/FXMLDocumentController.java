package pkg01proba2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    /**
     * A grafikus felületen a programok futását az események (events) irányítják. 
     * Ezek közül leggyakoribb, amikor a felhasználó rákattint valamire, például egy gombra. 
     * Ez egy ActionEvent. 
     * Az események kezelésére eseménykezelő osztályt kell létrehozni, 
     * amely implementálja az EventHandler<T> interface-t, 
     * a benne megadott handle metódus felülírásával.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
