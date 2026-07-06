package logica;

import dominio.*;
import java.util.*;
import java.io.*;

/**
 * @author Martin Alvarado
 */
public class Escritor {

	/**
	 * Guarda la lista de cartas entregada en el archivo sobres.txt, escribiendo una línea por cada carta
	 * 
	 * @param cartas lista de cartas a guardar
	 */
	public void guardarCartas(ArrayList<Carta> cartas) {
		try (FileWriter fw = new FileWriter("sobres.txt")) {

			for (Carta carta : cartas) {
				fw.write(carta.toLinea() + "\n");
			}
		} catch (IOException e) {
			System.out.println("ERROR");
		}
	}
}