package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

// Parte visual de la aplicación

public class GestorInterfaz {
    private TextField pacienteField;
    private TextField doctorField;
    private DatePicker fechaPicker;
    private TextArea resultadoArea;
    private TextArea historialArea;

    public VBox getVistaPrincipal() {
        Label pacienteLabel = new Label("Paciente:");
        pacienteField = new TextField();
        
        Label doctorLabel = new Label("Doctor:");
        doctorField = new TextField();
        
        Label fechaLabel = new Label("Fecha:");
        fechaPicker = new DatePicker();
        
        Label historialLabel = new Label("Historial Médico:");
        historialArea = new TextArea();
        
        Button agregarCitaBtn = new Button("Agregar Cita");
        Button listarCitasBtn = new Button("Listar Citas");
        Button cancelarCitaBtn = new Button("Cancelar Cita");
        Button listarPalindromosBtn = new Button("Pacientes Palíndromos");
        Button listarVocalesIgualesBtn = new Button("Pacientes con Vocales Iguales");
        Button historialBtn = new Button("Ver Historial Médico");
        Button agregarHistorialBtn = new Button("Agregar Historial Médico");
        
        resultadoArea = new TextArea();
        resultadoArea.setEditable(false);

        agregarCitaBtn.setOnAction(e -> agregarCita());
        listarCitasBtn.setOnAction(e -> listarCitas());
        cancelarCitaBtn.setOnAction(e -> cancelarCita());
        listarPalindromosBtn.setOnAction(e -> listarPacientesPalindromos());
        listarVocalesIgualesBtn.setOnAction(e -> listarPacientesVocalesIguales());
        historialBtn.setOnAction(e -> verHistorialMedico());
        agregarHistorialBtn.setOnAction(e -> agregarHistorialMedico());
        
        VBox root = new VBox(10, pacienteLabel, pacienteField, doctorLabel, doctorField, 
                fechaLabel, fechaPicker, historialLabel, historialArea, agregarCitaBtn, listarCitasBtn, cancelarCitaBtn, 
                listarPalindromosBtn, listarVocalesIgualesBtn, historialBtn, agregarHistorialBtn, resultadoArea);
        root.setPadding(new Insets(10));
        
        return root;
    }

    private void agregarCita() {
        String paciente = pacienteField.getText();
        String doctor = doctorField.getText();
        LocalDate fecha = fechaPicker.getValue();
        if (paciente.isEmpty() || doctor.isEmpty() || fecha == null) {
            resultadoArea.setText("Por favor, complete todos los campos.");
            return;
        }
        Cita cita = new Cita(paciente, doctor, fecha);
        CitaDAO.agregarCita(cita);
        resultadoArea.setText("Cita agregada correctamente.");
    }

    private void listarCitas() {
        resultadoArea.setText("Listado de Citas:\n");
        for (Cita c : CitaDAO.obtenerCitas()) {
            resultadoArea.appendText(c.getPaciente() + " - " + c.getDoctor() + " - " + c.getFecha() + "\n");
        }
    }

    private void cancelarCita() {
        String paciente = pacienteField.getText();
        String doctor = doctorField.getText();
        LocalDate fecha = fechaPicker.getValue();
        if (paciente.isEmpty() || doctor.isEmpty() || fecha == null) {
            resultadoArea.setText("Ingrese los datos de la cita a cancelar.");
            return;
        }
        CitaDAO.cancelarCita(paciente, doctor, fecha.toString());
        resultadoArea.setText("Cita cancelada correctamente.");
    }

    private void listarPacientesPalindromos() {
        resultadoArea.setText("Pacientes con nombres palíndromos:\n");
        List<String> palindromos = CitaDAO.obtenerPacientesConNombresPalindromos();
        for (String nombre : palindromos) {
            resultadoArea.appendText(nombre + "\n");
        }
    }

    private void listarPacientesVocalesIguales() {
        resultadoArea.setText("Pacientes con todas las vocales iguales:\n");
        List<String> vocalesIguales = CitaDAO.obtenerPacientesConVocalesIguales();
        for (String nombre : vocalesIguales) {
            resultadoArea.appendText(nombre + "\n");
        }
    }

    private void verHistorialMedico() {
        String paciente = pacienteField.getText();
        if (paciente.isEmpty()) {
            resultadoArea.setText("Ingrese el nombre del paciente.");
            return;
        }
        resultadoArea.setText("Historial médico de " + paciente + ":\n");
        List<String> historial = CitaDAO.obtenerHistorialMedico(paciente);
        for (String entrada : historial) {
            resultadoArea.appendText(entrada + "\n");
        }
    }

    private void agregarHistorialMedico() {
        String paciente = pacienteField.getText();
        String historial = historialArea.getText();
        if (paciente.isEmpty() || historial.isEmpty()) {
            resultadoArea.setText("Por favor, complete todos los campos.");
            return;
        }
        CitaDAO.agregarHistorialMedico(paciente, historial);
        resultadoArea.setText("Historial médico agregado correctamente.");
    }
}