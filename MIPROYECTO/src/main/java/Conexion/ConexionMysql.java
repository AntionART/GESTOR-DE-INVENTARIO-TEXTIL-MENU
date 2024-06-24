package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMysql {
    // Datos de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/miproyecto";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    // Variable para mantener la conexión
    private static Connection cn;

    /**
     * Método para establecer la conexión a la base de datos.
     * @return La conexión establecida.
     */
    public static Connection conectar() {
        try {
            if (cn == null || cn.isClosed()) {
                cn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión Exitosa");
            }
        } catch (SQLException e) {
            System.out.println("Error de conexión a la base de datos: " + e);
        }
        return cn;
    }

    /**
     * Método para obtener la conexión a la base de datos.
     * @return La conexión actual o una nueva conexión si no está establecida.
     */
    public static Connection getConexion() {
        if (cn == null) {
            cn = conectar(); // Establece la conexión si no está inicializada
        } else {
            try {
                if (cn.isClosed()) {
                    cn = conectar(); // Reestablece la conexión si está cerrada
                }
            } catch (SQLException e) {
                System.out.println("Error al verificar estado de conexión: " + e);
            }
        }
        return cn;
    }

    /**
     * Método para cerrar la conexión a la base de datos.
     */
    public static void cerrarConexion() {
        if (cn != null) {
            try {
                cn.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e);
            }
        }
    }
}