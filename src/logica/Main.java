package logica;

/**
 * @author Martin Alvarado
 */
public class Main {

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
		
		sistema.leerArchivo();
		ventana.crearVentana();
		
	}

}