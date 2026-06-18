package logica;

import java.util.ArrayList;

import dominio.Carta;
import dominio.Lector;

public class Coleccion {

	private static Coleccion instancia;

	private ArrayList<Carta> listaCartas;

	private Coleccion() {
		listaCartas = new ArrayList<>();
		
		Lector lector = new Lector();
		listaCartas = lector.leerCartas();
	}

	public static Coleccion getInstance() {
		if (instancia == null) {
			instancia = new Coleccion();
		}
		
		return instancia;
	}

	public ArrayList<Carta> getListaCartas() {
		return listaCartas;
	}

	public void agregarCarta(Carta carta) {
		listaCartas.add(carta);
	}

	public void eliminarCarta(Carta carta) {
		listaCartas.remove(carta);
	}
	
}