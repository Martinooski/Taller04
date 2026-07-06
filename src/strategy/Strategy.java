package strategy;

import java.util.ArrayList;
import dominio.*;

/**
 * @author Martin Alvarado
 */
public interface Strategy {

	/**
	 * Ordena una lista de cartas según el criterio definido por la estrategia
	 * concreta
	 * 
	 * @param cartas lista de cartas a ordenar
	 * @return la lista de cartas ordenada
	 */
	ArrayList<Carta> ordenar(ArrayList<Carta> cartas);

}