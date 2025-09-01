package def;

import javax.swing.JOptionPane;

public interface Validacion {
	
	default int ValidarNum(String numero) {
		int num=0;
		boolean flag;
		do {
			flag = true;
			
			for (int i = 0; i < numero.length(); i++) {
				if (!Character.isDigit(numero.charAt(i))) {
					flag = false;
					JOptionPane.showMessageDialog(null, "error");
					break;
				}
			}
			
			if (!flag) {
				numero = JOptionPane.showInputDialog("ingrese num");
			}else {
				num = Integer.parseInt(numero);
			}
		} while (!flag);

		
		
		return num;
	}
	
}
