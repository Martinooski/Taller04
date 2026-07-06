package logica;

import java.util.ArrayList;
import dominio.Carta;

/**
 * @author Martin Alvarado
 */
public interface Sistema {

	/**
	 * Carga las cartas desde el archivo sobres.txt hacia la colección
	 */
	void leerArchivo();

	/**
	 * Crea una nueva carta a partir de un arreglo de datos y la agrega a la colección
	 * 
	 * @param partes arreglo con los atributos de la carta
	 */
	void crearCarta(String[] partes);

	/**
	 * Elimina una carta específica de la colección
	 * 
	 * @param carta la carta a eliminar
	 */
	void eliminarCarta(Carta carta);

	/**
	 * Reescribe el archivo sobres.txt con el estado actual de la colección
	 */
	void guardarArchivo();

	/**
	 * Devuelve la lista de cartas actual de la colección
	 * 
	 * @return lista de cartas
	 */
	ArrayList<Carta> getCartas();

	/**
	 * Ordena la lista de cartas por poder, de mayor a menor
	 * 
	 * @param cartas lista de cartas a ordenar
	 * @return lista ordenada
	 */
	ArrayList<Carta> ordenarPorPoder(ArrayList<Carta> cartas);

	/**
	 * Ordena la lista de cartas alfabéticamente por nombre
	 * 
	 * @param cartas lista de cartas a ordenar
	 * @return lista ordenada
	 */
	ArrayList<Carta> ordenarPorNombre(ArrayList<Carta> cartas);

	/**
	 * Ordena la lista de cartas por rareza, de mayor a menor
	 * 
	 * @param cartas lista de cartas a ordenar
	 * @return lista ordenada
	 */
	ArrayList<Carta> ordenarPorRareza(ArrayList<Carta> cartas);

}