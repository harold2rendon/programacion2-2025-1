package co.edu.uniquindio.poo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String URL = "jdbc:sqlite:hospital.db";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void crearTablaPacientes() {
        String sql = "CREATE TABLE IF NOT EXISTS pacientes (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "nombre TEXT NOT NULL)";
        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void crearTablaDoctores() {
        String sql = "CREATE TABLE IF NOT EXISTS doctores (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "nombre TEXT NOT NULL, " +
                     "especialidad TEXT NOT NULL)";
        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void crearTablaCitas() {
        String sql = "CREATE TABLE IF NOT EXISTS citas (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "paciente TEXT NOT NULL, " +
                     "doctor TEXT NOT NULL, " +
                     "fecha TEXT NOT NULL)";
        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
