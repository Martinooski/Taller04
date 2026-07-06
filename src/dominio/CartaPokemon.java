package dominio;

import visitor.Visitor;

/**
 * @author Martin Alvarado
 */
public class CartaPokemon extends Carta {

	/**
	 * Daño que inflige el pokemon
	 */
	private int daño;

	/**
	 * Cantidad de energías que requiere el pokemon para infligir daño
	 */
	private int cantEnergias;

	/**
	 * Inicializa la CartaPokemon con su respectivo daño y cantidad de energías
	 * que necesita
	 * 
	 * @param nombreCarta nombre de la carta
	 * @param rareza rareza de la carta
	 * @param tipo tipo de la carta
	 * @param daño daño que inflige el pokemon
	 * @param cantEnergias cantidad de energías que necesita para infligir daño
	 */
	public CartaPokemon(String nombreCarta, int rareza, String tipo, int daño, int cantEnergias) {
		super(nombreCarta, rareza, tipo);
		this.daño = daño;
		this.cantEnergias = cantEnergias;
	}

	/**
	 * Devuelve el daño que inflige la carta
	 * 
	 * @return entero del daño que inflige la carta
	 */
	public int getDaño() {
		return daño;
	}

	/**
	 * Modifica el daño actual de la carta por un nuevo daño
	 * 
	 * @param daño nuevo daño de la carta
	 */
	public void setDaño(int daño) {
		this.daño = daño;
	}

	/**
	 * Devuelve la cantidad de energías que necesita la carta
	 * 
	 * @return entero de la cantidad de energías
	 */
	public int getCantEnergias() {
		return cantEnergias;
	}

	/**
	 * Modifica la cantidad de energías actual de la carta por una nueva
	 * cantidad
	 * 
	 * @param cantEnergias nueva cantidad de energías
	 */
	public void setCantEnergias(int cantEnergias) {
		this.cantEnergias = cantEnergias;
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
		return getNombreCarta() + ";" + getRareza() + ";" + getTipo() + ";" + getDaño() + ";" + getCantEnergias();
	}

}