package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class GestionDeProfesores extends JPanel {
    private static final long serialVersionUID = 1L;

    private JButton btnAgregarProfesor;
    private JButton btnAdministrarProfesor;
    private JButton btnConsultarEscuelas;
    private JButton btnConsultarProfesorPorCurso;

    public GestionDeProfesores() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(650, 300));

        // Panel principal con los botones
        JPanel panelOpciones = new JPanel(new GridLayout(4, 1, 0, 10));
        panelOpciones.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
                "Gestion de Profesores",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("SansSerif", Font.PLAIN, 14),
                Color.GRAY
        ));

        // Crear botones
        btnAgregarProfesor = crearBoton("Agregar Profesor");
        btnAdministrarProfesor = crearBoton("Administrar Profesor");
        btnConsultarEscuelas = crearBoton("Consultar De Escuelas");
        btnConsultarProfesorPorCurso = crearBoton("Consultar Profesor por Curso");

        // Añadir botones al panel
        panelOpciones.add(btnAgregarProfesor);
        panelOpciones.add(btnAdministrarProfesor);
        panelOpciones.add(btnConsultarEscuelas);
        panelOpciones.add(btnConsultarProfesorPorCurso);

        // Panel contenedor para centrar las opciones
        JPanel panelContenedor = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelContenedor.add(panelOpciones);

        add(panelContenedor, BorderLayout.CENTER);
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setPreferredSize(new Dimension(250, 40));
        boton.setFocusPainted(false);
        boton.setFont(new Font("SansSerif", Font.PLAIN, 13));
        return boton;
    }

    // Getters para los botones
    public JButton getBtnAgregarProfesor() {
        return btnAgregarProfesor;
    }

    public JButton getBtnAdministrarProfesor() {
        return btnAdministrarProfesor;
    }

    public JButton getBtnConsultarEscuelas() {
        return btnConsultarEscuelas;
    }

    public JButton getBtnConsultarProfesorPorCurso() {
        return btnConsultarProfesorPorCurso;
    }
}