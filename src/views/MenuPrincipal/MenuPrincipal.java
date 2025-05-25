package views.MenuPrincipal;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class MenuPrincipal extends JPanel {
	private static final long serialVersionUID = 1L;

	public JTextField nombre, direccion, telefono;
	public JButton btnAgregar;

	public MenuPrincipal() {
		init();		
	}

	private void init() {
		//Ventana Principal
		setLayout(new BorderLayout());
	    setPreferredSize(new Dimension(650, 400));

		//Panel Formulario
		JPanel panelFormulario = new JPanel(new GridLayout(3, 2));
		panelFormulario.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(50, 0, 0, 0),
				BorderFactory.createTitledBorder(
						BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
						"Datos de la Universidad",
						TitledBorder.CENTER,
						TitledBorder.TOP,
						new Font("SansSerif", Font.PLAIN, 14),
						Color.GRAY
				)
		));


		Font labelFont = new Font("SansSerif", Font.PLAIN, 13);
		Border leftPadding = BorderFactory.createEmptyBorder(0, 80, 0, 0);

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
		nombre.setPreferredSize(new Dimension(300, 40));
		direccion.setPreferredSize(new Dimension(300, 40));
		telefono.setPreferredSize(new Dimension(300, 40));
		

		//Crear paneles para envolver cada campo
		JPanel panelNombre = new JPanel(new FlowLayout());
		panelNombre.add(nombre);
		panelNombre.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

		JPanel panelDireccion = new JPanel(new FlowLayout());
		panelDireccion.add(direccion);
		panelDireccion.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

		JPanel panelTelefono = new JPanel(new FlowLayout());
		panelTelefono.add(telefono);
		panelTelefono.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

		//Agregar al formulario
		panelFormulario.add(lblNombre);
		panelFormulario.add(panelNombre);

		panelFormulario.add(lblDireccion);
		panelFormulario.add(panelDireccion);

		panelFormulario.add(lblTelefono);
		panelFormulario.add(panelTelefono);


		//Boton
		btnAgregar = new JButton("Agregar Universidad");
		btnAgregar.setPreferredSize(new Dimension(250, 40));
		btnAgregar.setBackground(Color.BLUE);
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFocusPainted(false);
		btnAgregar.setFont(new Font("SansSerif", Font.PLAIN, 13));

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
