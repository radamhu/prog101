package pkg05_berkalkulator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtBrutto;

    @FXML
    private CheckBox chkFiatal;

    @FXML
    private RadioButton rb0;

    @FXML
    private ToggleGroup gyerekCsoport;

    @FXML
    private RadioButton rb1;

    @FXML
    private RadioButton rb2;

    @FXML
    private TextField txtLevon;

    @FXML
    private TextField txtNetto;

    @FXML
    void kilepAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void szamolAction(ActionEvent event) {
        try {
            int brutto = Integer.parseInt(txtBrutto.getText());
            int ado = (int)Math.round(0.15 * brutto);
            if (chkFiatal.isSelected()) 
                ado -= 5000;
            if (rb1.isSelected())
                ado -= 10000;
            else if (rb2.isSelected())
                ado -= 35000;
            int egyeb = (int)Math.round(0.185 * brutto);
            if (ado < 0) {
                egyeb = egyeb + ado;
                ado = 0;
                int szakkepzesi = (int)Math.round(0.015 * brutto);
                if (egyeb < szakkepzesi)
                    egyeb = szakkepzesi;
            }
            txtLevon.setText("" + (ado + egyeb));
            txtNetto.setText("" + (brutto - ado - egyeb));
        } catch (NumberFormatException nfe) {
            txtLevon.setText("Hibás adat");
            txtNetto.setText("Hibás adat");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
