package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import models.Escuela;

public class IncluirCursoView extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private JTextField txtSigla, txtNombreCurso;
    private JButton btnGuardar, btnCancelar;
    private Escuela escuelaActual;
    
    public IncluirCursoView(Escuela escuela) {
        this.escuelaActual = escuela;
        init();
    }
    
    private void init() {
        // Configuración basica de la ventana
        setTitle("Incluir Nuevo Curso - " + escuelaActual.getNombre());
        setLayout(new BorderLayout(15, 15));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        
        // Panel de formulario
        JPanel panelFormulario = new JPanel(new GridLayout(2, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1, true),
            "Datos del Curso",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("SansSerif", Font.PLAIN, 14),
            Color.GRAY
        ));
        
        // Componentes del formulario
        JLabel lblSigla = new JLabel("Siglas (3 caracteres):");
        lblSigla.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        JLabel lblNombre = new JLabel("Nombre del Curso:");
        lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        txtSigla = new JTextField();
        txtNombreCurso = new JTextField();
        
        panelFormulario.add(lblSigla);
        panelFormulario.add(txtSigla);
        panelFormulario.add(lblNombre);
        panelFormulario.add(txtNombreCurso);
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        btnGuardar = new JButton("Guardar");
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);
        
        // Añadir paneles a la ventana
        add(panelFormulario, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
    
    // Getters
    public String getSigla() {
        return txtSigla.getText();
    }
    
    public String getNombreCurso() {
        return txtNombreCurso.getText();
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