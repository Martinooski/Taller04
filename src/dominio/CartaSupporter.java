package dominio;

import visitor.Visitor;

public class CartaSupporter extends Carta {
	
	private int efectosPorTurno;

	public CartaSupporter(String nombreCarta, int rareza, String tipo, int efectosPorTurno) {
		super(nombreCarta, rareza, tipo);
		this.efectosPorTurno = efectosPorTurno;
	}

	public int getEfectosPorTurno() {
		return efectosPorTurno;
	}

	public void setEfectosPorTurno(int efectosPorTurno) {
		this.efectosPorTurno = efectosPorTurno;
	}

	@Override
	public String toString() {
		return "CartaSupporter [efectosPorTurno=" + efectosPorTurno + "]";
	}
	
	@Override
	public double accept(Visitor visitor) {
	    return visitor.visit(this);
	}

}
