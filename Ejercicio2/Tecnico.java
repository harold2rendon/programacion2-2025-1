package Ejercicio2;

class Tecnico extends Empleado {
    public Tecnico(String nombre, int id, String departamento) {
        super(nombre, id, departamento);
    }

    @Override
    public void contribuir() {
        System.out.println(nombre + " está desarrollando una tarea técnica.");
    }
}