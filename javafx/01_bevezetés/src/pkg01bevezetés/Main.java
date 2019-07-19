package pkg01bevezetés;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // gomb létrehozása
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        /**
         * A grafikus felületen a programok futását az események (events) irányítják. 
         * Ezek közül leggyakoribb, amikor a felhasználó rákattint valamire, például egy gombra. 
         * Ez egy ActionEvent. 
         * Az események kezelésére eseménykezelő osztályt kell létrehozni, 
         * amely implementálja az EventHandler<T> interface-t, 
         * a benne megadott handle metódus felülírásával.
         */
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        // root node létrehozása
        StackPane root = new StackPane();
        // gomb hozzáadása a root node-hoz
        root.getChildren().add(btn);
        
        // új jelenet létrehozása
        Scene scene = new Scene(root, 300, 250);
        
        // ablak címének beállítása
        primaryStage.setTitle("Hello World!");
        // jelenet beállítása
        primaryStage.setScene(scene);
        // ablak megjelenítése
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
