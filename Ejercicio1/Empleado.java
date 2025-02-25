package Ejercicio1;

abstract class Empleado {
    protected String nombre;
    protected int id;
    protected String departamento;

    public Empleado(String nombre, int id, String departamento) {
        this.nombre = nombre;
        this.id = id;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void contribuir();
}
