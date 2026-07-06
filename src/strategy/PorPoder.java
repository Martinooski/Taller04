package strategy;

import java.util.ArrayList;

import dominio.*;
import visitor.*;

/**
 * @author Martin Alvarado
 */
public class PorPoder implements Strategy {

	/**
	 * Ordena la lista de cartas por poder, de mayor a menor, calculando el
	 * poder de cada carta mediante CalcularPoder y aplicando el algoritmo de
	 * burbuja
	 * 
	 * @param cartas lista de cartas a ordenar
	 * @return la lista de cartas ordenada por poder
	 */
	@Override
	public ArrayList<Carta> ordenar(ArrayList<Carta> cartas) {

		CalcularPoder calculador = new CalcularPoder();

		for (int i = 0; i < cartas.size() - 1; i++) {
			for (int j = i + 1; j < cartas.size(); j++) {

				double poderI = cartas.get(i).accept(calculador);
				double poderJ = cartas.get(j).accept(calculador);

				if (poderI < poderJ) {
					Carta aux = cartas.get(i);
					cartas.set(i, cartas.get(j));
					cartas.set(j, aux);
				}
			}
		}
		return cartas;
	}

}