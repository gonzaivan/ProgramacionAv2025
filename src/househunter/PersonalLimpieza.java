package srshotel;

import javax.swing.JOptionPane;

public class PersonalLimpieza implements IMenu {
    private String nombre;

    public PersonalLimpieza(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String obtenerMenu() {
        return "--- MENÚ LIMPIEZA (" + nombre + ") ---\n" +
               "1. Marcar Habitación Limpia/Libre (REAL)\n" +
               "2. Ver Tareas\n" +
               "3. Salir\n\n" +
               "Escriba una opción:";
    }

    @Override
    public void realizarTarea() {
        try {
            String habStr = JOptionPane.showInputDialog("Ingrese NÚMERO de habitación a limpiar (ej: 101):");
            if (habStr == null) return;
            int numHab = Integer.parseInt(habStr);

            Habitacion.limpiarHabitacionBD(numHab);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
        }
    }
}