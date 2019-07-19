/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg08_szamologep;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author adamr
 */
public class SugoAblakController implements Initializable {

    @FXML
    private Button btnBezar;

    @FXML
    void bezarAction(ActionEvent event) {
        Window ablak = btnBezar.getScene().getWindow();
        ablak.hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
