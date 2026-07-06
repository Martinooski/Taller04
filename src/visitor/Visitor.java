package visitor;

import dominio.CartaEnergy;
import dominio.CartaItem;
import dominio.CartaPokemon;
import dominio.CartaSupporter;

/**
 * @author Martin Alvarado
 */
public interface Visitor {

	/**
	 * Calcula el poder de una CartaPokemon
	 * 
	 * @param pokemon una CartaPokemon cualquiera
	 * @return el poder calculado
	 */
	double visit(CartaPokemon pokemon);

	/**
	 * Calcula el poder de una CartaItem
	 * 
	 * @param item una CartaItem cualquiera
	 * @return el poder calculado
	 */
	double visit(CartaItem item);

	/**
	 * Calcula el poder de una CartaSupporter
	 * 
	 * @param supporter una CartaSupporter cualquiera
	 * @return el poder calculado
	 */
	double visit(CartaSupporter supporter);

	/**
	 * Calcula el poder de una CartaEnergy
	 * 
	 * @param energy una CartaEnergy cualquiera
	 * @return el poder calculado
	 */
	double visit(CartaEnergy energy);

}