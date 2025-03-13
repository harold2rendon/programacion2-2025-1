package co.edu.uniquindio.poo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class GestorInterfazCopy {
    private ObservableList<Paciente> pacientes = FXCollections.observableArrayList();
    private ObservableList<String> doctores = FXCollections.observableArrayList();

    public BorderPane getVistaPrincipal() {
        // ListView para pacientes y doctores
        ListView<Paciente> listaPacientes = new ListView<>(pacientes);
        ListView<String> listaDoctores = new ListView<>(doctores);

        // Campos de texto
        TextField nombrePaciente = new TextField();
        TextArea historialMedico = new TextArea();
        TextField nombreDoctor = new TextField();

        // Botones
        Button agregarPacienteBtn = new Button("Agregar Paciente");
        Button eliminarPacienteBtn = new Button("Eliminar Paciente");
        Button actualizarHistorialBtn = new Button("Actualizar Historial");
        Button agregarDoctorBtn = new Button("Agregar Doctor");
        Button eliminarDoctorBtn = new Button("Eliminar Doctor");

        // Eventos de los botones
        agregarPacienteBtn.setOnAction(e -> {
            String nombre = nombrePaciente.getText().trim();
            String historial = historialMedico.getText().trim();
            if (!nombre.isEmpty() && !pacientes.stream().anyMatch(p -> p.getNombre().equals(nombre))) {
                pacientes.add(new Paciente(nombre, 0, historial, historial));
                nombrePaciente.clear();
                historialMedico.clear();
            } else {
                mostrarAlerta("Error", "El nombre del paciente no puede estar vacío o duplicado.");
            }
        });

        eliminarPacienteBtn.setOnAction(e -> {
            Paciente seleccionado = listaPacientes.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                pacientes.remove(seleccionado);
            } else {
                mostrarAlerta("Error", "Seleccione un paciente para eliminar.");
            }
        });

        actualizarHistorialBtn.setOnAction(e -> {
            Paciente seleccionado = listaPacientes.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                seleccionado.setHistorialEnfermedades(historialMedico.getText().trim());
            } else {
                mostrarAlerta("Error", "Seleccione un paciente para actualizar el historial.");
            }
        });

        agregarDoctorBtn.setOnAction(e -> {
            String nombre = nombreDoctor.getText().trim();
            if (!nombre.isEmpty() && !doctores.contains(nombre)) {
                doctores.add(nombre);
                nombreDoctor.clear();
            } else {
                mostrarAlerta("Error", "El nombre del doctor no puede estar vacío o duplicado.");
            }
        });

        eliminarDoctorBtn.setOnAction(e -> {
            String seleccionado = listaDoctores.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                doctores.remove(seleccionado);
            } else {
                mostrarAlerta("Error", "Seleccione un doctor para eliminar.");
            }
        });

        listaPacientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                historialMedico.setText(newSelection.getHistorialEnfermedades());
            }
        });

        // Diseño de la interfaz
        VBox pacientesBox = new VBox(10, new Label("Pacientes"), nombrePaciente, historialMedico, agregarPacienteBtn, eliminarPacienteBtn, actualizarHistorialBtn, listaPacientes);
        VBox doctoresBox = new VBox(10, new Label("Doctores"), nombreDoctor, agregarDoctorBtn, eliminarDoctorBtn, listaDoctores);
        HBox contenedor = new HBox(20, pacientesBox, doctoresBox);

        BorderPane root = new BorderPane();
        root.setCenter(contenedor);

        return root;
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}