package ejemploGenerico;

import java.util.Iterator;
import java.util.LinkedList;

public class Personal<T extends Persona>{

	private LinkedList<T> 
	personal = new LinkedList<T>();

	public Personal() {
		
	}

	public LinkedList<T> getPersonal() {
		return personal;
	}

	public void setPersonal(LinkedList<T> personal) {
		this.personal = personal;
	}
	
	public <T> T Login(String nombre){
		 
		T encontrada = null;
		for (Persona t:personal){
			 if (t.getNombre().equals(nombre)) {
				encontrada = (T) t;
			}
		 }
		 return encontrada;
	}
	
	
}
