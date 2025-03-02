package Ejercicio1;
public class Gerente extends Empleado implements Contribuyete {
    private List<Proyecto> proyectosGestionados;

    public Gerente(String nombre, String idEmpleado, Departamento departamento) {
        super(nombre, idEmpleado, departamento);
    }

    public void gestionarProyecto() {
        System.out.println("Gestionando un proyecto...");
    }

    public String gestionarEquipo() {
        return nombre + " está gestionando su equipo.";
    }

    public void contribuir() {
        System.out.println("El Gerente gestiona proyectos y equipos.");
    }
}