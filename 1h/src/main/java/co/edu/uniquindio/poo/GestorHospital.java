package co.edu.uniquindio.poo;

// clase de gestion del hospital (singleton)

public class GestorHospital {
    private static GestorHospital instance;
    private String horarioAtencion;
    private int maxPacientesPorMedico;
    private String reglasFacturacion;

    public GestorHospital() {
        this.horarioAtencion = "08:00 - 20:00";
        this.maxPacientesPorMedico = 10;
        this.reglasFacturacion = "Estandar";
    }
    public static GestorHospital getInstance() {
        if (instance == null) {
            instance = new GestorHospital();
        }
        return instance;
    }
    public String getHorarioAtencion() {
        return horarioAtencion;
    }
    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }
    public int getMaxPacientesPorMedico() {
        return maxPacientesPorMedico;
    }
    public void setMaxPacientesPorMedico(int maxPacientesPorMedico) {
        this.maxPacientesPorMedico = maxPacientesPorMedico;
    }
    public String getReglasFacturacion() {
        return reglasFacturacion;
    }
    public void setReglasFacturacion(String reglasFacturacion) {
        this.reglasFacturacion = reglasFacturacion;
    }
}
    