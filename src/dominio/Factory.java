package dominio;

/**
 * @author Martin Alvarado
 */
public class Factory {

	/**
	 * Método encargado de la creación de una carta a partir de un arreglo con
	 * sus atributos en texto.
	 * 
	 * @param partes arreglo de cadenas de texto que contiene los atributos de la carta.
	 * @return una carta inicializada con los atributos del arreglo, o null si el tipo no corresponde a ninguno conocido.
	 */
	public static Carta crearCarta(String[] partes) {
		String nombreCarta = partes[0].trim();
		int rareza = Integer.parseInt(partes[1].trim());
		String tipo = partes[2].trim();

		if (tipo.equals("Pokemon")) {

			int daño = Integer.parseInt(partes[3].trim());
			int cantEnergias = Integer.parseInt(partes[4].trim());
			return new CartaPokemon(nombreCarta, rareza, tipo, daño, cantEnergias);

		}

		else if (tipo.equals("Item")) {

			int bonificacion = Integer.parseInt(partes[3].trim());
			return new CartaItem(nombreCarta, rareza, tipo, bonificacion);

		}

		else if (tipo.equals("Supporter")) {

			int efectosPorTurno = Integer.parseInt(partes[3].trim());
			return new CartaSupporter(nombreCarta, rareza, tipo, efectosPorTurno);

		}

		else if (tipo.equals("Energy")) {

			String elemento = partes[3].trim();
			return new CartaEnergy(nombreCarta, rareza, tipo, elemento);

		}

		return null;
	}
}