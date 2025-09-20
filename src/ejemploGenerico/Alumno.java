package ejemploGenerico;

import javax.swing.JOptionPane;

public class Alumno extends Persona {
	private String matricula;

	public Alumno(String nombre, String matricula) {
		super(nombre);
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Alumno [matricula=" + matricula + "]";
	}
	
	@Override
	public void MenuPrincipal() {
		String[] opciones = {
				"ver perfil","ver clases","Inscribirse a materias", "salir"
		};
		int opcion = JOptionPane.showOptionDialog(null, "Bienvenido " + this.nombre,"",
				0, 0, null, opciones, opciones[0]);
		
	}
	
	
}
