package dominio;

import visitor.Visitor;

public class CartaEnergy extends Carta {
	
	private String Elemento;

	

	public CartaEnergy(String nombreCarta, int rareza, String tipo, String elemento) {
		super(nombreCarta, rareza, tipo);
		Elemento = elemento;
	}

	public String getElemento() {
		return Elemento;
	}

	public void setElemento(String elemento) {
		Elemento = elemento;
	}

	@Override
	public String toString() {
		return "CartaEnergy [Elemento=" + Elemento + "]";
	}

	@Override
	public double accept(Visitor visitor) {
	    return visitor.visit(this);
	}
	
}
