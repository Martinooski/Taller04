package visitor;

import dominio.CartaEnergy;
import dominio.CartaItem;
import dominio.CartaPokemon;
import dominio.CartaSupporter;

/**
 * @author Martin Alvarado
 */
public class CalcularPoder implements Visitor {

	/**
	 * Calcula el poder de una CartaPokemon como el cociente entre el daño y la
	 * cantidad de energías, multiplicado por 100
	 * 
	 * @param pokemon una CartaPokemon cualquiera
	 * @return el poder calculado, o 0 si la cantidad de energías es 0
	 */
	@Override
	public double visit(CartaPokemon pokemon) {

		if (pokemon.getCantEnergias() == 0) {
			return 0;
		}
		// (daño / cantEnergias) * 100

		return ((double) pokemon.getDaño() / pokemon.getCantEnergias()) * 100;
	}

	/**
	 * Calcula el poder de una CartaItem como su bonificación multiplicada por
	 * 20
	 * 
	 * @param item una CartaItem cualquiera
	 * @return el poder calculado
	 */
	@Override
	public double visit(CartaItem item) {
		// bonificacion * 20
		return item.getBonificacion() * 20;
	}

	/**
	 * Calcula el poder de una CartaSupporter como sus efectos por turno
	 * multiplicados por 50
	 * 
	 * @param supporter una CartaSupporter cualquiera.
	 * @return el poder calculado
	 */
	@Override
	public double visit(CartaSupporter supporter) {
		// efectosPorTurno * 50
		return supporter.getEfectosPorTurno() * 50;
	}

	/**
	 * Calcula el poder de una CartaEnergy, el cual es siempre 1
	 * 
	 * @param energy una CartaEnergy cualquiera.
	 * @return el poder calculado, siempre 1
	 */
	@Override
	public double visit(CartaEnergy energy) {
		// 1
		return 1;
	}
}