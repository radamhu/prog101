/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg09_karacsony;


import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import static javafx.animation.Animation.INDEFINITE;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;

/**
 *
 * @author adamr
 */
public class FXMLDocumentController implements Initializable {
    AudioClip clip;

    @FXML
    private Label lblNapok;

    @FXML
    void megallit(MouseEvent event) {
        if (clip.isPlaying()) {
            clip.stop();
        } else {
            clip.play();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LocalDate ma = LocalDate.now();
        LocalDate karacsony = LocalDate.of(ma.getYear(), 12, 24);
        long napok = ChronoUnit.DAYS.between(ma, karacsony);
        if (napok > 0)
            lblNapok.setText(napok + " nap van hátra karácsonyig");
        else if (napok <= 0 && napok>= -2)
            lblNapok.setText("Most van karácsony");
        else
            lblNapok.setText("Elmúlt karácsony");

        clip = new AudioClip(getClass().getResource("JB.wav").toString()) {};
        clip.setCycleCount(INDEFINITE);
        clip.play();
    }

}
