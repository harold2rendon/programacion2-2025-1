package co.edu.uniquindio.poo;

import java.time.LocalDate;


public class Cita {
    private String paciente;
    private String doctor;
    private LocalDate fecha;

    // Constructor
    public Cita(String paciente, String doctor, LocalDate fecha) {
        this.paciente = paciente;
        this.doctor = doctor;
        this.fecha = fecha;
    }

    // Getters
    public String getPaciente() {
        return paciente;
    }

    public String getDoctor() {
        return doctor;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
