package strategy;

import java.util.ArrayList;

import dominio.Carta;

/**
 * @author Martin Alvarado
 */
public class PorRareza implements Strategy {

	/**
	 * Ordena la lista de cartas por rareza, de mayor a menor, mediante el
	 * algoritmo de burbuja
	 * 
	 * @param cartas lista de cartas a ordenar
	 * @return la lista de cartas ordenada por rareza
	 */
	@Override
	public ArrayList<Carta> ordenar(ArrayList<Carta> cartas) {

		for (int i = 0; i < cartas.size() - 1; i++) {
			for (int j = i + 1; j < cartas.size(); j++) {
				if (cartas.get(i).getRareza() > cartas.get(j).getRareza()) {
					Carta aux = cartas.get(i);
					cartas.set(i, cartas.get(j));
					cartas.set(j, aux);
				}
			}
		}
		return cartas;
	}

}