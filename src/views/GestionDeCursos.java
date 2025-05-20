package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import models.Escuela;
import models.Universidad;

public class GestionDeCursos extends JPanel {
    private static final long serialVersionUID = 1L;

    private JButton btnIncluir, btnConsultarCurso, btnListarCursosEscuela;
    private JButton btnListarTodosCursos, btnModificarCurso, btnEliminarCurso;
    private JButton btnVolver;
    private Escuela escuelaActual;
    private Universidad universidad;

    public GestionDeCursos(Escuela escuela, Universidad universidad) {
        this.escuelaActual = escuela;
        this.universidad = universidad;
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(650, 400));

        JPanel panelOpciones = new JPanel();
        panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.Y_AXIS));
        panelOpciones.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
                "Opciones de Gestion de Cursos",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("SansSerif", Font.PLAIN, 14),
                Color.GRAY
        ));

        btnIncluir = createStyledButton("Agregar un Curso");
        btnConsultarCurso = createStyledButton("Datos De Curso");
        btnListarCursosEscuela = createStyledButton("Lista de cursos de la escuela de " + escuelaActual.getNombre());
        btnListarTodosCursos = createStyledButton("Lista de cursos impartidos por la Universidad " + universidad.getNombreU());
        btnModificarCurso = createStyledButton("Modificar los datos de un curso");
        btnEliminarCurso = createStyledButton("Eliminar un curso");

        // Añadir botones al panel con espaciado
        panelOpciones.add(Box.createVerticalStrut(10));
        addButtonWithSpacing(panelOpciones, btnIncluir);
        addButtonWithSpacing(panelOpciones, btnConsultarCurso);
        addButtonWithSpacing(panelOpciones, btnListarCursosEscuela);
        addButtonWithSpacing(panelOpciones, btnListarTodosCursos);
        addButtonWithSpacing(panelOpciones, btnModificarCurso);
        addButtonWithSpacing(panelOpciones, btnEliminarCurso);
        panelOpciones.add(Box.createVerticalStrut(10));

        // Panel para el boton Volver
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnVolver.setFocusPainted(false);
        btnVolver.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panelBotones.add(btnVolver);

        // Añadir paneles al panel principal
        add(panelOpciones, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void addButtonWithSpacing(JPanel panel, JButton button) {
        JPanel buttonWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonWrapper.add(button);
        panel.add(buttonWrapper);
        panel.add(Box.createVerticalStrut(5));
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.PLAIN, 13));
        button.setFocusPainted(false);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setPreferredSize(new Dimension(450, 40));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));

        return button;
    }

    public JButton getBtnIncluir() {
        return btnIncluir;
    }

    public JButton getBtnConsultarCurso() {
        return btnConsultarCurso;
    }

    public JButton getBtnListarCursosEscuela() {
        return btnListarCursosEscuela;
    }

    public JButton getBtnListarTodosCursos() {
        return btnListarTodosCursos;
    }

    public JButton getBtnModificarCurso() {
        return btnModificarCurso;
    }

    public JButton getBtnEliminarCurso() {
        return btnEliminarCurso;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public Escuela getEscuelaActual() {
        return escuelaActual;
    }
}
