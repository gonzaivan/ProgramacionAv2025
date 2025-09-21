package srshotel;

public class Usuario {

	protected int id_usuario;
	protected String rol;
	protected String email;
	protected String password;
	
	
	public Usuario(int id_usuario, String rol, String email, String password) {
		super();
		this.id_usuario = id_usuario;
		this.rol = rol;
		this.email = email;
		this.password = password;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", rol=" + rol + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	
	
	
	

}
