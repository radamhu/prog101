/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLDocument;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author adamr
 */
public class fxml implements Initializable {

    @FXML
    private Label lblEgyik;
    @FXML
    private Button _Egyik;
    @FXML
    private Button _Másik;
    @FXML
    private Label lblMasik;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction1(ActionEvent event) {
    }

    @FXML
    private void handleButtonAction2(ActionEvent event) {
    }
    
}