package views.ConsultarEscuelasMP.OpcionesDeGestionDeCursos.GestionDeCursos;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import models.Escuela;

public class AgregarUnCurso extends JPanel{
    private static final long serialVersionUID = 1L;

    private JTextField txtSigla, txtNombreCurso, txtCreditos;
    private JButton btnGuardar, btnCancelar;
    private Escuela escuelaActual;

    public AgregarUnCurso(Escuela escuela) {
        this.escuelaActual = escuela;
        init();
    }

    private void init() {
        // Configuración básica de la ventana - TAMAÑO AUMENTADO
        setLayout(new BorderLayout(20, 20));
        setPreferredSize(new Dimension(600, 400));

        // Panel de formulario con más espacio
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 15, 20));
        panelFormulario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(50, 40, 30, 40),
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
                        "Datos del Curso",
                        TitledBorder.CENTER,
                        TitledBorder.TOP,
                        new Font("SansSerif", Font.PLAIN, 16),
                        Color.GRAY
                )
        ));

        // Componentes del formulario con fuentes más grandes
        Font labelFont = new Font("SansSerif", Font.PLAIN, 14);

        JLabel lblSigla = new JLabel("Siglas (3 caracteres):");
        lblSigla.setFont(labelFont);
        lblSigla.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel lblNombre = new JLabel("Nombre del Curso:");
        lblNombre.setFont(labelFont);
        lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
        
        // NUEVO LABEL PARA CRÉDITOS
        JLabel lblCreditos = new JLabel("Créditos del Curso:");
        lblCreditos.setFont(labelFont);
        lblCreditos.setHorizontalAlignment(SwingConstants.LEFT);

        txtSigla = new JTextField();
        txtSigla.setPreferredSize(new Dimension(200, 40));
        txtSigla.setFont(new Font("SansSerif", Font.PLAIN, 13));

        txtNombreCurso = new JTextField();
        txtNombreCurso.setPreferredSize(new Dimension(200, 40));
        txtNombreCurso.setFont(new Font("SansSerif", Font.PLAIN, 13));
        
        // NUEVO CAMPO PARA CRÉDITOS
        txtCreditos = new JTextField();
        txtCreditos.setPreferredSize(new Dimension(200, 40));
        txtCreditos.setFont(new Font("SansSerif", Font.PLAIN, 13));

        // Crear paneles para envolver cada campo
        JPanel panelSigla = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
        panelSigla.add(txtSigla);
        panelSigla.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));

        JPanel panelNombreCurso = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
        panelNombreCurso.add(txtNombreCurso);
        panelNombreCurso.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));
       
        // NUEVO PANEL PARA CRÉDITOS
        JPanel panelCreditos = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
        panelCreditos.add(txtCreditos);
        panelCreditos.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));


        panelFormulario.add(lblSigla);
        panelFormulario.add(panelSigla);
        panelFormulario.add(lblNombre);
        panelFormulario.add(panelNombreCurso);
        // AGREGAR LOS NUEVOS COMPONENTES DE CRÉDITOS
        panelFormulario.add(lblCreditos);
        panelFormulario.add(panelCreditos);

        // Panel de botones con más espacio
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(Color.BLUE);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btnGuardar.setPreferredSize(new Dimension(250, 40));

        btnCancelar = new JButton("Volver");
        btnCancelar.setBackground(new Color(108, 117, 125));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btnCancelar.setPreferredSize(new Dimension(250, 40));

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
    
    // NUEVO GETTER PARA CRÉDITOS
    public String getCreditos() {
        return txtCreditos.getText();
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
