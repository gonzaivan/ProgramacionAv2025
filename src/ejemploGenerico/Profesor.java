package ejemploGenerico;

import javax.swing.JOptionPane;

public class Profesor extends Persona{
	
	private String titulo;

	public Profesor(String nombre, String titulo) {
		super(nombre);
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Profesor [titulo=" + titulo + "]";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Override
	public void MenuPrincipal() {
		String[] opciones = {
				"ver perfil","agregar clases","ver notas", "salir"
		};
		int opcion = JOptionPane.showOptionDialog(null, "Bienvenido " + this.nombre,"",
				0, 0, null, opciones, opciones[0]);	
	}
	
	public void Calificar() {
		
	}
	
	
	
}
