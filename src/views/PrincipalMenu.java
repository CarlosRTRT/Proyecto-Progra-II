package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class PrincipalMenu extends JFrame {
	private static final long serialVersionUID = 1L;

	public JTextField nombre, direccion, telefono;
	public JButton btnAgregar;

	public PrincipalMenu() {
		init();		
	}

	private void init() {
		// Ventana Principal
		setTitle("Registro de Universidad");
		setLayout(new BorderLayout(15, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 250);
		setLocationRelativeTo(null);


		// Panel Formulario
		JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 15, 15));
		panelFormulario.setBorder(BorderFactory.createTitledBorder(
			BorderFactory.createLineBorder(Color.GRAY, 2, true),
			"Datos de la Universidad",
			TitledBorder.CENTER,
			TitledBorder.TOP,
			new Font("SansSerif", Font.BOLD, 14),
			Color.GRAY
		));
		
		panelFormulario.setPreferredSize(new Dimension(500, 150));


		Font labelFont = new Font("SansSerif", Font.BOLD, 13);
		Border leftPadding = BorderFactory.createEmptyBorder(0, 5, 0, 0);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(labelFont);
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setBorder(leftPadding);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(labelFont);
		lblDireccion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDireccion.setBorder(leftPadding);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(labelFont);
		lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefono.setBorder(leftPadding);

		nombre = new JTextField();
		direccion = new JTextField();
		telefono = new JTextField();

		panelFormulario.add(lblNombre);
		panelFormulario.add(nombre);
		panelFormulario.add(lblDireccion);
		panelFormulario.add(direccion);
		panelFormulario.add(lblTelefono);
		panelFormulario.add(telefono);

		// Boton
		btnAgregar = new JButton("Agregar Universidad");
		btnAgregar.setBackground(Color.BLUE);
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFocusPainted(false);
		btnAgregar.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnAgregar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelBoton.add(btnAgregar);

		add(panelFormulario, BorderLayout.CENTER);
		add(panelBoton, BorderLayout.SOUTH);
	}

	public JButton getButtonAgregar() {
		return btnAgregar;
	}
	public String getNombreView() {
		return nombre.getText();
	}
	public String getDireccionView() {
		return direccion.getText();
	}
	public String getTelefonoView() {
		return telefono.getText();
	}
}
