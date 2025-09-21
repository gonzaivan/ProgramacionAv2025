package srshotel;

import javax.swing.JOptionPane;

public class Recepcion extends Usuario implements Menu{
	protected int id_rec;
	protected String nombre;
	protected String apellido;
	protected int edad;
	
	public Recepcion(int id_usuario, String rol, String email, String password, int id_rec, String nombre,
			String apellido, int edad) {
		super(id_usuario, rol, email, password);
		this.id_rec = id_rec;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public int getId_rec() {
		return id_rec;
	}

	public void setId_rec(int id_rec) {
		this.id_rec = id_rec;
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
		return "Recepcion [id_rec=" + id_rec + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + "]";
	}

	@Override
	public void MenuPrincipal() {
			String[] opciones = {"Agregar Huesped","Salir"};
			int elegido = JOptionPane.showOptionDialog(null,"Elija opcion", "Recepcionista", 0, 0, null, opciones, opciones[0]);
		
	}

	
	
	
	
}
