package ejemploGenerico;

import javax.swing.JOptionPane;

public class Persona implements Menu{
	protected String nombre;

	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void MenuPrincipal() {
		String[] opciones = {
				"ver perfil", "salir"
		};
		int opcion = JOptionPane.showOptionDialog(null, "Bienvenido " + this.nombre,"",
				0, 0, null, opciones, opciones[0]);
		
	}
	
	
}
