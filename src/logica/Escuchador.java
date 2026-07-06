package logica;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import dominio.Carta;
import dominio.CartaEnergy;
import dominio.CartaItem;
import dominio.CartaPokemon;
import dominio.CartaSupporter;
import visitor.CalcularPoder;

/**
 * @author Martin Alvarado
 */
public class Escuchador extends MouseAdapter {

	/**
	 * Tabla que se escucha
	 */
	private JTable tabla;

	/**
	 * Lista de cartas asociada a la tabla
	 */
	private ArrayList<Carta> cartas;

	/**
	 * Ventana principal, utilizada como padre del diálogo de detalle
	 */
	private JFrame ventana;

	/**
	 * Inicializa el Escuchador con sus atributos respectivos
	 *
	 * @param tabla tabla donde se escucha el mouse
	 * @param cartas lista de cartas relacionada a la tabla
	 * @param ventana ventana principal que se ocupa como padre del diálogo
	 */
	public Escuchador(JTable tabla, ArrayList<Carta> cartas, JFrame ventana) {
		this.tabla = tabla;
		this.cartas = cartas;
		this.ventana = ventana;
	}

	/**
	 * Muestra un diálogo con la imagen y los datos de la carta clickeada en la
	 * fila seleccionada de la tabla
	 * 
	 * @param e evento de mouse sobre la tabla
	 */
	public void mouseClicked(MouseEvent e) {
		JDialog dialog = new JDialog(ventana, "Carta", true);
		dialog.setLayout(new BorderLayout());
		JPanel panelImagen = new JPanel();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		int fila = tabla.getSelectedRow();
		JLabel marco = new JLabel();

		if (fila >= 0) {
			File arch = new File("imagenes/" + cartas.get(fila).getNombreCarta() + ".jpg");
			if (arch.exists()) {
				ImageIcon imagen = new ImageIcon("imagenes/" + cartas.get(fila).getNombreCarta() + ".jpg");
				marco.setIcon(imagen);

			} else {
				ImageIcon predeterminado = new ImageIcon("imagenes/Default.jpg");
				marco.setIcon(predeterminado);
			}

			panelImagen.add(marco);
		} else {
			return;
		}

		Carta carta = cartas.get(fila);

		panel.add(new JLabel("Nombre"));
		panel.add(new JLabel(carta.getNombreCarta()));
		panel.add(new JLabel("Rareza"));
		panel.add(new JLabel(String.valueOf(carta.getRareza())));
		panel.add(new JLabel("Tipo"));
		panel.add(new JLabel(carta.getTipo()));

		if (carta instanceof CartaPokemon) {
			CartaPokemon p = (CartaPokemon) carta;
			panel.add(new JLabel("Daño"));
			panel.add(new JLabel(String.valueOf(p.getDaño())));
			panel.add(new JLabel("Cantidad Energías"));
			panel.add(new JLabel(String.valueOf(p.getCantEnergias())));
		} else if (carta instanceof CartaItem) {
			CartaItem i = (CartaItem) carta;
			panel.add(new JLabel("Bonificación"));
			panel.add(new JLabel(String.valueOf(i.getBonificacion())));
		} else if (carta instanceof CartaSupporter) {
			CartaSupporter s = (CartaSupporter) carta;
			panel.add(new JLabel("Efectos por turno"));
			panel.add(new JLabel(String.valueOf(s.getEfectosPorTurno())));
		} else if (carta instanceof CartaEnergy) {
			CartaEnergy en = (CartaEnergy) carta;
			panel.add(new JLabel("Elemento"));
			panel.add(new JLabel(en.getElemento()));
		}

		double poder = carta.accept(new CalcularPoder());
		panel.add(new JLabel("Poder"));
		panel.add(new JLabel(String.valueOf(poder)));

		dialog.add(panelImagen, BorderLayout.WEST);
		dialog.add(panel, BorderLayout.CENTER);
		dialog.setSize(900, 1000);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setLocationRelativeTo(ventana);
		dialog.setVisible(true);
	}

	/**
	 * Modifica la lista de cartas asociada a la tabla
	 * @param cartas nueva lista de cartas
	 */
	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

}