package dominio;

import visitor.Visitor;

/**
 * @author Martin Alvarado
 */
public class CartaEnergy extends Carta {

	/**
	 * Elemento de la energía
	 */
	private String Elemento;

	/**
	 * Inicializa la CartaEnergy con su elemento respectivo
	 * 
	 * @param nombreCarta nombre de la carta
	 * @param rareza rareza de la carta
	 * @param tipo tipo de la carta
	 * @param elemento elemento de la carta
	 */
	public CartaEnergy(String nombreCarta, int rareza, String tipo, String elemento) {
		super(nombreCarta, rareza, tipo);
		Elemento = elemento;
	}

	/**
	 * Devuelve el elemento de la carta
	 * 
	 * @return el nombre del elemento de la carta
	 */
	public String getElemento() {
		return Elemento;
	}

	/**
	 * Modifica el elemento actual de la carta por un nuevo elemento
	 * 
	 * @param elemento nuevo elemento de la carta
	 */
	public void setElemento(String elemento) {
		Elemento = elemento;
	}

	/**
	 * Devuelve una representación en texto del elemento de la carta
	 * 
	 * @return cadena de texto con el elemento de la carta
	 */
	@Override
	public String toString() {
		return "CartaEnergy [Elemento=" + Elemento + "]";
	}

	/**
	 * Método que pide a un Visitor el cálculo del poder de la carta
	 * 
	 * @param visitor un visitor encargado de calcular el poder de la carta
	 * @return un double que representa el poder de la carta
	 */
	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}

	/**
	 * Devuelve la línea de texto de la carta lista para ser escrita en el
	 * archivo de persistencia
	 * 
	 * @return la línea de texto que representa a la carta
	 */
	@Override
	public String toLinea() {
		return getNombreCarta() + ";" + getRareza() + ";" + getTipo() + ";" + getElemento();
	}

}