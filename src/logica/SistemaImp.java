package logica;

import java.util.ArrayList;

import dominio.Carta;
import dominio.Factory;
import strategy.PorNombre;
import strategy.PorPoder;
import strategy.PorRareza;

/**
 * @author Martin Alvarado
 */
public class SistemaImp implements Sistema {

	/**
	 * Única instancia de SistemaImp
	 */
	private static SistemaImp instance;

	/**
	 * Colección de cartas administrada por el sistema
	 */
	private Coleccion coleccion;

	/**
	 * Escritor encargado de persistir las cartas en el archivo
	 */
	private Escritor escritor;

	/**
	 * Inicializa SistemaImp obteniendo la instancia de Coleccion y creando un
	 * nuevo Escritor
	 */
	private SistemaImp() {
		this.coleccion = Coleccion.getInstance();
		this.escritor = new Escritor();
	}

	/**
	 * Devuelve la única instancia de SistemaImp, creándola si aún no existe
	 * 
	 * @return la instancia de SistemaImp
	 */
	public static SistemaImp getInstance() {
		if (instance == null) {
			instance = new SistemaImp();
		}
		return instance;
	}

	/**
	 * Carga las cartas desde el archivo sobres.txt. La carga real ocurre al
	 * construirse la Coleccion, por lo que aquí no se realiza ninguna acción adicional
	 */
	public void leerArchivo() {
		// La colección ya se carga sola en su constructor mediante Lector
	}

	/**
	 * Crea una nueva carta a partir de un arreglo de datos y la agrega a la colección
	 * 
	 * @param partes arreglo con los atributos de la carta
	 */
	public void crearCarta(String[] partes) {
		Carta carta = Factory.crearCarta(partes);
		if (carta != null) {
			coleccion.agregarCarta(carta);
		}
	}

	/**
	 * Elimina una carta específica de la colección
	 * 
	 * @param carta la carta a eliminar
	 */
	public void eliminarCarta(Carta carta) {
		coleccion.eliminarCarta(carta);
	}

	/**
	 * Reescribe el archivo sobres.txt con el estado actual de la colección
	 */
	public void guardarArchivo() {
		escritor.guardarCartas(coleccion.getListaCartas());
	}

	/**
	 * Devuelve la lista de cartas actual de la colección
	 * 
	 * @return lista de cartas
	 */
	public ArrayList<Carta> getCartas() {
		return coleccion.getListaCartas();
	}

	/**
	 * Ordena la lista de cartas por poder, de mayor a menor, utilizando la
	 * estrategia PorPoder
	 * 
	 * @param cartas lista de cartas a ordenar
	 * @return lista ordenada
	 */
	public ArrayList<Carta> ordenarPorPoder(ArrayList<Carta> cartas) {
		return new PorPoder().ordenar(cartas);
	}

	/**
	 * Ordena la lista de cartas alfabéticamente por nombre, utilizando la
	 * estrategia PorNombre
	 * 
	 * @param cartas lista de cartas a ordenar
	 * @return lista ordenada
	 */
	public ArrayList<Carta> ordenarPorNombre(ArrayList<Carta> cartas) {
		return new PorNombre().ordenar(cartas);
	}

	/**
	 * Ordena la lista de cartas por rareza, de mayor a menor, utilizando la
	 * estrategia PorRareza
	 * 
	 * @param cartas lista de cartas a ordenar
	 * @return lista ordenada
	 */
	public ArrayList<Carta> ordenarPorRareza(ArrayList<Carta> cartas) {
		return new PorRareza().ordenar(cartas);
	}

}