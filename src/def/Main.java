package def;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Cliente yo = new Cliente("","","",1);
		Admin gonza = new Admin("","","");
		
		yo.ValidarNum(JOptionPane.showInputDialog("Ingrese num"));
		yo.MenuPrincipal();
		gonza.MenuPrincipal();

	}

}
