package co.edu.uniquindio.poo;

public class GestorConfiguracion {
    private static GestorConfiguracion instancia;
    private String horarioAtencion;
    private int maxPacientesPorMedico;
    private String reglasFacturacion;

    public GestorConfiguracion(String horarioAtencion, int maxPacientesPorMedico, String reglasFacturacion) {
        this.horarioAtencion = "08:00 - 18:00";
        this.maxPacientesPorMedico = 10;
        this.reglasFacturacion = reglasFacturacion;

    }
    public static GestorConfiguracion getInstancia(){
        if (instancia == null) {
            instancia = new GestorConfiguracion(null, 0, null);
        }
        return instancia;
    }
    public static void setInstancia(GestorConfiguracion instancia) {
        GestorConfiguracion.instancia = instancia;
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
