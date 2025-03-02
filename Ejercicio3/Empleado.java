abstract class Empleado implements Contribuyente{
    protected String nombre;
    protected String idEmpleado;
    protected Departamento departamento;

    public Empleado(String nombre, String idEmpleado, Departamento departamento) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
        this.departamento = departamento;
    }

    public abstract void contribuir();  //Liskov (L) garantiza que las subclases lo implementen
}