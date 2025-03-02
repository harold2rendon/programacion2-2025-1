package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Departamento departamento = new Departamento("Desarrollo", 101, new ArrayList<>());

        Empleado empleado1 = new Tecnico("Juan", 1, departamento, "Redes");
        Empleado empleado2 = new Gerente("María", 2, departamento, new ArrayList<>());

        departamento.agregarEmpleado(empleado1);
        departamento.agregarEmpleado(empleado2);

        System.out.println("Empleados en el departamento " + departamento.getNombre() + ":");
        for (Empleado emp : departamento.getEmpleados()) {
            System.out.println("- " + emp.nombre);
        }
    }
}
