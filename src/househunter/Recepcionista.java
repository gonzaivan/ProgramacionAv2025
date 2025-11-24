package househunter;

import javax.swing.JOptionPane;

public class Recepcionista implements IMenu {
    private String nombre;

    public Recepcionista(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String obtenerMenu() {
        return "--- MENÚ RECEPCIÓN (" + nombre + ") ---\n" +
               "1. Asignar Habitación a Delegación\n" +
               "2. ver habitaciones (Ocupación)\n" +    
               "3. ver delegaciones (Estado)\n" +       
               "4. Registrar Nueva Delegación\n" +
               "5. Crear Nueva Habitación\n" +
               "6. Salir\n\n" +
               "Escriba una opción:";
    }

    @Override
    public void realizarTarea() {
        asignarHabitacion();
    }

    public void asignarHabitacion() {
        
        java.util.List<String> habitacionesLibres = Habitacion.obtenerDisponibles();
        if (habitacionesLibres.isEmpty()) {
            JOptionPane.showMessageDialog(null, "¡No hay habitaciones libres!");
            return;
        }
        StringBuilder msgHab = new StringBuilder("--- HABITACIONES DISPONIBLES ---\n");
        for (String h : habitacionesLibres) msgHab.append(h).append("\n");
        msgHab.append("\nN° Habitación:");
        
        try {
            String habStr = JOptionPane.showInputDialog(msgHab.toString());
            if (habStr == null) return;
            int numHab = Integer.parseInt(habStr);

            java.util.List<Delegacion> delegacionesLibres = Delegacion.obtenerSinHabitacion();
            if (delegacionesLibres.isEmpty()) {
                JOptionPane.showMessageDialog(null, "¡No hay delegaciones pendientes!");
                return;
            }
            StringBuilder msgDel = new StringBuilder("--- DELEGACIONES PENDIENTES ---\n");
            for (Delegacion d : delegacionesLibres) msgDel.append(d.toString()).append("\n");
            msgDel.append("\nID Delegación:");
            
            String delStr = JOptionPane.showInputDialog(msgDel.toString());
            if (delStr == null) return;
            int idDel = Integer.parseInt(delStr);

            Habitacion.asignarDelegacionBD(numHab, idDel);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error de formato.");
        }
    }

    public void verHabitaciones() {
        java.util.List<String> lista = Habitacion.obtenerReporteOcupacion();
        ReporteGenerico<String> reporte = new ReporteGenerico<>();
        for (String s : lista) reporte.agregarElemento(s);
        reporte.mostrarReporte("ESTADO DE HABITACIONES");
    }

    public void verDelegaciones() {
        java.util.List<String> lista = Delegacion.obtenerReporteEstado();
        ReporteGenerico<String> reporte = new ReporteGenerico<>();
        for (String s : lista) reporte.agregarElemento(s);
        reporte.mostrarReporte("ESTADO DE DELEGACIONES");
    }

    public void registrarDelegacion() {
        String pais = JOptionPane.showInputDialog("País:");
        if(pais==null) return;
        String deporte = JOptionPane.showInputDialog("Deporte:");
        if(deporte==null) return;
        String cant = JOptionPane.showInputDialog("Cantidad:");
        if(cant==null) return;
        try {
            new Delegacion(pais, deporte, Integer.parseInt(cant)).registrarEnBD();
        } catch(Exception e) { JOptionPane.showMessageDialog(null, "Error en cantidad"); }
    }

    public void crearHabitacion() {
        String num = JOptionPane.showInputDialog("Número de Habitación:");
        if(num!=null) {
            try { Habitacion.crearHabitacionBD(Integer.parseInt(num)); }
            catch(Exception e) { JOptionPane.showMessageDialog(null, "Error en número"); }
        }
    }
}