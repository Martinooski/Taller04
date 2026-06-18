package dominio;

import visitor.Visitor;

public class CartaItem extends Carta{
	
	private int bonificacion;

	public CartaItem(String nombreCarta, int rareza, String tipo, int bonificacion) {
		super(nombreCarta, rareza, tipo);
		this.bonificacion = bonificacion;
	}

	public int getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}

	@Override
	public double accept(Visitor visitor) {
	    return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "CartaItem [bonificacion=" + bonificacion + "]";
	}
	
	
}
