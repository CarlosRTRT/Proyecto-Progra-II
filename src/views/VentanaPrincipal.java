package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panelSuperior, panelCentral;
	private JButton boton1, boton2, boton3, boton4;
	private JLabel etiqueta1;
	private JPanel panel;

	public VentanaPrincipal(JPanel panel) {
		this.panel = panel;
		init();
	}

	private void init() {
		setTitle("Menu De Opciones");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 700);
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
		panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		panelCentral.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		panelCentral.add(panel);
		add(panelCentral, BorderLayout.CENTER);
	}
	public void cambiarPanelCentral(JPanel nuevoPanel) {
		if (panelCentral == null) {
			panelCentral = new JPanel();
			panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 200));
			panelCentral.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			add(panelCentral, BorderLayout.CENTER);
		}

		panelCentral.removeAll();
		panelCentral.add(nuevoPanel);
		panelCentral.revalidate();
		panelCentral.repaint();
	}

	public void setLabelText(String text) {
		etiqueta1.setText(text);
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
