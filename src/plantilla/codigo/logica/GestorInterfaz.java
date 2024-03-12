package plantilla.codigo.logica;

import java.util.List;

public interface GestorInterfaz <T>{

	public List<T> obtenerTodosLosAnimales();
	
	public List<T> obtenerAnimalPorId(int id);
	
	public List <T> anadirAnimal();
	
	public List <T> borrarAnimal(int id);
	
	public List <T> modificarAnimal(int id);
	
}
