package Ejercicio2;

class Gerente extends Empleado {
    public Gerente(String nombre, int id, String departamento) {
        super(nombre, id, departamento);
    }

    @Override
    public void contribuir() {
        System.out.println(nombre + " está supervisando el proyecto.");
    }
}