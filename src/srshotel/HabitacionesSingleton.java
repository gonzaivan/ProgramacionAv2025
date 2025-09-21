package srshotel;

import java.util.LinkedList;

public class HabitacionesSingleton {

		private static LinkedList<Habitacion> habitaciones;
		
		private HabitacionesSingleton() {
			habitaciones = new LinkedList<Habitacion>();
		}
		
		public static LinkedList<Habitacion>
		getIntance(){
			if (habitaciones==null) {
				System.out.println("se crea");
				new HabitacionesSingleton();
			}else {
				System.out.println("no se crea");
			}
			return habitaciones;
		}
		
		public static void agregarHabitaciones(Habitacion nuevo) {
			habitaciones.add(nuevo);
		}
	
	
}
