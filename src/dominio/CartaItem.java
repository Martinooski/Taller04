package dominio;

import visitor.Visitor;

/**
 * @author Martin Alvarado
 */
public class CartaItem extends Carta {

	/**
	 * Bonificación que otorga la carta
	 */
	private int bonificacion;

	/**
	 * Inicializa la CartaItem con su respectiva bonificación
	 * 
	 * @param nombreCarta nombre de la carta
	 * @param rareza rareza de la carta
	 * @param tipo tipo de la carta
	 * @param bonificacion bonificación asociada a la carta
	 */
	public CartaItem(String nombreCarta, int rareza, String tipo, int bonificacion) {
		super(nombreCarta, rareza, tipo);
		this.bonificacion = bonificacion;
	}

	/**
	 * Devuelve la bonificación que otorga la carta
	 *
	 * @return entero de la bonificación de la carta
	 */
	public int getBonificacion() {
		return bonificacion;
	}

	/**
	 * Modifica la bonificación actual de la carta por una nueva bonificación.
	 * 
	 * @param bonificacion nueva bonificación de la carta
	 */
	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}

	/**
	 * Método que pide a un Visitor el cálculo del poder de la carta
	 * 
	 * @param visitor un visitor encargado de calcular el poder de la carta.
	 * @return un double que representa el poder de la carta
	 */
	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}

	/**
	 * Devuelve una representación en texto de la bonificación de la carta.
	 * 
	 * @return cadena de texto con la bonificación de la carta
	 */
	@Override
	public String toString() {
		return "CartaItem [bonificacion=" + bonificacion + "]";
	}

	/**
	 * Devuelve la línea de texto de la carta lista para ser escrita en el
	 * archivo de persistencia
	 * 
	 * @return la línea de texto que representa a la carta
	 */
	@Override
	public String toLinea() {
		return getNombreCarta() + ";" + getRareza() + ";" + getTipo() + ";" + getBonificacion();
	}

}