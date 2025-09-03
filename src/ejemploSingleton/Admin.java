package ejemploSingleton;

import java.util.Iterator;

import javax.swing.JOptionPane;

public class Admin {

	private String nombre;

	public Admin(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void verEmpleados() {
		
		String[] empleados = new String[EmpleadosSingleton.getIntance().size()]; 
		String[] filtro = {
				"Desarrollo","Ciencia de datos","Otro"
		};
		
		String elegido = (String)JOptionPane.showInputDialog(null, "Elija rol a filtrar", nombre, 0, null, empleados, filtro[0]);
		
		for (int i = 0; i < empleados.length; i++) {
			if(EmpleadosSingleton.getIntance().get(i).getSector().equals(elegido)) {
				empleados[i] = EmpleadosSingleton.getIntance().get(i).toString();	
				}
			}
		
		String empleado = (String)JOptionPane.showInputDialog(null, "Elija empleado", nombre, 0, null, empleados, empleados[0]);
		JOptionPane.showMessageDialog(null, empleado);
	}
	
}
