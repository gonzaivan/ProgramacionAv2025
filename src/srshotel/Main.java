package srshotel;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		
		
		Recepcion r1 = new Recepcion(12,"Recepcion","gonzalo@gmail.com","1234",1,"Gonzalo","Fernandez",25);
		Limpieza l1 = new Limpieza(9, "limpieza", "jorge@gmail.com", "4321", 9, "jorge", "Lopez", 31);
		
		l1.MenuPrincipal();
		r1.MenuPrincipal();
		
		
		//JOptionPane.showMessageDialog(null, HabitacionesSingleton.getIntance());
		
		JOptionPane.showMessageDialog(null, HabitacionesSingleton.getIntance());
		Pais p1 = new Pais(12,"Argentina");
		Deporte d1 = new Deporte(23, "Natacion");
		Delegacion del1 = new Delegacion(21, 4, p1, d1);
		
		HabitacionesSingleton.agregarHabitaciones(new Habitacion(1, 101, 4, "libre", del1));
		
		
		
		JOptionPane.showMessageDialog(null, HabitacionesSingleton.getIntance());
		
		
		
	}

}
