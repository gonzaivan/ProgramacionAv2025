package househunter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Main programa = new Main();

        String email = JOptionPane.showInputDialog(null, "Bienvenido a House Hunter\nIngrese Email:", "Login", JOptionPane.QUESTION_MESSAGE);
        
        if (email == null || email.isEmpty()) return;

        String pass = JOptionPane.showInputDialog(null, "Ingrese Contraseña:", "Login", JOptionPane.QUESTION_MESSAGE);

        if (programa.login(email, pass)) {
            
            IMenu usuarioLogueado;
            if (email.contains("recepcion")) {
                usuarioLogueado = new Recepcionista("Usuario Recepción");
            } else {
                usuarioLogueado = new PersonalLimpieza("Usuario Limpieza");
            }

            boolean continuar = true;
            while (continuar) {
                try {
                    String menuTexto = usuarioLogueado.obtenerMenu();
                    String inputOpcion = JOptionPane.showInputDialog(menuTexto);

                    if (inputOpcion == null) {
                        continuar = false;
                        break;
                    }

                    int opcion = Integer.parseInt(inputOpcion);

                    if (usuarioLogueado instanceof Recepcionista) {
                        Recepcionista recep = (Recepcionista) usuarioLogueado;

                        if (opcion == 1) {
                            recep.asignarHabitacion();
                        } else if (opcion == 2) {
                            recep.verHabitaciones();
                        } else if (opcion == 3) {
                            recep.verDelegaciones();
                        } else if (opcion == 4) {
                            recep.registrarDelegacion();
                        } else if (opcion == 5) {
                            recep.crearHabitacion();
                        } else if (opcion == 6) {
                            JOptionPane.showMessageDialog(null, "Cerrando sesión...");
                            continuar = false;
                        } else {
                            JOptionPane.showMessageDialog(null, "Opción incorrecta.");
                        }

                    } 
                    else if (usuarioLogueado instanceof PersonalLimpieza) {
                        PersonalLimpieza limpieza = (PersonalLimpieza) usuarioLogueado;

                        if (opcion == 1) {
                            limpieza.realizarTarea();
                        } else if (opcion == 2) {
                            JOptionPane.showMessageDialog(null, "No hay tareas pendientes.");
                        } else if (opcion == 3) {
                            JOptionPane.showMessageDialog(null, "Cerrando sesión...");
                            continuar = false;
                        } else {
                            JOptionPane.showMessageDialog(null, "Opción incorrecta.");
                        }
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
            
        } else { 
            JOptionPane.showMessageDialog(null, "Acceso denegado.\nUsuario o clave incorrectos.", "Error de Login", JOptionPane.ERROR_MESSAGE);
        }
    } 
    public boolean login(String email, String passwordPlana) {
        String passCifrada = Seguridad.cifrarCesar(passwordPlana);
        Connection con = ConexionDB.getInstancia(); 
        String sql = "SELECT rol FROM usuario WHERE email = ? AND contrasena = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, passCifrada); 
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace(); 
            return false;
        }
    }
}