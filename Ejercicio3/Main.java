public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Tecnico("Ana", 5, null, "Bases de Datos"));
        empleados.add(new Gerente("Pedro", 6, null, new ArrayList<>()));

        for (Empleado emp : empleados) {
            System.out.println(emp.nombre + " contribuye de la siguiente manera:");
            emp.contribuir();
            System.out.println();
        }
    }
}
