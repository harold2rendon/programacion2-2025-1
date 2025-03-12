package co.edu.uniquindio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.poo.Database;
import co.edu.uniquindio.poo.Paciente;

public class PacienteDAO {
    public static void agregarPaciente(Paciente paciente) {
        String sql = "INSERT INTO pacientes (nombre) VALUES (?)";
        try (Connection conn = Database.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, paciente.getNombre());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Paciente> obtenerPacientes() {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";
        try (Connection conn = Database.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Paciente(rs.getString("nombre"), 0, sql, sql));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static void eliminarPaciente(String nombre) {
        String sql = "DELETE FROM pacientes WHERE nombre = ?";
        try (Connection conn = Database.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}