package plantilla.codigo;

import java.util.List;
import java.util.Scanner;

import plantilla.codigo.logica.GestorCocodrilos;
import plantilla.codigo.logica.GestorGatos;
import plantilla.codigo.logica.GestorPerros;
import plantilla.codigo.logica.GestorTortugas;
import plantilla.codigo.pojo.Gato;
import plantilla.codigo.pojo.Perro;
import plantilla.codigo.pojo.Tortuga;
import plantilla.codigo.pojo.Cocodrilo;

/**
 * Clase de menus.
 */
public class Menu {

	private GestorPerros gestorPerros = null;
	private GestorGatos gestorGatos = null;
	private GestorTortugas gestorTortugas = null;
	private GestorCocodrilos gestorCocodrilos = null;

	private Scanner teclado = null;

	public static final int NUMERO_OPCIONES_MENU = 2;

	public Menu() {
		gestorPerros = new GestorPerros();
		gestorGatos = new GestorGatos();
		gestorTortugas = new GestorTortugas();
		gestorCocodrilos = new GestorCocodrilos();

		teclado = new Scanner(System.in);
	}

	public void iniciar() {
		int opcion = 0;
		do {
			opcion = opcionMenuInicial();
			if (opcion != 0) {
				ejecutarOpcionMenuInicial(opcion);
			}
		} while (opcion != 0);
	}

	private int opcionMenuInicial() {
		int ret = 0;
		do {
			try {
				escribirMenuInicial();
				System.out.print("Elija una opcion: ");
				ret = teclado.nextInt();
				teclado.nextLine();
			} catch (Exception e) {
				teclado.nextLine();
				ret = -1;
			}
		} while ((ret < 0) && (ret > NUMERO_OPCIONES_MENU));
		return ret;
	}

	private void escribirMenuInicial() {
		System.out.println(" ");
		System.out.println("---- MENU ----");
		System.out.println("---- 0 - SALIR");
		System.out.println("---- 1 - Mostrar mascotas");
		System.out.println("---- 2 - Mostrar mascotas por tipo");
		System.out.println("---- 3 - Mostrar mascotas por id");
		System.out.println("---- 4 - Anadir, eliminar o modificar mascota");
		System.out.println("--------------");
	}

	private void ejecutarOpcionMenuInicial(int opcion) {
		System.out.println(" ");
		switch (opcion) {
		case 0:
			System.out.print("Adios!!!");
			break;
		case 1:
			mostrarMascotas();
			break;
		case 2:
			mostrarMascotasPorTipo();
			break;
		case 3:
			ejecutarOpcionMenuPorId();
			break;
		case 4:
			mostrarMascotasPorTipoParaAñadir();
			break;
		default:
			System.out.println("Esta opcion no deberia salir...");
		}
	}

	// --------- OPCION 1 - Mostrar todas las mascotas --//

	private void mostrarMascotas() {
		System.out.println("---------");
		List<Perro> perros = gestorPerros.obtenerTodosLosAnimales();
		mostrarPerros(perros);
		System.out.println("---------");
		List<Gato> gatos = gestorGatos.obtenerTodosLosAnimales();
		mostrarGatos(gatos);
		System.out.println("---------");
		List<Tortuga> tortugas = gestorTortugas.obtenerTodosLosAnimales();
		mostrarTortugas(tortugas);
	}

	private void mostrarPerros(List<Perro> perros) {
		for (Perro perro : perros) {
			mostrarPerro(perro);
		}
	}

	private void mostrarPerro(Perro perro) {
		System.out.println("Id: " + perro.getId());
		System.out.println("Nombre: " + perro.getNombre());
		System.out.println("Raza: " + perro.getRaza());
		System.out.println("Vacunado?: " + perro.isVacunado());
	}

	private void mostrarGatos(List<Gato> gatos) {
		for (Gato gato : gatos) {
			mostrarGato(gato);
		}
	}

	private void mostrarGato(Gato gato) {
		System.out.println("Id: " + gato.getId());
		System.out.println("Nombre: " + gato.getNombre());
		System.out.println("Raza: " + gato.getRaza());
		System.out.println("Color: " + gato.getColor());
	}

	private void mostrarTortugas(List<Tortuga> tortugas) {
		for (Tortuga tortuga : tortugas) {
			mostrarTortuga(tortuga);
		}
	}

	private void mostrarTortuga(Tortuga tortuga) {
		System.out.println("Id: " + tortuga.getId());
		System.out.println("Especie: " + tortuga.getEspecie());
		System.out.println("Agua Dulce?: " + tortuga.isAguaDulce());
	}

	private void mostrarCocodrilos(List<Cocodrilo> cocodrilos) {
		for (Cocodrilo cocodrilo : cocodrilos) {
			mostrarCocodrilo(cocodrilo);
		}
	}

