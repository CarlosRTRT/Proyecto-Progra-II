package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import models.Escuela;

public class ConsultarCursoView extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private JTextField txtNombreCursoBuscar;
    private JTextArea txtResultado;
    private JButton btnBuscar, btnVolver;
    private Escuela escuelaActual;
    
    public ConsultarCursoView(Escuela escuela) {
        this.escuelaActual = escuela;
        init();
    }
    
    private void init() {
        // Configuracion de la ventana
        setTitle("Consultar Curso - " + escuelaActual.getNombre());
        setLayout(new BorderLayout(15, 15));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        
        // Panel de busqueda
        JPanel panelBusqueda = new JPanel(new BorderLayout(10, 10));
        panelBusqueda.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY, 2, true),
            "Buscar Curso",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("SansSerif", Font.BOLD, 14),
            Color.GRAY
        ));
        
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JLabel lblNombre = new JLabel("Nombre del Curso:");
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 12));
        
        txtNombreCursoBuscar = new JTextField(20);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 12));
        
        inputPanel.add(lblNombre);
        inputPanel.add(txtNombreCursoBuscar);
        inputPanel.add(btnBuscar);
        
        panelBusqueda.add(inputPanel, BorderLayout.NORTH);
        
        // Panel de resultado
        JPanel panelResultado = new JPanel(new BorderLayout());
        panelResultado.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            "Resultado",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        txtResultado = new JTextArea(8, 40);
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtResultado.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        panelResultado.add(scrollPane, BorderLayout.CENTER);
        
        // Panel de boton volver
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        btnVolver = new JButton("Volver");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFocusPainted(false);
        btnVolver.setFont(new Font("SansSerif", Font.BOLD, 12));
        
        panelBotones.add(btnVolver);
        
        // Añadir paneles a la ventana
        add(panelBusqueda, BorderLayout.NORTH);
        add(panelResultado, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
    
    // Getters
    public String getNombreCursoBuscar() {
        return txtNombreCursoBuscar.getText();
    }
    
    public void setResultado(String resultado) {
        txtResultado.setText(resultado);
    }
    
    public JButton getBtnBuscar() {
        return btnBuscar;
    }
    
    public JButton getBtnVolver() {
        return btnVolver;
    }
    
    public Escuela getEscuelaActual() {
        return escuelaActual;
    }
}