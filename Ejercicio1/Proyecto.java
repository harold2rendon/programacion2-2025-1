package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private String nombre;
    private String codigo;
    private List<Empleado> listaEmpleadosAsignados;

    public Proyecto(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.listaEmpleadosAsignados = new ArrayList<>();
    }

    public void asignarEmpleado(Empleado empleado) {
        listaEmpleadosAsignados.add(empleado);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    } 
}