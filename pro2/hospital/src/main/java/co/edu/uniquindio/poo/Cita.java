package co.edu.uniquindio.poo;

import java.time.LocalDate;

public class Cita {
    private Paciente paciente;
    private Doctor doctor;
    private LocalDate fecha;

    public Cita(Paciente paciente, Doctor doctor, LocalDate fecha) {
        this.paciente = paciente;
        this.doctor = doctor;
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}

