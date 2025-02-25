public class Main {
    public static void main(String[] args) {
        Departamento deptoIngenieria = new Departamento("Ingeniería", "D001");

        Tecnico emp1 = new Tecnico("Carlos Pérez" , "E001", deptoIngenieria);
        Gerente emp2 = new Gerente("Ana Gómez", "E002", deptoIngenieria);

        deptoIngenieria.agregarEmpleado(emp1);
        deptoIngenieria.agregarEmpleado(emp2);

        Proyecto proyecto = new Proyecto("Nuevo Sistema", "P001");
        proyecto.asignarEmpleado(emp1);
        proyecto.asignarEmpleado(emp2);

        System.out.println(emp1.contribuir());
        System.out.println(emp2.contribuir());
    }
}
