package pkg02labels;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public abstract class FXMLLabelsController implements Initializable {
    
  @FXML
    void bezar(MouseEvent event) {
        Platform.exit();
    }    
}
