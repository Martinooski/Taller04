package dominio;

import visitor.Visitor;

public abstract class Carta {
	
	private String nombreCarta;
	private int rareza;
	private String tipo;
	
	public Carta(String nombreCarta, int rareza, String tipo) {
		super();
		this.nombreCarta = nombreCarta;
		this.rareza = rareza;
		this.tipo = tipo;
	}

	public String getNombreCarta() {
		return nombreCarta;
	}

	public void setNombreCarta(String nombreCarta) {
		this.nombreCarta = nombreCarta;
	}

	public int getRareza() {
		return rareza;
	}

	public void setRareza(int rareza) {
		this.rareza = rareza;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public abstract double accept(Visitor visitor);
	
	@Override
	public String toString() {
		return "Carta [nombreCarta=" + nombreCarta + ", rareza=" + rareza + ", tipo=" + tipo + "]";
	}
	
	
	
	
}