package co.edu.uniquindio.poo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

// Gestion de la interfaz

public class GestorInterfaz {
    private ObservableList<String> pacientes = FXCollections.observableArrayList();
    private ObservableList<String> doctores = FXCollections.observableArrayList();

    public BorderPane getVistaPrincipal() {
        // ListView para pacientes y doctores
        ListView<String> listaPacientes = new ListView<>(pacientes);
        ListView<String> listaDoctores = new ListView<>(doctores);

        // Campos de texto
        TextField nombrePaciente = new TextField();
        TextField nombreDoctor = new TextField();

        // Botones
        Button agregarPacienteBtn = new Button("Agregar Paciente");
        Button eliminarPacienteBtn = new Button("Eliminar Paciente");
        Button agregarDoctorBtn = new Button("Agregar Doctor");
        Button eliminarDoctorBtn = new Button("Eliminar Doctor");

        // Eventos de los botones
        agregarPacienteBtn.setOnAction(e -> {
            if (!nombrePaciente.getText().isEmpty()) {
                pacientes.add(nombrePaciente.getText());
                nombrePaciente.clear();
            }
        });

        eliminarPacienteBtn.setOnAction(e -> {
            int index = listaPacientes.getSelectionModel().getSelectedIndex();
            if (index != -1) pacientes.remove(index);
        });

        agregarDoctorBtn.setOnAction(e -> {
            if (!nombreDoctor.getText().isEmpty()) {
                doctores.add(nombreDoctor.getText());
                nombreDoctor.clear();
            }
        });

        eliminarDoctorBtn.setOnAction(e -> {
            int index = listaDoctores.getSelectionModel().getSelectedIndex();
            if (index != -1) doctores.remove(index);
        });

        // Diseño de la interfaz
        VBox pacientesBox = new VBox(10, new Label("Pacientes"), nombrePaciente, agregarPacienteBtn, eliminarPacienteBtn, listaPacientes);
        VBox doctoresBox = new VBox(10, new Label("Doctores"), nombreDoctor, agregarDoctorBtn, eliminarDoctorBtn, listaDoctores);
        HBox contenedor = new HBox(20, pacientesBox, doctoresBox);

        BorderPane root = new BorderPane();
        root.setCenter(contenedor);

        return root;
    }
}
