package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ActualizarU extends JPanel {
    
    private static final long serialVersionUID = 1L;
    
    // Componentes para modificar universidad
    private JTextField txtDireccion, txtTelefono;
    private JButton btnModificar;
    

    public ActualizarU() {
        init();
    }
    private void init() {
    	
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        mainPanel.setPreferredSize(new Dimension(650, 350));


    	PModificar(mainPanel);
    } 
    public void PModificar(JPanel mainPanel) {
    	// Panel para modificar datos de universidad
        JPanel panelModificar = new JPanel(new GridLayout(3, 2));
		panelModificar.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
				"Modificar Universidad",
				TitledBorder.CENTER,
				TitledBorder.TOP,
				new Font("SansSerif", Font.PLAIN, 14),
				Color.GRAY
			));        
        //Labels
        JLabel lblDireccion = new JLabel("Nueva Direccion:");
        lblDireccion.setBorder(BorderFactory.createEmptyBorder(0,80,0,0));
        JLabel lblTelefono = new JLabel("Nuevo Telefono");
        lblTelefono.setBorder(BorderFactory.createEmptyBorder(0,80,0,0));

        
        txtDireccion = new JTextField();
		txtDireccion.setPreferredSize(new Dimension(300, 40));
        panelModificar.add(lblDireccion);
        JPanel panelDireccion = new JPanel(new FlowLayout());
        panelDireccion.add(txtDireccion);
        panelModificar.add(panelDireccion);
        
        txtTelefono = new JTextField();
		txtTelefono.setPreferredSize(new Dimension(300, 40));
        panelModificar.add(lblTelefono);
        JPanel panelTelefono = new JPanel(new FlowLayout());
        panelTelefono.add(txtTelefono);
        panelModificar.add(panelTelefono);
        
        btnModificar = new JButton("Actualizar Datos");
        //btnModificar.setPreferredSize(new Dimension());
		JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));		
		btnModificar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		panelBoton.add(btnModificar);
        
        // Organizar panels en la ventana
        mainPanel.add(panelModificar);
        mainPanel.add(panelBoton);
        
        add(mainPanel);
    }


    
    // Getters para los componentes
    public JTextField getTxtDireccion() {
        return txtDireccion;
    }
    
    public JTextField getTxtTelefono() {
        return txtTelefono;
    }
    
    public JButton getBtnModificar() {
        return btnModificar;
    }
    

}