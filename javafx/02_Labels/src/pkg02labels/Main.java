package pkg02labels;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    public void start(Stage stage) throws Exception {
        // A start metódus először betölti az FXML fájlt tartalmát egy Parent típusú root elembe. 
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLabels.fxml"));
        // Ezután készít egy jelenetet belőle, 
        Scene scene = new Scene(root);
        // és megjeleníti egy ablakban.
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
