package srshotel;

public class Deporte {

	public int id_deporte;
	public String nombre;
	
	public Deporte(int id_deporte, String nombre) {
		super();
		this.id_deporte = id_deporte;
		this.nombre = nombre;
	}

	public int getId_deporte() {
		return id_deporte;
	}

	public void setId_deporte(int id_deporte) {
		this.id_deporte = id_deporte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Deporte [id_deporte=" + id_deporte + ", nombre=" + nombre + "]";
	}
	
	
	
}
