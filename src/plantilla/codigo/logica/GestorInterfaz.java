package plantilla.codigo.logica;

import java.util.List;

public interface GestorInterfaz <T>{

	public List<T> obtenerTodosLosAnimales();
	
	public List<T> obtenerAnimalPorId(int id);
	
	public boolean anadirAnimal();
	
	public void borrarAnimal(int id);
	
	public boolean modificarAnimal(int id);
	
}
