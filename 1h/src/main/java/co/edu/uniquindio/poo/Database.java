package co.edu.uniquindio.poo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//conexion de la interfaz

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/tu_base_de_datos";
    private static final String USUARIO = "tu_usuario";
    private static final String CONTRASEÑA = "tu_contraseña";

    public static Connection conectar() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos.");
        }
        return conn;
    }
}

