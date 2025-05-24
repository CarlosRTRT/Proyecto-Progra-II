package views.ConsultarEscuelasMP.OpcionesDeGestionDeCursos.GestionDeCursos;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import models.Escuela;

public class DatosDeCurso extends JPanel {
    private static final long serialVersionUID = 1L;

    private JTextField txtNombreCursoBuscar;
    private JTextArea txtResultado;
    private JButton btnBuscar, btnVolver;
    private Escuela escuelaActual;

    public DatosDeCurso(Escuela escuela) {
        this.escuelaActual = escuela;
        init();
    }

    private void init() {
        // Configuración de la ventana - TAMAÑO AUMENTADO
        setLayout(new BorderLayout(20, 20));
        setPreferredSize(new Dimension(650, 450));

        // Panel de búsqueda con más espacio
        JPanel panelBusqueda = new JPanel(new BorderLayout(15, 15));
        panelBusqueda.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(30, 30, 20, 30),
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
                        "Buscar Curso",
                        TitledBorder.CENTER,
                        TitledBorder.TOP,
                        new Font("SansSerif", Font.PLAIN, 16),
                        Color.GRAY
                )
        ));

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        inputPanel.setPreferredSize(new Dimension(90, 100));

        JLabel lblNombre = new JLabel("Nombre del Curso:");
        lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 14));

        txtNombreCursoBuscar = new JTextField(25);
        txtNombreCursoBuscar.setPreferredSize(new Dimension(300, 35));
        txtNombreCursoBuscar.setFont(new Font("SansSerif", Font.PLAIN, 13));

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(Color.BLUE);
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btnBuscar.setFocusPainted(false);

        inputPanel.add(lblNombre);
        inputPanel.add(txtNombreCursoBuscar);
        inputPanel.add(btnBuscar);

        panelBusqueda.add(inputPanel, BorderLayout.CENTER);

        // Panel de resultado con más espacio
        JPanel panelResultado = new JPanel(new BorderLayout(10, 10));
        panelResultado.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 30, 20, 30),
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.DARK_GRAY, 1),
                        "Resultado",
                        TitledBorder.CENTER,
                        TitledBorder.TOP,
                        new Font("SansSerif", Font.PLAIN, 16),
                        Color.GRAY
                )
        ));

        txtResultado = new JTextArea(12, 50);
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 13));
        txtResultado.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(txtResultado);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        panelResultado.add(scrollPane, BorderLayout.CENTER);

        // Panel de botón volver
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));

        btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(108, 117, 125));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFocusPainted(false);
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btnVolver.setBorder(BorderFactory.createEmptyBorder(12, 25, 12, 25));

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