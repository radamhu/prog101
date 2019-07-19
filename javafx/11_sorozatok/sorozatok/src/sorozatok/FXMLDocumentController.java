/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorozatok;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author adamr
 */
public class FXMLDocumentController implements Initializable {


    @FXML
    private TextField txtCim;

    @FXML
    private Spinner<Integer> spEvad;

    @FXML
    private Spinner<Integer> spResz;

    @FXML
    private TableView<Sorozat> tblSorozatok;

    @FXML
    private TableColumn<Sorozat, String> oCim;

    @FXML
    private TableColumn<Sorozat, Integer> oEvad;

    @FXML
    private TableColumn<Sorozat, Integer> oResz;
    
    @FXML
    void hozzaad() {
        if (!txtCim.getText().isEmpty()) {
            Sorozat s = new Sorozat();
            s.setCim(txtCim.getText());
            s.setEvad(spEvad.getValue());
            s.setResz(spResz.getValue());
            tblSorozatok.getItems().add(s);
            int utolso = tblSorozatok.getItems().size()-1;
            tblSorozatok.getSelectionModel().select(utolso);
        }
        txtCim.requestFocus();
    }

    @FXML
    void leptet() {

    }

    @FXML
    void modosit() {

    }

    @FXML
    void torol() {

    }

    @FXML
    void ujsorozat() {

    }

    @FXML
    void web(MouseEvent event) {

    }    

    public void betolt(ObservableList<Sorozat> lista){
        try (Scanner be = new Scanner(new File("sorozatok.txt"), "utf8")) {
            while (be.hasNextLine()) {                
                lista.add(new Sorozat(be.nextLine()));
            }
        } catch (IOException ex) {
        }
    }
    
    public void beallit(Sorozat s) {
        txtCim.setText(s.getCim());
        spEvad.getValueFactory().setValue(s.getEvad());
        spResz.getValueFactory().setValue(s.getResz());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spEvad.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 30, 1));
        spResz.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 30, 1));
        oCim.setCellValueFactory(new PropertyValueFactory<>("cim"));
        oEvad.setCellValueFactory(new PropertyValueFactory<>("evad"));
        oResz.setCellValueFactory(new PropertyValueFactory<>("resz"));
        betolt(tblSorozatok.getItems());
        tblSorozatok.getSelectionModel().selectedItemProperty().addListener(
                (o, regi, uj) -> {
                    if (uj != nu) {
                    
                }
        );
    }
}
