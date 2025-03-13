package co.edu.uniquindio.poo;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    public static void agregarCita(Cita cita) {
        String sql = "INSERT INTO citas (paciente, doctor, fecha) VALUES (?, ?, ?)";
        try (Connection conn = Database.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cita.getPaciente());
            pstmt.setString(2, cita.getDoctor());
            pstmt.setString(3, cita.getFecha().toString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Cita> obtenerCitas() {
        List<Cita> lista = new ArrayList<>();
        String sql = "SELECT * FROM citas";
        try (Connection conn = Database.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Cita(rs.getString("paciente"), rs.getString("doctor"), LocalDate.parse(rs.getString("fecha"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static void cancelarCita(String paciente, String doctor, String fecha) {
        String sql = "DELETE FROM citas WHERE paciente = ? AND doctor = ? AND fecha = ?";
        try (Connection conn = Database.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, paciente);
            pstmt.setString(2, doctor);
            pstmt.setString(3, fecha);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<String> obtenerPacientesConNombresPalindromos() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT DISTINCT paciente FROM citas";
        try (Connection conn = Database.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String nombre = rs.getString("paciente");
                if (esPalindromo(nombre)) {
                    lista.add(nombre);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static List<String> obtenerPacientesConVocalesIguales() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT DISTINCT paciente FROM citas";
        try (Connection conn = Database.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String nombre = rs.getString("paciente");
                if (tieneVocalesIguales(nombre)) {
                    lista.add(nombre);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    private static boolean esPalindromo(String palabra) {
        palabra = palabra.replaceAll("\\s+", "").toLowerCase(); // Elimina espacios y pasa a minúscula
        return palabra.equals(new StringBuilder(palabra).reverse().toString());
    }

    private static boolean tieneVocalesIguales(String palabra) {
        palabra = palabra.toLowerCase();
        String vocales = palabra.replaceAll("[^aeiouáéíóú]", ""); // Extrae vocales
        return vocales.chars().distinct().count() == 1; // Verifica si hay solo un tipo de vocal
    }
}