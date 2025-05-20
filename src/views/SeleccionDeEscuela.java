package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import models.Escuela;
import models.Universidad;

public class SchoolsView extends JPanel {
    private static final long serialVersionUID = 1L;

    private JComboBox<String> comboEscuelas;
    private JButton btnConsultar, btnGestionarCursos, btnVolver;
    private Universidad universidad;

    public SchoolsView(Universidad universidad) {
        this.universidad = universidad;
        init();
    }

    private void init() {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(650, 300));

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
                "Seleccion de Escuela",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("SansSerif", Font.PLAIN, 14),
                Color.GRAY
        ));

        JPanel panelSeleccion = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelSeleccion.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 0));

        JLabel lblEscuela = new JLabel("Escuela:");
        lblEscuela.setFont(new Font("SansSerif", Font.PLAIN, 13));

        comboEscuelas = new JComboBox<>();
        comboEscuelas.setPreferredSize(new Dimension(300, 40));
        comboEscuelas.setFont(new Font("SansSerif", Font.PLAIN, 13));
        actualizarListaEscuelas();

        panelSeleccion.add(lblEscuela);
        panelSeleccion.add(comboEscuelas);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));

        btnGestionarCursos = new JButton("Gestionar Cursos");
        btnGestionarCursos.setBackground(Color.BLUE);
        btnGestionarCursos.setForeground(Color.WHITE);
        btnGestionarCursos.setFocusPainted(false);
        btnGestionarCursos.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnGestionarCursos.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnVolver.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        panelBotones.add(btnGestionarCursos);

        panelPrincipal.add(panelSeleccion, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        if (btnVolver != null) {
            panelInferior.add(btnVolver);
        }

        add(panelPrincipal, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    public void actualizarListaEscuelas() {
        comboEscuelas.removeAllItems();
        for(Escuela escuela : universidad.getVector()) {
            comboEscuelas.addItem(escuela.getNombre());
        }
    }

    public Escuela getEscuelaSeleccionada() {
        int index = comboEscuelas.getSelectedIndex();
        if(index >= 0) {
            return universidad.getVector().get(index);
        }
        return null;
    }

    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    public JButton getBtnGestionarCursos() {
        return btnGestionarCursos;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public Universidad getUniversidad() {
        return universidad;
    }
}
