package ejemploSingleton;

import java.util.LinkedList;

public class EmpleadosSingleton {
	//atributos
	private static LinkedList<Empleado> empleados;
	//constructor
	private EmpleadosSingleton() {
		empleados = new LinkedList<Empleado>();
	}
	//metodo
	public static LinkedList<Empleado>
	getIntance(){
		if (empleados==null) {
			System.out.println("se crea");
			new EmpleadosSingleton();
		}else {
			System.out.println("no se crea");
		}
		return empleados;
	}
	
	public static void agregarEmpleados(Empleado nuevo) {
		empleados.add(nuevo);
	}
	
	
	
	
	
}
