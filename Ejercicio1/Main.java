package Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Proyecto proyecto = new Proyecto("Nuevo Software", 202, new ArrayList<>());

        Empleado empleado1 = new Tecnico("Luis", 3, null, "Seguridad Informática");
        Empleado empleado2 = new Gerente("Carlos", 4, null, new ArrayList<>());

        proyecto.asignarEmpleado(empleado1);
        proyecto.asignarEmpleado(empleado2);

        System.out.println("Empleados asignados al proyecto " + proyecto.getNombre() + ":");
        for (Empleado emp : proyecto.getEmpleados()) {
            System.out.println("- " + emp.nombre);
        }
    }
}
