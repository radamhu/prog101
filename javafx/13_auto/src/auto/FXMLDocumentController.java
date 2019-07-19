package auto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Joe
 */
public class FXMLDocumentController implements Initializable {
    DB ab = new DB();
    
    @FXML
    private TableView<Esemeny> tblKiadasok;

    @FXML
    private TableColumn<Esemeny, String> oKiadas;

    @FXML
    private TableColumn<Esemeny, Integer> oAr;

    @FXML
    private TableColumn<Esemeny, String> oDatum;

    @FXML
    private TableColumn<Esemeny, Integer> oKm;

    @FXML
    private TableColumn<Esemeny, String> oMegjegyzes;

    @FXML
    private Label lblOsszesen;
    
    @FXML
    void modosit() throws Exception {
        int i = tblKiadasok.getSelectionModel().getSelectedIndex();
        if (i > -1) {
            ablak("Módosítás", i);
            ab.betolt(tblKiadasok.getItems());
            tblKiadasok.getSelectionModel().select(i);
        }
        szamol();
    }

    @FXML
    void torol() {
        int i = tblKiadasok.getSelectionModel().getSelectedIndex();
        if (i > -1) {
            int az = tblKiadasok.getItems().get(i).getAz();
            ab.torol(az);
            ab.betolt(tblKiadasok.getItems());
            int utolso = tblKiadasok.getItems().size()-1;
            if (i <= utolso)
                tblKiadasok.getSelectionModel().select(i);
            else if (i > 0)
                tblKiadasok.getSelectionModel().select(i-1);
        }
        szamol();
    }

    @FXML
    void uj() throws Exception {
        ablak("Új esemény", -1);
        ab.betolt(tblKiadasok.getItems());
        int utolso = tblKiadasok.getItems().size()-1;
        tblKiadasok.getSelectionModel().select(utolso);
        szamol();
    }    
    
    private void ablak(String cim, int i) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ablak.fxml"));
        Parent root = loader.load();        

        AblakController ac = loader.getController();
        if (i > -1) {
            ac.setEsemeny(tblKiadasok.getItems().get(i));
        }
        else {
            ac.setEsemeny(new Esemeny(0, "tankolás", 0, 
                          LocalDate.now().toString(), 0, ""));
        }
        ac.setDB(ab);
        
        Scene scene = new Scene(root);        
        Stage ablak = new Stage();
        ablak.setResizable(false);
        ablak.initModality(Modality.APPLICATION_MODAL);
        ablak.setScene(scene);
        ablak.setTitle(cim);       
        ablak.showAndWait();   
    }
    
    private void szamol() {
        int osszeg = 0;
        for (Esemeny es : tblKiadasok.getItems()) {
            osszeg += es.getAr();
        }
        lblOsszesen.setText("Összesen:\n" + osszeg + " Ft");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        oKiadas.setCellValueFactory(new PropertyValueFactory<>("kiadas"));
        oAr.setCellValueFactory(new PropertyValueFactory<>("ar"));
        oDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        oKm.setCellValueFactory(new PropertyValueFactory<>("km"));
        oMegjegyzes.setCellValueFactory(new PropertyValueFactory<>("megjegyzes"));
        
        ab.betolt(tblKiadasok.getItems());   
        szamol();
    }        
}
