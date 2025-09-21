package srshotel;

public class Delegacion {

	public int id_delegacion;
	public int cant_pers;
	public Pais id_pais;
	public Deporte id_deporte;
	
	public Delegacion(int id_delegacion, int cant_pers, Pais id_pais, Deporte id_deporte) {
		super();
		this.id_delegacion = id_delegacion;
		this.cant_pers = cant_pers;
		this.id_pais = id_pais;
		this.id_deporte = id_deporte;
	}

	public int getId_delegacion() {
		return id_delegacion;
	}

	public void setId_delegacion(int id_delegacion) {
		this.id_delegacion = id_delegacion;
	}

	public int getCant_pers() {
		return cant_pers;
	}

	public void setCant_pers(int cant_pers) {
		this.cant_pers = cant_pers;
	}

	public Pais getId_pais() {
		return id_pais;
	}

	public void setId_pais(Pais id_pais) {
		this.id_pais = id_pais;
	}

	public Deporte getId_deporte() {
		return id_deporte;
	}

	public void setId_deporte(Deporte id_deporte) {
		this.id_deporte = id_deporte;
	}

	@Override
	public String toString() {
		return "Delegacion [id_delegacion=" + id_delegacion + ", cant_pers=" + cant_pers + ", id_pais=" + id_pais
				+ ", id_deporte=" + id_deporte + "]";
	}
	
	
	
}
