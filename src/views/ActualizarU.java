package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ActualizarU extends JPanel {
    
    private static final long serialVersionUID = 1L;
    
    // Componentes para modificar universidad
    private JTextField txtDireccion, txtTelefono;
    private JButton btnModificar;
    

    public ActualizarU() {
        init();
    }
    private void init() {
        JPanel mainPanel = new JPanel(new GridLayout(2, 1, 10, 10));

    	PModificar(mainPanel);
    } 
    public void PModificar(JPanel mainPanel) {
    	// Panel para modificar datos de universidad
        JPanel panelModificar = new JPanel(new GridLayout(3, 2, 10, 10));
        panelModificar.setBorder(BorderFactory.createTitledBorder("Modificar Universidad"));
        
        txtDireccion = new JTextField();
        panelModificar.add(new JLabel("Nueva Direccion:"));
        panelModificar.add(txtDireccion);
        
        txtTelefono = new JTextField();
        panelModificar.add(new JLabel("Nuevo Telefono:"));
        panelModificar.add(txtTelefono);
        
        btnModificar = new JButton("Actualizar Datos");
        panelModificar.add(new JLabel(""));
        panelModificar.add(btnModificar);
        
        // Organizar panels en la ventana
        mainPanel.add(panelModificar);

        
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