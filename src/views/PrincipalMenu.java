package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 200);
		setLocationRelativeTo(null);
		
		//Formulario
		JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 10, 10));
		panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos de la Universidad"));
		
		nombre = new JTextField();
		panelFormulario.add(new JLabel("Nombre"));
		panelFormulario.add(nombre);
		
		direccion = new JTextField();
		panelFormulario.add(new JLabel("Direccion"));
		panelFormulario.add(direccion);
		
		telefono = new JTextField();
		panelFormulario.add(new JLabel("Telefono"));
		panelFormulario.add(telefono);
		
		btnAgregar = new JButton("Agregar Universidad");
		panelFormulario.add(btnAgregar);
		
		add(panelFormulario, BorderLayout.NORTH);
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