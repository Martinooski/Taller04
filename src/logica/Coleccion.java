package logica;

import java.util.ArrayList;

import dominio.Carta;

/**
 * @author Martin Alvarado
 */
public class Coleccion {

	/**
	 * Única instancia de Coleccion
	 */
	private static Coleccion instancia;

	/**
	 * Lista de cartas de la colección
	 */
	private ArrayList<Carta> listaCartas;

	/**
	 * Inicializa la Coleccion cargando las cartas existentes en el archivo mediante un Lector
	 */
	private Coleccion() {
		listaCartas = new ArrayList<>();

		Lector lector = new Lector();
		listaCartas = lector.leerCartas();
	}

	/**
	 * Devuelve la única instancia de Coleccion, creándola si aún no existe
	 * 
	 * @return la instancia de Coleccion
	 */
	public static Coleccion getInstance() {
		if (instancia == null) {
			instancia = new Coleccion();
		}

		return instancia;
	}

	/**
	 * Devuelve la lista de cartas de la colección
	 *
	 * @return la lista de cartas
	 */
	public ArrayList<Carta> getListaCartas() {
		return listaCartas;
	}

	/**
	 * Agrega una carta a la colección
	 * 
	 * @param carta la carta a agregar
	 */
	public void agregarCarta(Carta carta) {
		listaCartas.add(carta);
	}

	/**
	 * Elimina una carta de la colección
	 * 
	 * @param carta la carta a eliminar
	 */
	public void eliminarCarta(Carta carta) {
		listaCartas.remove(carta);
	}

}