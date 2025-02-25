package Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Departamento TI = new Departamento("TI");
        Departamento RRHH = new Departamento("RRHH");

        Empleado empleado = new Tecnico("Lucas", 3, "TI");
        TI.agregarEmpleado(empleado);

        TI.removerEmpleado(empleado);
        RRHH.agregarEmpleado(empleado);
    }
}