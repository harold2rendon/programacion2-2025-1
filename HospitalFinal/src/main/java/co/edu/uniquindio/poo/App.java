package co.edu.uniquindio.poo;

// Clase principal de la aplicación

 import javafx.application.Application;
 import javafx.scene.Scene;
 import javafx.stage.Stage;
 
 public class App extends Application {
     @Override
     public void start(Stage primaryStage) {
         try {
             GestorInterfaz gestorInterfaz = new GestorInterfaz();
             Scene scene = new Scene(gestorInterfaz.getVistaPrincipal(), 800, 600);
             primaryStage.setTitle("Gestión Hospitalaria");
             primaryStage.setScene(scene);
             primaryStage.show();
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 
     public static void main(String[] args) {
         launch(args);
     }
 }



