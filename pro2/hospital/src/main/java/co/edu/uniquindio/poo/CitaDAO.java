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
            pstmt.setString(1, cita.getPaciente().getNombre());
            pstmt.setString(2, cita.getDoctor().getNombre());
            pstmt.setDate(3, Date.valueOf(cita.getFecha())); // 🔹 Convertimos LocalDate a SQL Date
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
                String paciente = rs.getString("paciente");
                String doctor = rs.getString("doctor");
                LocalDate fecha = rs.getDate("fecha").toLocalDate(); // 🔹 Convertimos SQL Date a LocalDate
                lista.add(new Cita(null, null, fecha));
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
            pstmt.setDate(3, Date.valueOf(LocalDate.parse(fecha))); // 🔹 Convertimos String a LocalDate
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}