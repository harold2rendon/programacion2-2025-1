package Ejercicio2;

public class Tecnico extends Empleado implements Contribuyente {
    
    private String especialidad;

    public Tecnico(String nombre, String idEmpleado, Departamento departamento) {
            super(nombre, idEmpleado, departamento);
            this.especialidad = especialidad;
        }
    public void realizarTarea() {
        System.out.println(nombre  + "Realiza una tarea técnica...");
    }
    
    public void contribuir() {
        System.out.println(nombre  + " ejecuta tareas técnicas.");
    }

    public String getEspecialidad() { 
        return especialidad; 
    }
}
