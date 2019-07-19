package pkg04_zaszlo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button spPiros;

    @FXML
    private Button spZold;

    @FXML
    private Button spFeher;

    @FXML
    void feherAction(ActionEvent event) {
        if (spPiros.getStyle().equals("-fx-background-color: white")) {
            spPiros.setStyle("-fx-background-color: #f4f4f4");
        }
        else
            spPiros.setStyle("-fx-background-color: white");
    }

    @FXML
    void pirosAction(ActionEvent event) {
      if (spPiros.getStyle().equals("-fx-background-color: red")) {
            spPiros.setStyle("-fx-background-color: #f4f4f4");
        }
        else
            spPiros.setStyle("-fx-background-color: red");
    }

    @FXML
    void zoldAction(ActionEvent event) {
      if (spPiros.getStyle().equals("-fx-background-color: green")) {
            spPiros.setStyle("-fx-background-color: #f4f4f4");
        }
        else
            spPiros.setStyle("-fx-background-color: red");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }       
}
