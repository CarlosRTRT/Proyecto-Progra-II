package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AgregarEscuela extends JPanel {
    
    private static final long serialVersionUID = 1L;
    
    // Componentes para escuelas
    private JTextField txtNombreEscuela;
    private JButton btnAgregarEscuela;
    
    public AgregarEscuela() {
        init();
    }
    private void init() {
    	// Configuracion de la ventana
    	setLayout(new BorderLayout());
    	setSize(600, 325);
        JPanel mainPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel panelEscuelas = new JPanel(new GridLayout(3, 2, 10, 10));

    	PAgregar(mainPanel, panelEscuelas);
    } 

    public void PAgregar(JPanel mainPanel, JPanel panelEscuelas) {
    	// Panel para gestionar escuelas
        
        panelEscuelas.setBorder(BorderFactory.createTitledBorder("Gestion de Escuelas"));
        
        txtNombreEscuela = new JTextField();
        panelEscuelas.add(new JLabel("Nombre de Escuela:"));
        panelEscuelas.add(txtNombreEscuela);
        
        btnAgregarEscuela = new JButton("Agregar Escuela");
        panelEscuelas.add(new JLabel(""));
        panelEscuelas.add(btnAgregarEscuela);        
        add(panelEscuelas, BorderLayout.CENTER);
    }


    
    // Getters para los componentes
    
    public JTextField getTxtNombreEscuela() {
        return txtNombreEscuela;
    }
    
    public JButton getBtnAgregarEscuela() {
        return btnAgregarEscuela;
    }

}