package def;

public class Usuario {
	// atributos
	private String mail;
	private String contrasenia;
	//constructores
	
	public Usuario(String mail, String contrasenia) {
		super();
		this.mail = mail;
		this.contrasenia = contrasenia;
	}
	
	//metodos
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
	
}
