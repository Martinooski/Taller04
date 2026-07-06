package logica;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dominio.*;
/**
 * @author Martin Alvarado
 */
public class Ventana {

	/**
	 * Sistema utilizado para administrar las cartas
	 */
	private Sistema sistema = SistemaImp.getInstance();

	/**
	 * Ventana principal de la aplicación
	 */
	private JFrame frame;

	/**
	 * Tabla de la pestaña Administración
	 */
	private JTable tablaAdmin;

	/**
	 * Modelo de la tabla de Administración
	 */
	private DefaultTableModel modeloAdmin;

	/**
	 * Lista de cartas mostrada en la pestaña Administración
	 */
	private ArrayList<Carta> cartasAdmin;

	/**
	 * Tabla de la pestaña Ver Colección
	 */
	private JTable tablaColeccion;

	/**
	 * Modelo de la tabla de Ver Colección
	 */
	private DefaultTableModel modeloColeccion;

	/**
	 * Lista de cartas mostrada en la pestaña Ver Colección
	 */
	private ArrayList<Carta> cartasColeccion;

	/**
	 * Escuchador de mouse de la tabla de Ver Colección
	 */
	private Escuchador escuchador;

	/**
	 * Construye y muestra la ventana principal con sus dos pestañas:
	 * Administración y Ver Colección
	 */
	public void crearVentana() {
		frame = new JFrame("Pokemon TCG");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 650);

		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab("Administración", crearPanelAdministracion());
		tabs.addTab("Ver Colección", crearPanelColeccion());

		frame.add(tabs);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * Crea el panel de la pestaña Administración, con la tabla de cartas y
	 * los botones para agregar, eliminar y modificar
	 * 
	 * @return el panel de Administración.
	 */
	private JPanel crearPanelAdministracion() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		String[] columnas = { "Nombre", "Rareza", "Tipo" };
		modeloAdmin = new DefaultTableModel(columnas, 0);
		tablaAdmin = new JTable(modeloAdmin);
		panel.add(new JScrollPane(tablaAdmin), BorderLayout.CENTER);

		JPanel panelBotones = new JPanel();

		JButton btnAgregar = new JButton("Agregar Carta");
		btnAgregar.addActionListener(e -> mostrarDialogoAgregar());

		JButton btnModificar = new JButton("Modificar Carta");
		btnModificar.addActionListener(e -> mostrarDialogoModificar());

		JButton btnEliminar = new JButton("Eliminar Carta");
		btnEliminar.addActionListener(e -> eliminarCarta());

		panelBotones.add(btnAgregar);
		panelBotones.add(btnModificar);
		panelBotones.add(btnEliminar);

		panel.add(panelBotones, BorderLayout.SOUTH);

		refrescarAdmin();

