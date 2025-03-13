package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;

public class PacienteController {
    private List<Paciente> pacientes = new ArrayList<>();

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void eliminarPaciente(String nombre) {
        pacientes.removeIf(p -> p.getNombre().equals(nombre));
    }

    public Paciente buscarPaciente(String nombre) {
        return pacientes.stream().filter(p -> p.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }
}

