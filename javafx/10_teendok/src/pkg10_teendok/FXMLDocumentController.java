/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_teendok;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author adamr
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtUjFeladat;

    @FXML
    private ListView<String> lstFeladatok;

    @FXML
    void elejere() {
        int i = lstFeladatok.getSelectionModel().getSelectedIndex();
        if (i > 0) {
            String f = lstFeladatok.getItems().get(i);
            lstFeladatok.getItems().remove(i);
            lstFeladatok.getItems().add(0, f);
            lstFeladatok.getSelectionModel().select(0);
        }
        lstFeladatok.requestFocus();
    }

    @FXML
    void fel() {
        int i = lstFeladatok.getSelectionModel().getSelectedIndex();
        if (i > 0) {
            String f = lstFeladatok.getItems().get(i);
            lstFeladatok.getItems().remove(i);
            lstFeladatok.getItems().add(i-1, f);
            lstFeladatok.getSelectionModel().select(i-1);
        }
        lstFeladatok.requestFocus();
    }

    @FXML
    void hozzaad() {
        String feladat = txtUjFeladat.getText();
        if (!feladat.isEmpty()) {
            lstFeladatok.getItems().add(feladat);
            int utolso = lstFeladatok.getItems().size()-1;
            lstFeladatok.getSelectionModel().select(utolso);
        }
        txtUjFeladat.requestFocus();
        txtUjFeladat.selectAll();
    }

    @FXML
    void kilep() {

    }

    @FXML
    void le() {
        int i = lstFeladatok.getSelectionModel().getSelectedIndex();
        int utolso = lstFeladatok.getItems().size()-1;
        if (i > -1 && i < utolso ) {
            String f = lstFeladatok.getItems().get(i);
            lstFeladatok.getItems().remove(i);
            lstFeladatok.getItems().add(i+1, f);
            lstFeladatok.getSelectionModel().select(i+1);
        }
        lstFeladatok.requestFocus();
    }

    @FXML
    void modosit() {
        int i = lstFeladatok.getSelectionModel().getSelectedIndex();
        if (i > -1) {
            lstFeladatok.getItems().set(i, txtUjFeladat.getText());
        }
        txtUjFeladat.requestFocus();
        txtUjFeladat.selectAll();
    }

    @FXML
    void torol() {
        int i = lstFeladatok.getSelectionModel().getSelectedIndex();
        if ( i > -1 ) {
            lstFeladatok.getItems().remove(i);
        }
        lstFeladatok.requestFocus();
    }

    @FXML
    void vegere() {
        int i = lstFeladatok.getSelectionModel().getSelectedIndex();
        int utolso = lstFeladatok.getItems().size()-1;
        if (i > -1 && i < utolso) {
            String f = lstFeladatok.getItems().get(i);
            lstFeladatok.getItems().remove(i);
            lstFeladatok.getItems().add(f);
            lstFeladatok.getSelectionModel().select(utolso);
        }
        lstFeladatok.requestFocus();
    }
    
    private boolean ment() {
        try ( PrinterWriter ki = new PrinterWriter("teendok.txt","utf8")) {
            for (String f : lstFeladatok.getItems()) 
                ki.println(f);
            
        } catch (Exception e) {
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lstFeladatok.getSelectionModel().selectedItemProperty().addListener(
            (v, regi, uj ) -> {
                if (uj != null) 
                    txtUjFeladat.setText(uj);
                else
                    txtUjFeladat.setText("");
            }
        );
    }    
}
