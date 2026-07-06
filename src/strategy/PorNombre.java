package strategy;

import java.util.ArrayList;

import dominio.Carta;

/**
 * @author Martin Alvarado
 */
public class PorNombre implements Strategy {

	/**
	 * Ordena la lista de cartas alfabéticamente por nombre mediante el
	 * algoritmo de burbuja
	 * 
	 * @param cartas lista de cartas a ordenar
	 * @return la lista de cartas ordenada alfabéticamente
	 */
	@Override
	public ArrayList<Carta> ordenar(ArrayList<Carta> cartas) {

		for (int i = 0; i < cartas.size() - 1; i++) {
			for (int j = i + 1; j < cartas.size(); j++) {
				if (cartas.get(i).getNombreCarta().compareTo(cartas.get(j).getNombreCarta()) > 0) {
					Carta aux = cartas.get(i);
					cartas.set(i, cartas.get(j));
					cartas.set(j, aux);
				}
			}
		}
		return cartas;
	}

}