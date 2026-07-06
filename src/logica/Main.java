package logica;

/**
 * @author Martin Alvarado
 */
public class Main {

	// Martin Alvarado Lafferte 22.330.833-3 ICCI

	/**
	 * Sistema utilizado por el programa
	 */
	private static Sistema sistema = SistemaImp.getInstance();

	/**
	 * Ventana principal de la aplicación
	 */
	private static Ventana ventana = new Ventana();

	/**
	 * Método principal donde se inicializa el sistema y se muestra la GUI
	 * 
	 */
	public static void main(String[] args) {

		// Martin Alvarado Lafferte 22.330.833-3 ICCI


		
		
		sistema.leerArchivo();
		ventana.crearVentana();
		
	}

}
