package def;

import javax.swing.JOptionPane;

public class Cliente  extends Usuario implements Validacion,Menu{
	
	private String matricula;
	private int saldo;
	
	
	public Cliente(String mail, String contrasenia, String matricula, int saldo) {
		super(mail, contrasenia);
		this.matricula = matricula;
		this.saldo = saldo;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public int getSaldo() {
		return saldo;
	}


	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}


	@Override
	public void MenuPrincipal() {
		String[] opciones = {"Ver perfil","Salir"};
		int elegido = JOptionPane.showOptionDialog(null,"Elija opcion", "Cliente", 0, 0, null, opciones, opciones[0]);
		
	}
	
	
	
}
