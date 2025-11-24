package srshotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Delegacion {
    private int idDelegacion;
    private String pais;
    private String deporte;
    private int cantidadPersonas;

    public Delegacion(String pais, String deporte, int cantidad) {
        this.pais = pais;
        this.deporte = deporte;
        this.cantidadPersonas = cantidad;
    }
    

    public void registrarEnBD() {
        Connection con = ConexionDB.getInstancia();
        String sql = "INSERT INTO delegacion (pais, deporte, cantidad_personas) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, this.pais);
            stmt.setString(2, this.deporte);
            stmt.setInt(3, this.cantidadPersonas);
            
            int filas = stmt.executeUpdate();
            if(filas > 0) {
                JOptionPane.showMessageDialog(null, "¡Delegación de " + pais + " registrada con éxito!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar delegación.");
        }
    }
    
    public static java.util.List<Delegacion> obtenerSinHabitacion() {
        java.util.List<Delegacion> lista = new java.util.ArrayList<>();
        Connection con = ConexionDB.getInstancia();
        
        String sql = "SELECT * FROM delegacion WHERE cantidad_personas > 0";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Delegacion del = new Delegacion(
                    rs.getString("pais"), 
                    rs.getString("deporte"), 
                    rs.getInt("cantidad_personas")
                );
                del.setId(rs.getInt("id_delegacion")); 
                
                lista.add(del);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public void setId(int id) { this.idDelegacion = id; }
    
    public static java.util.List<String> obtenerReporteEstado() {
        java.util.List<String> lista = new java.util.ArrayList<>();
        Connection con = ConexionDB.getInstancia();
        
        String sql = "SELECT * FROM delegacion";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                String pais = rs.getString("pais");
                String deporte = rs.getString("deporte");
                int pendientes = rs.getInt("cantidad_personas");
                
                String estadoStr;
                
                if (pendientes > 0) {
                    estadoStr = "[PENDIENTE] Faltan ubicar: " + pendientes + " personas.";
                } else {
                    estadoStr = "[COMPLETA] Todos ubicados.";
                }
                
                lista.add(pais + " (" + deporte + ") -> " + estadoStr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public static java.util.List<Delegacion> obtenerTodasBD() {
        java.util.List<Delegacion> lista = new java.util.ArrayList<>();
        Connection con = ConexionDB.getInstancia();
        String sql = "SELECT * FROM delegacion";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id_delegacion");
                String p = rs.getString("pais");
                String d = rs.getString("deporte");
                int c = rs.getInt("cantidad_personas");
                
                Delegacion del = new Delegacion(p, d, c);
                del.idDelegacion = id; 
                lista.add(del); 

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public String getPais() { return pais; }
    
    @Override
    public String toString() {
        return "ID: " + idDelegacion + " | País: " + pais + " | Deporte: " + deporte + " | Cant: " + cantidadPersonas;
    }
}