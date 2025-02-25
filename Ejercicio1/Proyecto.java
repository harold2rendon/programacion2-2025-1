package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

class Proyecto {
    private String nombre;
    private List<Empleado> empleados;
    private static final int LIMITE_EMPLEADOS = 5; 

    public Proyecto(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public boolean asignarEmpleado(Empleado empleado) {
        if (empleados.size() < LIMITE_EMPLEADOS) {
            empleados.add(empleado);
            System.out.println(empleado.getNombre() + " ha sido asignado al proyecto " + nombre);
            return true;
        } else {
            System.out.println("No se puede asignar más empleados al proyecto " + nombre);
            return false;
        }
    }

    public void mostrarEmpleados() {
        System.out.println("Empleados asignados al proyecto " + nombre + ":");
        for (Empleado e : empleados) {
            System.out.println("- " + e.getNombre());
        }
    }

    @Override
    public String toString() {
        return "Proyecto: " + nombre + " | Empleados asignados: " + empleados.size();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public static int getLimiteEmpleados() {
        return LIMITE_EMPLEADOS;
    }
    
}