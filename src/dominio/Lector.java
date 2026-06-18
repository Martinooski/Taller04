package dominio;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Lector {
	
	public ArrayList<Carta> leerCartas() {
		
		ArrayList<Carta> listaCartas = new ArrayList<>();
		
		try {		
			Scanner lector = new Scanner(new File("sobres.txt"));
			
			while (lector.hasNextLine()) {
				
				String linea = lector.nextLine();
				String[] partes = linea.split(";");
			    Carta carta = Factory.crearCarta(partes);
			    if (carta != null) {
			    	
			    	listaCartas.add(carta);
			    }
			}			
			lector.close();		
		} catch (FileNotFoundException e) {
			System.out.println("ERROR");
		}

		return listaCartas;
	}

}