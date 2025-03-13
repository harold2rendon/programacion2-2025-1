package co.edu.uniquindio.poo;

/**
 * Hello world!
 *
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        GestorInterfaz gestorInterfaz = new GestorInterfaz();

        Scene scene = new Scene(gestorInterfaz.getVistaPrincipal(), 800, 600);
        primaryStage.setTitle("Gestión Hospitalaria");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



