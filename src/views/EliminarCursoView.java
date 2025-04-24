package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import models.Escuela;

public class EliminarCursoView extends JPanel {
    private static final long serialVersionUID = 1L;
    
    private JTextField txtNombreCurso;
    private JButton btnEliminar, btnCancelar;
    private Escuela escuelaActual;
    
    public EliminarCursoView(Escuela escuela) {
        this.escuelaActual = escuela;
        init();
    }
    
    private void init() {
        // Configuracion de la ventana
        setLayout(new BorderLayout(15, 15));
        setSize(400, 200);
        
        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.RED, 1, true),
            "Eliminar Curso",
            TitledBorder.CENTER,
            TitledBorder.TOP,
            new Font("SansSerif", Font.PLAIN, 14),
            Color.RED
        ));
        
        // Panel de entrada
        JPanel panelEntrada = new JPanel(new GridLayout(1, 2, 10, 0));
        
        JLabel lblNombre = new JLabel("Nombre del Curso:");
        lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        txtNombreCurso = new JTextField();
        
        panelEntrada.add(lblNombre);
        panelEntrada.add(txtNombreCurso);
        
        // Añadir mensaje de advertencia
        JLabel lblAdvertencia = new JLabel("ADVERTENCIA: Esta accion no se puede deshacer.");
        lblAdvertencia.setForeground(Color.RED);
        lblAdvertencia.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblAdvertencia.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(new Color(220, 53, 69));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(108, 117, 125));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        panelBotones.add(btnEliminar);
        panelBotones.add(btnCancelar);
        
        // Añadir componentes al panel principal
        panelPrincipal.add(panelEntrada, BorderLayout.NORTH);
        panelPrincipal.add(lblAdvertencia, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        
        // Añadir panel a la ventana
        add(panelPrincipal, BorderLayout.CENTER);
    }
    
    // Getters
    public String getNombreCurso() {
        return txtNombreCurso.getText();
    }
    
    public JButton getBtnEliminar() {
        return btnEliminar;
    }
    
    public JButton getBtnCancelar() {
        return btnCancelar;
    }
    
    public Escuela getEscuelaActual() {
        return escuelaActual;
    }
}