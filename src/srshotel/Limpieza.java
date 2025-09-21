package srshotel;

import javax.swing.JOptionPane;

public class Limpieza extends Usuario implements Menu {
	
	protected int id_limpieza;
	protected String nombre;
	protected String apellido;
	protected int edad;
	
	public Limpieza(int id_usuario, String rol, String email, String password, int id_limpieza, String nombre,
			String apellido, int edad) {
		super(id_usuario, rol, email, password);
		this.id_limpieza = id_limpieza;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public int getId_limpieza() {
		return id_limpieza;
	}

	public void setId_limpieza(int id_limpieza) {
		this.id_limpieza = id_limpieza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Limpieza [id_limpieza=" + id_limpieza + ", nombre=" + nombre + ", apellido=" + apellido + ", edad="
				+ edad + "]";
	}

	@Override
	public void MenuPrincipal() {
		
			String[] opciones = {"ver Habitaciones a Limpiar","Salir"};
			int elegido = JOptionPane.showOptionDialog(null,"Elija opcion", "Limpieza", 0, 0, null, opciones, opciones[0]);
		
	
		
	}
	
	
	

}
