package def;

import javax.swing.JOptionPane;

public class Admin extends Usuario implements Menu{

	private String clave;

	public Admin(String mail, String contrasenia, String clave) {
		super(mail, contrasenia);
		this.clave = clave;
	}

	@Override
	public void MenuPrincipal() {
		String[] opciones = {"Ver estadisticas","Salir"};
		int elegido = JOptionPane.showOptionDialog(null,"Elija opcion", "Admin", 0, 0, null, opciones, opciones[0]);
		
	}
	
}
