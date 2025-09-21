package srshotel;

public class Habitacion {
	
	public int id_habitacion;
	public int numero;
	public int capacidad;
	public String estado;
	public Delegacion id_delegacion;
	
	public Habitacion(int id_habitacion, int numero, int capacidad, String estado, Delegacion id_delegacion) {
		super();
		this.id_habitacion = id_habitacion;
		this.numero = numero;
		this.capacidad = capacidad;
		this.estado = estado;
		this.id_delegacion = id_delegacion;
	}

	public int getId_habitacion() {
		return id_habitacion;
	}

	public void setId_habitacion(int id_habitacion) {
		this.id_habitacion = id_habitacion;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Delegacion getId_delegacion() {
		return id_delegacion;
	}

	public void setId_delegacion(Delegacion id_delegacion) {
		this.id_delegacion = id_delegacion;
	}

	@Override
	public String toString() {
		return "Habitacion [id_habitacion=" + id_habitacion + ", numero=" + numero + ", capacidad=" + capacidad
				+ ", estado=" + estado + ", id_delegacion=" + id_delegacion + "]";
	}
	
	
	
	

}