		return panel;
	}

	/**
	 * Crea el panel de la pestaña Ver Colección, con la tabla de cartas, los
	 * botones de ordenamiento y el listener de clic para ver el detalle de
	 * cada carta
	 * 
	 * @return el panel de Ver Colección
	 */
	private JPanel crearPanelColeccion() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		cartasColeccion = sistema.getCartas();

		String[] columnas = { "Nombre", "Rareza", "Tipo" };
		modeloColeccion = new DefaultTableModel(columnas, 0);
		tablaColeccion = new JTable(modeloColeccion);
		cargarFilas(modeloColeccion, cartasColeccion);

		escuchador = new Escuchador(tablaColeccion, cartasColeccion, frame);
		tablaColeccion.addMouseListener(escuchador);

		panel.add(new JScrollPane(tablaColeccion), BorderLayout.CENTER);

		JPanel panelBotones = new JPanel();

		JButton btnRareza = new JButton("Ordenar por Rareza");
		btnRareza.addActionListener(e -> {
			cartasColeccion = sistema.ordenarPorRareza(cartasColeccion);
			escuchador.setCartas(cartasColeccion);
			cargarFilas(modeloColeccion, cartasColeccion);
		});

		JButton btnNombre = new JButton("Ordenar por Nombre");
		btnNombre.addActionListener(e -> {
			cartasColeccion = sistema.ordenarPorNombre(cartasColeccion);
			escuchador.setCartas(cartasColeccion);
			cargarFilas(modeloColeccion, cartasColeccion);
		});

		JButton btnPoder = new JButton("Ordenar por Poder");
		btnPoder.addActionListener(e -> {
			cartasColeccion = sistema.ordenarPorPoder(cartasColeccion);
			escuchador.setCartas(cartasColeccion);
			cargarFilas(modeloColeccion, cartasColeccion);
		});

		panelBotones.add(btnRareza);
		panelBotones.add(btnNombre);
		panelBotones.add(btnPoder);

		panel.add(panelBotones, BorderLayout.SOUTH);

		return panel;
	}

	/**
	 * Muestra u oculta las etiquetas y campos extra del formulario de agregar
	 * carta según el tipo seleccionado en el combo
	 * 
	 * @param comboTipo combo con el tipo de carta seleccionado
	 * @param lblDaño etiqueta del campo daño
	 * @param campoDaño campo de texto del daño
	 * @param lblCantEnergia etiqueta del campo cantidad de energías
	 * @param campoCantEnergia campo de texto de la cantidad de energías
	 * @param lblBonificacion etiqueta del campo bonificación
	 * @param campoBonificacion campo de texto de la bonificación
	 * @param lblEfectoTurno etiqueta del campo efectos por turno
	 * @param campoEfectoTurno campo de texto de los efectos por turno
	 * @param lblElemento etiqueta del campo elemento
	 * @param campoElemento campo de texto del elemento
	 */
	private void actualizarCamposAgregar(JComboBox<String> comboTipo, JLabel lblDaño, JTextField campoDaño,
			JLabel lblCantEnergia, JTextField campoCantEnergia, JLabel lblBonificacion, JTextField campoBonificacion,
			JLabel lblEfectoTurno, JTextField campoEfectoTurno, JLabel lblElemento, JTextField campoElemento) {

		String tipo = (String) comboTipo.getSelectedItem();
		boolean esPokemon = tipo.equals("Pokemon");
		boolean esItem = tipo.equals("Item");
		boolean esSupporter = tipo.equals("Supporter");
		boolean esEnergy = tipo.equals("Energy");

		lblDaño.setVisible(esPokemon);
		campoDaño.setVisible(esPokemon);
		lblCantEnergia.setVisible(esPokemon);
		campoCantEnergia.setVisible(esPokemon);

		lblBonificacion.setVisible(esItem);
		campoBonificacion.setVisible(esItem);

		lblEfectoTurno.setVisible(esSupporter);
		campoEfectoTurno.setVisible(esSupporter);

		lblElemento.setVisible(esEnergy);
		campoElemento.setVisible(esEnergy);
	}

	/**
	 * Muestra un diálogo con un formulario para agregar una nueva carta
	 * incluyendo todos los campos posibles según el tipo seleccionado
	 */
	private void mostrarDialogoAgregar() {
		JDialog dialog = new JDialog(frame, "Agregar Carta", true);
		dialog.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JTextField campoNombre = new JTextField();
		JTextField campoRareza = new JTextField();
		JComboBox<String> comboTipo = new JComboBox<>(new String[] { "Pokemon", "Item", "Supporter", "Energy" });

		JLabel lblDaño = new JLabel("Daño");
		JTextField campoDaño = new JTextField();
		JLabel lblCantEnergia = new JLabel("Cantidad Energías");
		JTextField campoCantEnergia = new JTextField();

		JLabel lblBonificacion = new JLabel("Bonificación");
		JTextField campoBonificacion = new JTextField();

		JLabel lblEfectoTurno = new JLabel("Efectos por turno");
		JTextField campoEfectoTurno = new JTextField();

		JLabel lblElemento = new JLabel("Elemento");
		JTextField campoElemento = new JTextField();

		panel.add(new JLabel("Nombre"));
		panel.add(campoNombre);
		panel.add(new JLabel("Rareza"));
		panel.add(campoRareza);
		panel.add(new JLabel("Tipo"));
		panel.add(comboTipo);
		panel.add(lblDaño);
		panel.add(campoDaño);
		panel.add(lblCantEnergia);
		panel.add(campoCantEnergia);
		panel.add(lblBonificacion);
		panel.add(campoBonificacion);
		panel.add(lblEfectoTurno);
		panel.add(campoEfectoTurno);
		panel.add(lblElemento);
		panel.add(campoElemento);

		comboTipo.addActionListener(e -> actualizarCamposAgregar(comboTipo, lblDaño, campoDaño, lblCantEnergia,
				campoCantEnergia, lblBonificacion, campoBonificacion, lblEfectoTurno, campoEfectoTurno, lblElemento,
				campoElemento));
		actualizarCamposAgregar(comboTipo, lblDaño, campoDaño, lblCantEnergia, campoCantEnergia, lblBonificacion,
				campoBonificacion, lblEfectoTurno, campoEfectoTurno, lblElemento, campoElemento);

		JButton btnConfirmar = new JButton("Agregar");
		btnConfirmar.addActionListener(e -> {
			String tipo = (String) comboTipo.getSelectedItem();
			try {
				String[] partes;
				switch (tipo) {
				case "Pokemon":
					partes = new String[] { campoNombre.getText().trim(), campoRareza.getText().trim(), tipo,
							campoDaño.getText().trim(), campoCantEnergia.getText().trim() };
					break;
				case "Item":
					partes = new String[] { campoNombre.getText().trim(), campoRareza.getText().trim(), tipo,
							campoBonificacion.getText().trim() };
					break;
				case "Supporter":
					partes = new String[] { campoNombre.getText().trim(), campoRareza.getText().trim(), tipo,
							campoEfectoTurno.getText().trim() };
					break;
				default:
					partes = new String[] { campoNombre.getText().trim(), campoRareza.getText().trim(), tipo,
							campoElemento.getText().trim() };
					break;
				}

				sistema.crearCarta(partes);
				sistema.guardarArchivo();
				refrescarAdmin();
				refrescarColeccion();
				dialog.dispose();

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(dialog, "Los campos numéricos deben contener números válidos.");
			}
		});

		panel.add(btnConfirmar);

		dialog.add(panel, BorderLayout.CENTER);
		dialog.setSize(350, 350);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setLocationRelativeTo(frame);
		dialog.setVisible(true);
	}

	/**
	 * Muestra un diálogo con los atributos adicionales de la carta
	 * seleccionada en la tabla de Administración, permitiendo modificar
	 * solamente esos atributos según su tipo
	 */
	private void mostrarDialogoModificar() {
		int fila = tablaAdmin.getSelectedRow();
		if (fila < 0 || fila >= cartasAdmin.size()) {
			JOptionPane.showMessageDialog(frame, "Selecciona una carta de la tabla.");
			return;
		}

		Carta carta = cartasAdmin.get(fila);

		JDialog dialog = new JDialog(frame, "Modificar Carta", true);
		dialog.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder(carta.getNombreCarta() + " (" + carta.getTipo() + ")"));

		panel.add(new JLabel("Nombre: " + carta.getNombreCarta()));
		panel.add(new JLabel("Rareza: " + carta.getRareza()));
		panel.add(new JLabel("Tipo: " + carta.getTipo()));

		JTextField campoExtra1 = new JTextField();
		JTextField campoExtra2 = new JTextField();

		if (carta instanceof CartaPokemon) {
			CartaPokemon p = (CartaPokemon) carta;
			panel.add(new JLabel("Daño"));
			campoExtra1.setText(String.valueOf(p.getDaño()));
			panel.add(campoExtra1);
			panel.add(new JLabel("Cantidad Energías"));
			campoExtra2.setText(String.valueOf(p.getCantEnergias()));
			panel.add(campoExtra2);
		} else if (carta instanceof CartaItem) {
			CartaItem i = (CartaItem) carta;
			panel.add(new JLabel("Bonificación"));
			campoExtra1.setText(String.valueOf(i.getBonificacion()));
			panel.add(campoExtra1);
		} else if (carta instanceof CartaSupporter) {
			CartaSupporter s = (CartaSupporter) carta;
			panel.add(new JLabel("Efectos por turno"));
			campoExtra1.setText(String.valueOf(s.getEfectosPorTurno()));
			panel.add(campoExtra1);
		} else if (carta instanceof CartaEnergy) {
			CartaEnergy en = (CartaEnergy) carta;
			panel.add(new JLabel("Elemento"));
			campoExtra1.setText(en.getElemento());
			panel.add(campoExtra1);
		}

		JButton btnConfirmar = new JButton("Modificar");
		btnConfirmar.addActionListener(e -> {
			try {
				if (carta instanceof CartaPokemon) {
					CartaPokemon p = (CartaPokemon) carta;
					p.setDaño(Integer.parseInt(campoExtra1.getText().trim()));
					p.setCantEnergias(Integer.parseInt(campoExtra2.getText().trim()));
				} else if (carta instanceof CartaItem) {
					CartaItem i = (CartaItem) carta;
					i.setBonificacion(Integer.parseInt(campoExtra1.getText().trim()));
				} else if (carta instanceof CartaSupporter) {
					CartaSupporter s = (CartaSupporter) carta;
					s.setEfectosPorTurno(Integer.parseInt(campoExtra1.getText().trim()));
				} else if (carta instanceof CartaEnergy) {
					CartaEnergy en = (CartaEnergy) carta;
					en.setElemento(campoExtra1.getText().trim());
				}

				sistema.guardarArchivo();
				refrescarAdmin();
				refrescarColeccion();
				dialog.dispose();

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(dialog, "Los campos numéricos deben contener números válidos.");
			}
		});

		panel.add(btnConfirmar);

		dialog.add(panel, BorderLayout.CENTER);
		dialog.setSize(350, 350);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setLocationRelativeTo(frame);
		dialog.setVisible(true);
	}

	/**
	 * Elimina la carta seleccionada en la tabla de Administración, previa
	 * confirmación del usuario
	 */
	private void eliminarCarta() {
		int fila = tablaAdmin.getSelectedRow();
		if (fila < 0 || fila >= cartasAdmin.size()) {
			JOptionPane.showMessageDialog(frame, "Selecciona una carta de la tabla.");
			return;
		}

		Carta carta = cartasAdmin.get(fila);
		int confirmacion = JOptionPane.showConfirmDialog(frame, "¿Eliminar la carta " + carta.getNombreCarta() + "?",
				"Eliminar Carta", JOptionPane.YES_NO_OPTION);

		if (confirmacion == JOptionPane.YES_OPTION) {
			sistema.eliminarCarta(carta);
			sistema.guardarArchivo();
			refrescarAdmin();
			refrescarColeccion();
		}
	}

	/**
	 * Recarga la tabla de la pestaña Administración con el estado actual de
	 * la colección.
	 */
	private void refrescarAdmin() {
		cartasAdmin = sistema.getCartas();
		cargarFilas(modeloAdmin, cartasAdmin);
	}

	/**
	 * Recarga la tabla de la pestaña Ver Colección con el estado actual de la
	 * colección
	 */
	private void refrescarColeccion() {
		cartasColeccion = sistema.getCartas();
		if (escuchador != null) {
			escuchador.setCartas(cartasColeccion);
		}
		cargarFilas(modeloColeccion, cartasColeccion);
	}

	/**
	 * Limpia un modelo de tabla y lo vuelve a llenar con los datos de la
	 * lista de cartas entregada
	 * 
	 * @param modelo modelo de la tabla a llenar
	 * @param cartas lista de cartas a mostrar en la tabla
	 */
	private void cargarFilas(DefaultTableModel modelo, ArrayList<Carta> cartas) {
		modelo.setRowCount(0);
		for (Carta c : cartas) {
			modelo.addRow(new Object[] { c.getNombreCarta(), c.getRareza(), c.getTipo() });
		}
	}

}