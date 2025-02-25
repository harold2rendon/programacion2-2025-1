package Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Proyecto proyecto = new Proyecto("Desarrollo Web");

        Empleado gerente = new Gerente("Carlos", 1, "IT");
        Empleado tecnico1 = new Tecnico("Ana", 2, "IT");
        Empleado tecnico2 = new Tecnico("Luis", 3, "IT");

        proyecto.asignarEmpleado(gerente);
        proyecto.asignarEmpleado(tecnico1);
        proyecto.asignarEmpleado(tecnico2);

        proyecto.mostrarEmpleados();
    }
}