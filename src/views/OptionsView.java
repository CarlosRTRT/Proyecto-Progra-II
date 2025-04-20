package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OptionsView extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    // Componentes para modificar universidad
    private JTextField txtDireccion, txtTelefono;
    private JButton btnModificar;
    
    // Componentes para escuelas
    private JTextField txtNombreEscuela;
    private JButton btnAgregarEscuela;
    private JButton btnConsultarEscuelas;
    
    public OptionsView() {
        init();
    }
    
    private void init() {
        // Configuración de la ventana
        setTitle("Opciones de Universidad");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 325);
        setLocationRelativeTo(null);
        
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
        
        // Panel para gestionar escuelas
        JPanel panelEscuelas = new JPanel(new GridLayout(3, 2, 10, 10));
        panelEscuelas.setBorder(BorderFactory.createTitledBorder("Gestion de Escuelas"));
        
        txtNombreEscuela = new JTextField();
        panelEscuelas.add(new JLabel("Nombre de Escuela:"));
        panelEscuelas.add(txtNombreEscuela);
        
        btnAgregarEscuela = new JButton("Agregar Escuela");
        panelEscuelas.add(new JLabel(""));
        panelEscuelas.add(btnAgregarEscuela);
        
        btnConsultarEscuelas = new JButton("Consultar Escuelas");
        panelEscuelas.add(new JLabel(""));
        panelEscuelas.add(btnConsultarEscuelas);
        
        // Organizar panels en la ventana
        JPanel mainPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        mainPanel.add(panelModificar);
        mainPanel.add(panelEscuelas);
        
        add(mainPanel, BorderLayout.CENTER);
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
    
    public JTextField getTxtNombreEscuela() {
        return txtNombreEscuela;
    }
    
    public JButton getBtnAgregarEscuela() {
        return btnAgregarEscuela;
    }
    
    public JButton getBtnConsultarEscuelas() {
        return btnConsultarEscuelas;
    }
}