package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// DAO de citas

public class CitaDAO {
    private static List<Cita> citas = new ArrayList<>();
    private static Map<String, List<String>> historialMedico = new HashMap<>();

    public static void agregarCita(Cita cita) {
        citas.add(cita);
    }

    public static List<Cita> obtenerCitas() {
        return new ArrayList<>(citas);
    }

    public static void cancelarCita(String paciente, String doctor, String fecha) {
        citas.removeIf(c -> c.getPaciente().equals(paciente) && c.getDoctor().equals(doctor) && c.getFecha().toString().equals(fecha));
    }

    public static List<String> obtenerPacientesConNombresPalindromos() {
        List<String> palindromos = new ArrayList<>();
        for (Cita c : citas) {
            if (esPalindromo(c.getPaciente())) {
                palindromos.add(c.getPaciente());
            }
        }
        return palindromos;
    }

    public static List<String> obtenerPacientesConVocalesIguales() {
        List<String> vocalesIguales = new ArrayList<>();
        for (Cita c : citas) {
            if (todasVocalesIguales(c.getPaciente())) {
                vocalesIguales.add(c.getPaciente());
            }
        }
        return vocalesIguales;
    }

    public static List<String> obtenerHistorialMedico(String paciente) {
        return historialMedico.getOrDefault(paciente, new ArrayList<>());
    }

    public static void agregarHistorialMedico(String paciente, String historial) {
        historialMedico.computeIfAbsent(paciente, k -> new ArrayList<>()).add(historial);
    }

    private static boolean esPalindromo(String str) {
        String limpio = str.replaceAll("\\s+", "").toLowerCase();
        String reverso = new StringBuilder(limpio).reverse().toString();
        return limpio.equals(reverso);
    }

    private static boolean todasVocalesIguales(String str) {
        str = str.toLowerCase();
        char vocal = 0;
        for (char c : str.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                if (vocal == 0) {
                    vocal = c;
                } else if (vocal != c) {
                    return false;
                }
            }
        }
        return vocal != 0;
    }
}