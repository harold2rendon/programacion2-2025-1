package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;

public class PacienteCRUD {
    private List<Paciente> pacientes = new ArrayList<>();
    
    public void agregarPacientes(Paciente p){
        pacientes.add(p);
    }
    public void eliminarPaciente(String nombre){
        pacientes.removeIf(p -> p.getNombre().equals(nombre));
    }
    public List<Paciente> listarPacientes(){
        return pacientes;
    }
}
