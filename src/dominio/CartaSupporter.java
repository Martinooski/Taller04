package dominio;

import visitor.Visitor;

/**
 * @author Martin Alvarado
 */
public class CartaSupporter extends Carta {

	/**
	 * Cantidad de efectos que puede ejecutar la carta por turno
	 */
	private int efectosPorTurno;

	/**
	 * Inicializa la CartaSupporter con su respectiva cantidad de efectos por turno
	 * 
	 * @param nombreCarta nombre de la carta
	 * @param rareza rareza de la carta
	 * @param tipo tipo de la carta
	 * @param efectosPorTurno cantidad de efectos por turno que puede ejecutar la carta
	 */
	public CartaSupporter(String nombreCarta, int rareza, String tipo, int efectosPorTurno) {
		super(nombreCarta, rareza, tipo);
		this.efectosPorTurno = efectosPorTurno;
	}

	/**
	 * Devuelve la cantidad de efectos que puede ejecutar la carta por turno.
	 * 
	 */
	public int getEfectosPorTurno() {
		return efectosPorTurno;
	}

	/**
	 * Modifica la cantidad de efectos por turno actual de la carta por una
	 * nueva cantidad.
	 * 
	 * @param efectosPorTurno nueva cantidad de efectos por turno de la carta.
	 */
	public void setEfectosPorTurno(int efectosPorTurno) {
		this.efectosPorTurno = efectosPorTurno;
	}

	/**
	 * Devuelve una representación en texto de los efectos por turno de la
	 * carta.
	 */
	@Override
	public String toString() {
		return "CartaSupporter [efectosPorTurno=" + efectosPorTurno + "]";
	}

	/**
	 * Método que pide a un Visitor el cálculo del poder de la carta.
	 * 
	 * @param visitor un visitor encargado de calcular el poder de la carta.
	 * @return un double que representa el poder de la carta.
	 */
	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}

	/**
	 * Devuelve la línea de texto de la carta lista para ser escrita en el
	 * archivo de persistencia.
	 * 
	 * @return la línea de texto que representa a la carta.
	 */
	@Override
	public String toLinea() {
		return getNombreCarta() + ";" + getRareza() + ";" + getTipo() + ";" + getEfectosPorTurno();
	}

}