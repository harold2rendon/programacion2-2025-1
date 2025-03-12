package co.edu.uniquindio.poo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    public static void agregarDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctores (nombre, especialidad) VALUES (?, ?)";
        try (Connection conn = Database.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, doctor.getNombre());
            pstmt.setString(2, doctor.getEspecialidad());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Doctor> obtenerDoctores() {
        List<Doctor> lista = new ArrayList<>();
        String sql = "SELECT * FROM doctores";
        try (Connection conn = Database.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Doctor(rs.getString("nombre"), rs.getString("especialidad")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static void eliminarDoctor(String nombre) {
        String sql = "DELETE FROM doctores WHERE nombre = ?";
        try (Connection conn = Database.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
