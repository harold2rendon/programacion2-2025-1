package co.edu.uniquindio.poo;

public class Paciente implements cloneable {
    private String nombre;
    private int edad;
    private String historialEnfermedades;
    private String medicamentos;

    public Paciente(String nombre, int edad, String historialEnfermedades, String medicamentos) {
        this.nombre = nombre;
        this.edad = edad;
        this.historialEnfermedades = historialEnfermedades;
        this.medicamentos = medicamentos;
    }
    public Paciente clone(){
        try {
            return (Paciente) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getHistorialEnfermedades() {
        return historialEnfermedades;
    }

    public void setHistorialEnfermedades(String historialEnfermedades) {
        this.historialEnfermedades = historialEnfermedades;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }
    
}
