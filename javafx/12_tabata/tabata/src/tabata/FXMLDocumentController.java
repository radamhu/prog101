/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabata;

import java.applet.AudioClip;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

/**
 *
 * @author adamr
 */
public class FXMLDocumentController implements Initializable {

    private Beallitas b;
    private ArrayList<Szakasz> szakaszok = new ArrayList<>();
    private int tabata, ciklus;
    private char elozo;
    private Timeline idovonal;
    private AudioClip clip;

    @FXML
    private Label lblFelso;

    @FXML
    private TextField txtIdo;

    @FXML
    private TextField txtTabata;

    @FXML
    private TextField txtCiklus;

    @FXML
    private Spinner<Integer> spTabata;

    @FXML
    private Spinner<Integer> spCiklus;

    @FXML
    private Spinner<Integer> spGyak;

    @FXML
    private Spinner<Integer> spPihen;

    @FXML
    void indit() {

    }

    @FXML
    void mentes() {
        b.ment();
    }

    private String ido(int t) {
        String s;
        int perc = t /60;
        int mp = t % 60;
        if (perc < 10) {
            s = "0" + perc + ":";
        } else {
            s = "" + perc + ":";
        }
        if (mp < 10) {
            s += "0" + mp;
        } else {
            s += "" + mp;
        }
        return s;
    }

    private void osszerak() {
        szakaszok.clear();
        int hossz = 0;
        tabata = b.getTabata();
        ciklus = b.getCiklus();
        for (int i = 0; i < tabata; i++) {
            szakaszok.add(new Szakasz('E', 10));
            hossz += 10;
            for (int j = 0; j < ciklus; j++) {
                szakaszok.add(new Szakasz('g', b.getGyak()));
                szakaszok.add(new Szakasz('p', b.getPihen()));
                hossz += b.getGyak() + b.getPihen();
            }
        }
        lblFelso.setText("Összesen:");
        txtIdo.setStyle("-fx-background-colort: white");
        txtIdo.setText("" + ido(hossz));
        txtTabata.setText("" + tabata);
        txtTabata.setText("" + ciklus);
    }

    private void beallit() {
        b.setTabata(spTabata.getValue());
        b.setCiklus(spCiklus.getValue());
        b.setGyak(spGyak.getValue());
        b.setPihen(spPihen.getValue());
        osszerak();
    }

    private void megallit() {
        idovonal.stop();
        spTabata.setDisable(false);
        spCiklus.setDisable(false);
        spGyak.setDisable(false);
        spPihen.setDisable(false);
        btnMent.setDisab
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        b = new Beallitas();
        spTabata.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,8,b.getTabata()));
        spCiklus.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,16, b.getCiklus()));
        spGyak.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(20, 45, b.getGyak()));
        spPihen.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 30, b.getPihen()));
        clip = new AudioClip(getClass().getResource("horn.wav").toString());
    }
}
