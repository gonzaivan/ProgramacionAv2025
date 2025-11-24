package househunter;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ReporteGenerico<T> {
    private List<T> elementos = new ArrayList<>();

    public void agregarElemento(T elemento) {
        elementos.add(elemento);
    }

    public void mostrarReporte(String titulo) {
        StringBuilder sb = new StringBuilder();
        sb.append("==== REPORTE DE ").append(titulo.toUpperCase()).append(" ====\n");
        
        if (elementos.isEmpty()) {
            sb.append("(Vacío)");
        } else {
            for (T item : elementos) {
                sb.append("- ").append(item.toString()).append("\n");
            }
        }
        
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}