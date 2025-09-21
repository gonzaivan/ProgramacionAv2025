package srshotel;

public class Pais {

	public int id_pais;
	public String nombre;
	
	public Pais(int id_pais, String nombre) {
		super();
		this.id_pais = id_pais;
		this.nombre = nombre;
	}

	public int getId_pais() {
		return id_pais;
	}

	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Pais [id_pais=" + id_pais + ", nombre=" + nombre + "]";
	}
	
	
	
}
