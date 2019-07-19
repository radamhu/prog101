/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gepnaplo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author adamr
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ComboBox<String> cbxIskola;

    @FXML
    private TextField txtOsztaly;

    @FXML
    private TextField txtNev;

    @FXML
    private TextField txtAllapot;

    @FXML
    void kesz() {
        String iskola = Seged.levag(cbxIskola.getValue().trim(),40);
        String osztaly = Seged.levag(txtOsztaly.getText().trim(), 8);
        String nev = Seged.levag(txtNev.getText().trim(), 50);
        String allapot = Seged.levag(txtAllapot.getText().trim(), 50);
        if (iskola.isEmpty() || osztaly.isEmpty() ||
                nev.isEmpty() || allapot.isEmpty()) {
                return;
        }
        DB ab = new DB();
        ab.beir(iskola, osztaly, nev, allapot);
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxIskola.getItems().add("BKSZC Pogány Frigyes Szakgimnázium");
        cbxIskola.getItems().add("Vörösmarty Mihály Gimnázium");
        cbxIskola.getItems().add("Weöres Sándor Általános iskola");
        cbxIskola.setValue("BKSZC Pogány Frigyes Szakgimánzium");
    }

}
