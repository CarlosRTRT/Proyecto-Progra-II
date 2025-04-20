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
		//Ventana Principal
		setTitle("Registro de Universidad");
		setLayout(new BorderLayout(15, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 240);
		setLocationRelativeTo(null);


		//Panel Formulario
		JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 25, 2));
		panelFormulario.setBorder(BorderFactory.createTitledBorder(
			BorderFactory.createLineBorder(Color.GRAY, 1, true),
			"Datos de la Universidad",
			TitledBorder.CENTER,
			TitledBorder.TOP,
			new Font("SansSerif", Font.PLAIN, 14),
			Color.GRAY
		));
		
		panelFormulario.setPreferredSize(new Dimension(500, 170));


		Font labelFont = new Font("SansSerif", Font.PLAIN, 13);
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

		//Campos de texto
		nombre = new JTextField();
		direccion = new JTextField();
		telefono = new JTextField();

		//Ajustar altura de los campos
		nombre.setPreferredSize(new Dimension(200, 25));
		direccion.setPreferredSize(new Dimension(200, 25));
		telefono.setPreferredSize(new Dimension(200, 25));

		//Crear paneles para envolver cada campo
		JPanel panelNombre = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panelNombre.add(nombre);

		JPanel panelDireccion = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panelDireccion.add(direccion);

		JPanel panelTelefono = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panelTelefono.add(telefono);

		//Agregar al formulario
		panelFormulario.add(lblNombre);
		panelFormulario.add(panelNombre);

		panelFormulario.add(lblDireccion);
		panelFormulario.add(panelDireccion);

		panelFormulario.add(lblTelefono);
		panelFormulario.add(panelTelefono);


		//Boton
		btnAgregar = new JButton("Agregar Universidad");
		btnAgregar.setBackground(Color.BLUE);
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFocusPainted(false);
		btnAgregar.setFont(new Font("SansSerif", Font.PLAIN, 13));
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
