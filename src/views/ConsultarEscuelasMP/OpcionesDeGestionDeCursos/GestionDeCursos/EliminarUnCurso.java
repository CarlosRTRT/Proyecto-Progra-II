package views.ConsultarEscuelasMP.OpcionesDeGestionDeCursos.GestionDeCursos;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import models.Escuela;

public class EliminarUnCurso extends JPanel {
    private static final long serialVersionUID = 1L;

    private JTextField txtNombreCurso;
    private JButton btnEliminar, btnCancelar;
    private Escuela escuelaActual;

    public EliminarUnCurso(Escuela escuela) {
        this.escuelaActual = escuela;
        init();
    }

    private void init() {
        // Configuración de la ventana - TAMAÑO AUMENTADO
        setLayout(new BorderLayout(20, 20));
        setPreferredSize(new Dimension(650, 300));

        // Panel principal con más espacio
        JPanel panelPrincipal = new JPanel(new BorderLayout(15, 15));
        panelPrincipal.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(40, 40, 30, 40),
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.RED, 2, true),
                        "Eliminar Curso",
                        TitledBorder.CENTER,
                        TitledBorder.TOP,
                        new Font("SansSerif", Font.PLAIN, 16),
                        Color.RED
                )
        ));

        // Panel de entrada con más espacio
        JPanel panelEntrada = new JPanel(new GridLayout(1, 2, 20, 0));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        JLabel lblNombre = new JLabel("Nombre del Curso:");
        lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblNombre.setHorizontalAlignment(SwingConstants.LEFT);

        txtNombreCurso = new JTextField();
        txtNombreCurso.setPreferredSize(new Dimension(300, 40));
        txtNombreCurso.setFont(new Font("SansSerif", Font.PLAIN, 13));

        panelEntrada.add(lblNombre);
        panelEntrada.add(txtNombreCurso);

        // Añadir mensaje de advertencia más grande
        JLabel lblAdvertencia = new JLabel("⚠️ ADVERTENCIA: Esta acción no se puede deshacer.");
        lblAdvertencia.setForeground(Color.RED);
        lblAdvertencia.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblAdvertencia.setHorizontalAlignment(SwingConstants.CENTER);
        lblAdvertencia.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        // Panel de botones con más espacio
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(new Color(220, 53, 69));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setPreferredSize(new Dimension(150, 40));

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(108, 117, 125));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setPreferredSize(new Dimension(150, 40));

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