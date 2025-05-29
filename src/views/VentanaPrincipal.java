package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panelSuperior, panelCentral;
	private JButton boton1, boton2, boton3, boton4;
	private JLabel etiquetaNombreUniversidad;
	private JPanel panel;
	private boolean mostrarTitulo; // Nueva variable para controlar si mostrar el título

	public VentanaPrincipal(JPanel panel) {
		this.panel = panel;
		this.mostrarTitulo = false; // Por defecto no mostrar título
		init();
	}

	private void init() {
		setTitle("Menu De Opciones");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);

		panelSuperior();
		panelCentral();
	}

	private void panelSuperior() {
		panelSuperior = new JPanel();
		panelSuperior.setLayout(new FlowLayout());
		panelSuperior.setPreferredSize(new Dimension(getWidth(), 50));
		panelSuperior.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		boton1 = new JButton("Actualizar Datos");
		boton2 = new JButton("Agregar Escuela");
		boton3 = new JButton("Consultar Escuelas");
		boton4 = new JButton("Administrar Profesores");

		Dimension botonSize = new Dimension(180, 37);

		boton1.setPreferredSize(botonSize);
		boton2.setPreferredSize(botonSize);
		boton3.setPreferredSize(botonSize);
		boton4.setPreferredSize(botonSize);

		panelSuperior.add(boton1);
		panelSuperior.add(boton2);
		panelSuperior.add(boton3);
		panelSuperior.add(boton4);

		add(panelSuperior, BorderLayout.NORTH);
	}

	public void panelCentral() {
		panelCentral = new JPanel();
		panelCentral.setLayout(new BorderLayout());
		panelCentral.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panelCentral.setPreferredSize(new Dimension(700,450));

		// Solo crear y agregar la etiqueta si mostrarTitulo es true
		if (mostrarTitulo) {
			// Crear etiqueta para el nombre de la universidad
			etiquetaNombreUniversidad = new JLabel("Registrar Universidad", SwingConstants.CENTER);
			etiquetaNombreUniversidad.setFont(new Font("Arial", Font.BOLD, 24));
			etiquetaNombreUniversidad.setForeground(new Color(31, 52, 72));

			// Panel superior del centro para la etiqueta
			JPanel panelTitulo = new JPanel(new FlowLayout());
			panelTitulo.add(etiquetaNombreUniversidad);
			panelCentral.add(panelTitulo, BorderLayout.NORTH);
		}

		// Crear un panel contenedor que centre el contenido original
		JPanel contenedor = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		if (panel != null) {
			contenedor.add(panel, gbc);
		}

		panelCentral.add(contenedor, BorderLayout.CENTER);
		add(panelCentral, BorderLayout.CENTER);
	}

	public void cambiarPanelCentral(JPanel nuevoPanel) {
		if (panelCentral == null) {
			panelCentral = new JPanel();
			panelCentral.setLayout(new BorderLayout());
			panelCentral.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			add(panelCentral, BorderLayout.CENTER);
		}

		panelCentral.removeAll();

		// Solo mostrar la etiqueta si mostrarTitulo es true
		if (mostrarTitulo && etiquetaNombreUniversidad != null) {
			// Mantener la etiqueta del nombre de la universidad
			JPanel panelTitulo = new JPanel(new FlowLayout());
			panelTitulo.add(etiquetaNombreUniversidad);
			panelCentral.add(panelTitulo, BorderLayout.NORTH);
		}

		// Crear nuevo contenedor centrado
		JPanel contenedor = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		contenedor.add(nuevoPanel, gbc);

		if (mostrarTitulo && etiquetaNombreUniversidad != null) {
			panelCentral.add(contenedor, BorderLayout.CENTER);
		} else {
			// Si no hay título, agregar el contenedor directamente
			panelCentral.add(contenedor, BorderLayout.CENTER);
		}

		panelCentral.revalidate();
		panelCentral.repaint();
	}

	// Método para habilitar/deshabilitar la visualización del título
	public void setMostrarTitulo(boolean mostrar) {
		this.mostrarTitulo = mostrar;
		if (mostrar && etiquetaNombreUniversidad == null) {
			// Crear la etiqueta si no existe
			etiquetaNombreUniversidad = new JLabel("Registrar Universidad", SwingConstants.CENTER);
			etiquetaNombreUniversidad.setFont(new Font("Arial", Font.BOLD, 24));
			etiquetaNombreUniversidad.setForeground(new Color(31, 52, 72));
		}
	}

	// Metodo para actualizar el nombre de la universidad
	public void setNombreUniversidad(String nombreUniversidad) {
		// Primero habilitar la visualización del título si no está habilitada
		if (!mostrarTitulo) {
			setMostrarTitulo(true);
		}

		if (nombreUniversidad != null && !nombreUniversidad.trim().isEmpty()) {
			etiquetaNombreUniversidad.setText(nombreUniversidad);
		} else {
			etiquetaNombreUniversidad.setText("Universidad no registrada");
		}
	}

	public void setLabelText(String text) {
		// Mantenemos este método por compatibilidad, pero ahora usa setNombreUniversidad
		setNombreUniversidad(text);
	}

	public JButton getBtnActualizarU() {
		return boton1;
	}

	public JButton getBtnAgregarE() {
		return boton2;
	}

	public JButton getBtnConsultarE() {
		return boton3;
	}

	public JButton getBtnAdministrarP() {
		return boton4;
	}

	public JPanel getPanelCentral() {
		return panelCentral;
	}

	public void addButton1Listener(ActionListener listener) {
		boton1.addActionListener(listener);
	}

	public void addButton2Listener(ActionListener listener) {
		boton2.addActionListener(listener);
	}

	public void addButton3Listener(ActionListener listener) {
		boton3.addActionListener(listener);
	}

	public void addButton4Listener(ActionListener listener) {
		boton4.addActionListener(listener);
	}
}