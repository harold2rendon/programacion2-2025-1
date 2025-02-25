package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

class Departamento {
    private String nombre;
    private List<Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        System.out.println(empleado.getNombre() + " agregado al departamento " + nombre);
    }

    public void removerEmpleado(Empleado empleado) {
        empleados.remove(empleado);
        System.out.println(empleado.getNombre() + " removido del departamento " + nombre);
    }

    public String getNombre() {
        return nombre;
    }
}