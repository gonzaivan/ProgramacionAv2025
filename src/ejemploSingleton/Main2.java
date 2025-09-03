package ejemploSingleton;

import javax.swing.JOptionPane;

public class Main2 {

	public static void main(String[] args) {
	
		JOptionPane.showMessageDialog(null, "Hola desde main2");
		
		JOptionPane.showMessageDialog(null, EmpleadosSingleton.getIntance());

	}

}
