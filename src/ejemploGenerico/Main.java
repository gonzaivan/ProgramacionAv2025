package ejemploGenerico;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		Personal personal = new Personal();
		Persona yo = new Persona ("gonza");
		Profesor profe = new Profesor("Gonzalo","analista");
		
		Alumno alumno = new Alumno("Ivan", "aprobada");
		
		
		personal.getPersonal().add(yo);
		personal.getPersonal().add(profe);
		personal.getPersonal().add(alumno);
		
		String ingreso = JOptionPane.showInputDialog("ingrese nombre");
		
		Persona encontrado = (Persona) personal.Login(ingreso);
		if (encontrado instanceof Alumno) {
			
			Alumno student = (Alumno)encontrado;
			
			student.MenuPrincipal();
		}else if(encontrado instanceof Profesor) {
			
			Profesor profesor = (Profesor)encontrado;
			
			profesor.MenuPrincipal();
			
			profesor.Calificar();
			
			
		}else if(encontrado instanceof Persona) {
			
			encontrado.MenuPrincipal();
		}
		
		

	}

}
