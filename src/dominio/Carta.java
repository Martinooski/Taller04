package dominio;
 
import visitor.Visitor;
 
/**
 * @author Martin Alvarado
 */
public abstract class Carta {
 
	/**
	 * Nombre de la carta.
	 */
	private String nombreCarta;
 
	/**
	 * Rareza de la carta.
	 */
	private int rareza;
 
	/**
	 * Tipo de la carta.
	 */
	private String tipo;
 
	/**
	 * Inicializa la Carta con los atributos respectivos.
	 * 
	 * @param nombreCarta nombre de la carta.
	 * @param rareza rareza de la carta.
	 * @param tipo tipo de la carta.
	 */
	public Carta(String nombreCarta, int rareza, String tipo) {
		super();
		this.nombreCarta = nombreCarta;
		this.rareza = rareza;
		this.tipo = tipo;
	}
 
	/**
	 * Devuelve el nombre de la carta
	 */
	public String getNombreCarta() {
		return nombreCarta;
	}
 
	/**
	 * Modifica el nombre actual de la carta por un nuevo nombre
	 * 
	 * @param nombreCarta nuevo nombre de la carta
	 */
	public void setNombreCarta(String nombreCarta) {
		this.nombreCarta = nombreCarta;
	}
 
	/**
	 * Devuelve la rareza de la carta
	 */
	public int getRareza() {
		return rareza;
	}
 
	/**
	 * Modifica la rareza actual de la carta por una nueva rareza
	 * 
	 * @param rareza nueva rareza de la carta
	 */
	public void setRareza(int rareza) {
		this.rareza = rareza;
	}
 
	/**
	 * Devuelve el tipo de la carta
	 */
	public String getTipo() {
		return tipo;
	}
 
	/**
	 * Modifica el tipo actual de la carta por un nuevo tipo
	 * 
	 * @param tipo nuevo tipo de la carta
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
 
	/**
	 * Método que recibe un Visitor encargado de calcular el poder numérico de la
	 * carta
	 * 
	 * @param visitor un visitor encargado de calcular el poder de la carta.
	 * @return un double que representa el poder de la carta
	 */
	public abstract double accept(Visitor visitor);
 
	/**
	 * Devuelve una línea de texto con los atributos de la carta separados por
	 * ";", lista para ser escrita en el archivo de persistencia
	 */
	public abstract String toLinea();
 
	/**
	 * Devuelve una representación en texto de la carta con sus atributos
	 * principales
	 * 
	 */
	@Override
	public String toString() {
		return "Carta [nombreCarta=" + nombreCarta + ", rareza=" + rareza + ", tipo=" + tipo + "]";
	}
 
}