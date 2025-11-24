package srshotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static Connection instancia = null;

    private static final String URL = "jdbc:mysql://localhost:3306/srshotel";
    private static final String USER = "root"; 
    private static final String PASS = "";

    private ConexionDB() { }

    public static Connection getInstancia() {
        if (instancia == null) {
            try {
                instancia = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Conexión Singleton exitosa a House Hunter.");
            } catch (SQLException e) {
                System.err.println("Error fatal conectando a la BD: " + e.getMessage());
            }
        }
        return instancia;
    }
}
