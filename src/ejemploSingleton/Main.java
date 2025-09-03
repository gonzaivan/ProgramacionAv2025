package ejemploSingleton;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		
		
		JOptionPane.showMessageDialog(null, EmpleadosSingleton.getIntance());
		
		EmpleadosSingleton.agregarEmpleados(new Empleado("gonza","Desarrollo",200));
		EmpleadosSingleton.agregarEmpleados(new Empleado("ivan","Ciencia de datos",200));
		
		JOptionPane.showMessageDialog(null, EmpleadosSingleton.getIntance());
		
		Main2.main(args);
		

	}

}
