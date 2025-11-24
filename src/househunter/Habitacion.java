package househunter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Habitacion {

    private int idHabitacion;
    private int numero;
    private int capacidad;
    private boolean estado;
    private int idDelegacion;

    public Habitacion(int numero, int idDelegacion) {
        this.numero = numero;
        this.capacidad = 4;
        this.estado = false;
        this.idDelegacion = idDelegacion;
    }

    public static void asignarDelegacionBD(int numeroHabitacion, int idDelegacion) {
        Connection con = ConexionDB.getInstancia();
        
        try {
            String sqlCheck = "SELECT cantidad_personas FROM delegacion WHERE id_delegacion = ?";
            PreparedStatement stmtCheck = con.prepareStatement(sqlCheck);
            stmtCheck.setInt(1, idDelegacion);
            ResultSet rs = stmtCheck.executeQuery();

            if (rs.next()) {
                int personasPendientes = rs.getInt("cantidad_personas");

                if (personasPendientes <= 0) {
                    JOptionPane.showMessageDialog(null, "Error: ¡Esta delegación ya tiene a todos sus miembros ubicados!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int capacidadHab = 4;
                int personasQueEntran = Math.min(personasPendientes, capacidadHab);
                int nuevosPendientes = personasPendientes - personasQueEntran;

                String sqlUpdateHab = "UPDATE habitacion SET estado = 1, id_delegacion = ? WHERE numero = ?";
                PreparedStatement stmtHab = con.prepareStatement(sqlUpdateHab);
                stmtHab.setInt(1, idDelegacion);
                stmtHab.setInt(2, numeroHabitacion);
                int filasHab = stmtHab.executeUpdate();

                if (filasHab > 0) {
                    String sqlUpdateDel = "UPDATE delegacion SET cantidad_personas = ? WHERE id_delegacion = ?";
                    PreparedStatement stmtDel = con.prepareStatement(sqlUpdateDel);
                    stmtDel.setInt(1, nuevosPendientes);
                    stmtDel.setInt(2, idDelegacion);
                    stmtDel.executeUpdate();

                    JOptionPane.showMessageDialog(null, 
                        "¡Asignación Exitosa!\n" +
                        "-> Se ubicaron " + personasQueEntran + " personas en la Habitación " + numeroHabitacion + ".\n" +
                        "-> Restan ubicar: " + nuevosPendientes + " personas de esta delegación.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error: No se encontró la habitación " + numeroHabitacion, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error: No existe esa delegación.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error SQL: " + e.getMessage());
        }
    }


    public static void limpiarHabitacionBD(int numeroHabitacion) {
        Connection con = ConexionDB.getInstancia();
        String sql = "UPDATE habitacion SET estado = 0, id_delegacion = NULL WHERE numero = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, numeroHabitacion);
            
            int filas = stmt.executeUpdate();
            
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "¡Éxito! La habitación " + numeroHabitacion + " está limpia y libre.");
            } else {
                JOptionPane.showMessageDialog(null, "Error: No existe la habitación " + numeroHabitacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void crearHabitacionBD(int numero) {
        Connection con = ConexionDB.getInstancia();
        
        try {
            String sqlCheck = "SELECT COUNT(*) FROM habitacion WHERE numero = ?";
            PreparedStatement stmtCheck = con.prepareStatement(sqlCheck);
            stmtCheck.setInt(1, numero);
            ResultSet rs = stmtCheck.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "Error: La habitación " + numero + " ya existe.", "Duplicado", JOptionPane.ERROR_MESSAGE);
                return; 
            }

            String sqlInsert = "INSERT INTO habitacion (numero, capacidad, estado, id_delegacion) VALUES (?, 4, 0, NULL)";
            PreparedStatement stmtInsert = con.prepareStatement(sqlInsert);
            stmtInsert.setInt(1, numero);
            
            int filas = stmtInsert.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "¡Habitación " + numero + " creada correctamente!");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al crear: " + e.getMessage());
        }
    }

    public static List<String> obtenerDisponibles() {
        List<String> lista = new ArrayList<>();
        Connection con = ConexionDB.getInstancia();
        String sql = "SELECT numero, capacidad FROM habitacion WHERE estado = 0";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                lista.add("Habitación " + rs.getInt("numero") + " (Libre)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static List<String> obtenerReporteOcupacion() {
        List<String> lista = new ArrayList<>();
        Connection con = ConexionDB.getInstancia();
        
        String sql = "SELECT h.numero, h.estado, d.pais, d.deporte " +
                     "FROM habitacion h " +
                     "LEFT JOIN delegacion d ON h.id_delegacion = d.id_delegacion";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                int num = rs.getInt("numero");
                int estado = rs.getInt("estado");
                String pais = rs.getString("pais");
                String deporte = rs.getString("deporte");
                
                String detalle;
                if (estado == 0) {
                    detalle = "[LIBRE]";
                } else {
                    if (pais == null) pais = "Desconocido";
                    detalle = "[OCUPADA] -> " + pais + " (" + deporte + ")";
                }
                lista.add("Hab. " + num + " " + detalle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            lista.add("Error de conexión.");
        }
        return lista;
    }
}