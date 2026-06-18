package dominio;

import visitor.Visitor;

public class CartaPokemon extends Carta {
	
	private int daño;
	private int cantEnergias;
	
	
	public CartaPokemon(String nombreCarta, int rareza, String tipo, int daño, int cantEnergias) {
		super(nombreCarta, rareza, tipo);
		this.daño = daño;
		this.cantEnergias = cantEnergias;
	}


	public int getDaño() {
		return daño;
	}


	public void setDaño(int daño) {
		this.daño = daño;
	}


	public int getCantEnergias() {
		return cantEnergias;
	}


	public void setCantEnergias(int cantEnergias) {
		this.cantEnergias = cantEnergias;
	}

	@Override
	public double accept(Visitor visitor) {
	    return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "CartaPokemon [daño=" + daño + ", cantEnergias=" + cantEnergias + "]";
	}
	
	

}
