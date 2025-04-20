package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import models.Escuela;

public class ModificarCursoView extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private JTextField txtNombreCursoBuscar, txtNuevoNombre;
    private JButton btnBuscar, btnGuardar, btnCancelar;
    private Escuela escuelaActual;
    
    public ModificarCursoView(Escuela escuela) {
        this.escuelaActual = escuela;
        init();
    }
    
    private void init() {
        // Configuracion basica de la ventana
        setTitle("Modificar Curso - " + escuelaActual.getNombre());
        setLayout(new BorderLayout(15, 15));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 210);
        setLocationRelativeTo(null);
        
        // Panel de busqueda
        JPanel panelBusqueda = new JPanel(new GridLayout(1, 3, 10, 0));
        panelBusqueda.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1, true),
            "Buscar Curso",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("SansSerif", Font.PLAIN, 14),
            Color.GRAY
        ));
        
        JLabel lblNombreBuscar = new JLabel("Nombre del Curso:");
        lblNombreBuscar.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        txtNombreCursoBuscar = new JTextField();
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        panelBusqueda.add(lblNombreBuscar);
        panelBusqueda.add(txtNombreCursoBuscar);
        panelBusqueda.add(btnBuscar);
        
        // Panel de modificacion
        JPanel panelModificacion = new JPanel(new BorderLayout(10, 10));
        panelModificacion.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            "Modificar Curso",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        JPanel panelCampos = new JPanel(new GridLayout(1, 2, 10, 0));
        
        JLabel lblNuevoNombre = new JLabel("Nuevo Nombre:");
        lblNuevoNombre.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        txtNuevoNombre = new JTextField();
        
        panelCampos.add(lblNuevoNombre);
        panelCampos.add(txtNuevoNombre);
        
        JPanel panelBotonesAccion = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        btnGuardar = new JButton("Guardar");
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        panelBotonesAccion.add(btnGuardar);
        panelBotonesAccion.add(btnCancelar);
        
        panelModificacion.add(panelCampos, BorderLayout.NORTH);
        panelModificacion.add(panelBotonesAccion, BorderLayout.CENTER);
        
        // Añadir paneles a la ventana
        add(panelBusqueda, BorderLayout.NORTH);
        add(panelModificacion, BorderLayout.CENTER);
    }
    
    // Getters
    public String getNombreCursoBuscar() {
        return txtNombreCursoBuscar.getText();
    }
    
    public String getNuevoNombre() {
        return txtNuevoNombre.getText();
    }
    
    public JButton getBtnBuscar() {
        return btnBuscar;
    }
    
    public JButton getBtnGuardar() {
        return btnGuardar;
    }
    
    public JButton getBtnCancelar() {
        return btnCancelar;
    }
    
    public Escuela getEscuelaActual() {
        return escuelaActual;
    }
}