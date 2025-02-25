public class Gerente extends Empleado{
    
    public Gerente(String nombre, String idEmpleado, Departamento departamento) {
        super(nombre, idEmpleado, departamento);
    }

    public String gestionarProyectos() {
        return nombre + " está gestionando proyectos.";
    }

    public String gestionarEquipo() {
        return nombre + " está gestionando su equipo.";
    }

    @Override
    public String contribuir() {
        return gestionarProyectos();
    }
}