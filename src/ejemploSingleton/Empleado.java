package ejemploSingleton;

public class Empleado {
	
	
	private String nombre;
	private String sector;
	private double sueldo;
	public Empleado(String nombre, String sector, double sueldo) {
		super();
		this.nombre = nombre;
		this.sector = sector;
		this.sueldo = sueldo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", sector=" + sector + ", sueldo=" + sueldo + "]";
	}
	
	
	
	
	
}
