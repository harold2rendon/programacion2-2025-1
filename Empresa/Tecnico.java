public class Tecnico extends Empleado {

    public Tecnico(String nombre, String idEmpleado, Departamento departamento) {
            super(nombre, idEmpleado, departamento);
        }
    public String realizarTareaTecnica(){
        return nombre + "esta realizando una tarea tecnica.";
    }
    
    public String contribuir() {
        return realizarTareaTecnica();
    }
}
