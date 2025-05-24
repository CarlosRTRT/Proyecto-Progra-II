package views.ConsultarEscuelasMP.OpcionesDeGestionDeCursos.GestionDeCursos;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import models.Universidad;

public class ListaDeCursosPorUniversidad extends JPanel {
    private static final long serialVersionUID = 1L;

    private JTextArea txtListaCursos;
    private JButton btnActualizar, btnVolver;
    private Universidad universidad;

    public ListaDeCursosPorUniversidad(Universidad universidad) {
        this.universidad = universidad;
        init();
    }

    private void init() {
        // Configuración básica de la ventana - TAMAÑO AUMENTADO
        setLayout(new BorderLayout(20, 20));
        setPreferredSize(new Dimension(650, 500));

        // Panel principal con más espacio
        JPanel panelPrincipal = new JPanel(new BorderLayout(15, 15));
        panelPrincipal.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(30, 30, 20, 30),
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
                        "Todos los Cursos" ,
                        TitledBorder.CENTER,
                        TitledBorder.TOP,
                        new Font("SansSerif", Font.PLAIN, 16),
                        Color.GRAY
                )
        ));

        // Área de texto para mostrar los cursos con más espacio
        txtListaCursos = new JTextArea();
        txtListaCursos.setEditable(false);
        txtListaCursos.setFont(new Font("Monospaced", Font.PLAIN, 13));
        txtListaCursos.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JScrollPane scrollPane = new JScrollPane(txtListaCursos);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        scrollPane.setPreferredSize(new Dimension(580, 450));

        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Panel de botones con más espacio
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBackground(Color.BLUE);
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btnActualizar.setFocusPainted(false);

        btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(108, 117, 125));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btnVolver.setFocusPainted(false);

        panelBotones.add(btnActualizar);
        panelBotones.add(btnVolver);

        // Añadir paneles a la ventana
        add(panelPrincipal, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    // Getters y setters
    public void setListaCursos(String texto) {
        txtListaCursos.setText(texto);
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public Universidad getUniversidad() {
        return universidad;
    }
}