	private void mostrarCocodrilo(Cocodrilo cocodrilo) {
		System.out.println("Id: " + cocodrilo.getId());
		System.out.println("Especie: " + cocodrilo.getEspecie());
		System.out.println("Agua Dulce?: " + cocodrilo.isAguaDulce());
		System.out.println("Numero de dientes: " + cocodrilo.getNumeroDientes());

	}

	// --------- OPCION 2 - Mostrar mascotas por tipo --//

	private void mostrarMascotasPorTipo() {
		int opcion = 0;
		do {
			opcion = opcionMenuPorTipo();
			if (opcion != 0) {
				ejecutarOpcionMenuPorTipo(opcion);
			}
		} while (opcion != 0);
	}

	private int opcionMenuPorTipo() {
		int ret = 0;
		do {
			try {
				escribirMenuPorTipo();
				System.out.print("Elija una opcion: ");
				ret = teclado.nextInt();
			} catch (Exception e) {
				teclado.nextLine();
				ret = -1;
			}
		} while ((ret < 0) && (ret > 3));
		return ret;
	}

	private void escribirMenuPorTipo() {
		System.out.println(" ");
		System.out.println("---- MENU ----");
		System.out.println("---- 0 - Volver ");
		System.out.println("---- 1 - Mostrar perros ");
		System.out.println("---- 2 - Mostrar gatos ");
		System.out.println("---- 3 - Mostrar tortugas ");
		System.out.println("--------------");
	}

	private void ejecutarOpcionMenuPorTipo(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("---------");
			List<Perro> perros = gestorPerros.obtenerTodosLosAnimales();
			mostrarPerros(perros);
			break;
		case 2:
			List<Gato> gatos = gestorGatos.obtenerTodosLosAnimales();
			mostrarGatos(gatos);
			break;
		case 3:
			System.out.println("---------");
			List<Tortuga> tortugas = gestorTortugas.obtenerTodosLosAnimales();
			mostrarTortugas(tortugas);
			break;
		}
	}

	// --------- OPCION 3 - Mostrar mascotas por id--//

	private void ejecutarOpcionMenuPorId() {
		System.out.println("Selecciona un id");
		int id = teclado.nextInt();

		System.out.println("---------");
		List<Perro> perros = gestorPerros.obtenerAnimalPorId(id);
		if (perros != null) {
			mostrarPerros(perros);
		} else
			System.out.println("No se han encontrado perros.");
		List<Gato> gatos = gestorGatos.obtenerAnimalPorId(id);
		if (gatos != null) {
			mostrarGatos(gatos);
		} else
			System.out.println("No se han encontrado gatos.");
		System.out.println("---------");
		List<Tortuga> tortugas = gestorTortugas.obtenerAnimalPorId(id);
		if (tortugas != null) {
			mostrarTortugas(tortugas);
		} else
			System.out.println("No se han encontrado tortugas.");
		System.out.println("---------");
		List<Cocodrilo> cocodrilos = gestorCocodrilos.obtenerAnimalPorId(id);
		if (cocodrilos != null) {
			mostrarCocodrilos(cocodrilos);
		} else
			System.out.println("No se han encontrado cocodrilos.");
	}

	// --------- OPCION 4,5 y 6 - Añadir, Borrar y modificar Animales --//

	private void mostrarMascotasPorTipoParaAñadir() {
		int opcion = 0;
		do {
			opcion = opcionMenuPorTipoParaAñadir();
			if (opcion != 0) {
				ejecutarOpcionMenuPorTipoParaAñadir(opcion);
			}
		} while (opcion != 0);
	}

	private int opcionMenuPorTipoParaAñadir() {
		int ret = 0;
		do {
			try {
				escribirMenuPorTipoParaAñadir();
				System.out.print("Elija una opcion: ");
				ret = teclado.nextInt();
			} catch (Exception e) {
				teclado.nextLine();
				ret = -1;
			}
		} while ((ret < 0) && (ret > 3));
		return ret;
	}

	private void escribirMenuPorTipoParaAñadir() {
		System.out.println(" ");
		System.out.println("---- MENU ----");
		System.out.println("---- 0 - Volver ");
		System.out.println("---- 1 - Añadir un perro ");
		System.out.println("---- 2 - Añadir un gato");
		System.out.println("---- 3 - Añadir una tortuga");
		System.out.println("---- 3 - Añadir un cocodrilo");
		System.out.println("--------------");
	}

	private void ejecutarOpcionMenuPorTipoParaAñadir(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("---------");
			List<Perro> perros = gestorPerros.anadirAnimal();
			System.out.println("Perro anadido!");
			break;
		case 2:
			System.out.println("---------");
			List<Gato> gatos = gestorGatos.anadirAnimal();
			System.out.println("Gato anadido!");
			break;
		case 3:
			System.out.println("---------");
			List<Tortuga> tortugas = gestorTortugas.anadirAnimal();
			System.out.println("Perro anadido!");
			break;
		case 4:
			System.out.println("---------");
			List<Cocodrilo> Cocodrilos = gestorCocodrilos.anadirAnimal();
			System.out.println("Cocodrilo anadido!");
			break;
		}
	}

}
