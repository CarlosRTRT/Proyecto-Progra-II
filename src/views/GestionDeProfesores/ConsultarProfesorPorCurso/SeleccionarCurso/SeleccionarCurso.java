package views.GestionDeProfesores.ConsultarProfesorPorCurso.SeleccionarCurso;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class SeleccionarCurso extends JPanel {

    private static final long serialVersionUID = 1L;

    private JList<String> listaCursos;
    private DefaultListModel<String> modeloCursos;
    private JButton btnSeleccionar;
    private JButton btnVolver;

    public SeleccionarCurso() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout(15, 15));
        setPreferredSize(new Dimension(500, 400));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel superior con título
        JPanel panelTitulo = new JPanel(new BorderLayout());
        JLabel lblTitulo = new JLabel("Seleccionar Curso");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelTitulo.add(lblTitulo, BorderLayout.CENTER);

        // Panel central con lista de cursos
        JPanel panelLista = new JPanel(new BorderLayout());
        panelLista.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        modeloCursos = new DefaultListModel<>();
        listaCursos = new JList<>(modeloCursos);
        listaCursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaCursos.setFixedCellHeight(30);
        listaCursos.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(listaCursos);
        scrollPane.setPreferredSize(new Dimension(450, 300));

        panelLista.add(scrollPane, BorderLayout.CENTER);

        // Panel inferior con botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));

        btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnSeleccionar.setPreferredSize(new Dimension(250, 40));
        btnSeleccionar.setFocusPainted(false);

        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnVolver.setPreferredSize(new Dimension(250, 40));

        btnVolver.setFocusPainted(false);

        panelBotones.add(btnSeleccionar);
        panelBotones.add(btnVolver);

        // Agregar componentes al panel principal
        add(panelTitulo, BorderLayout.NORTH);
        add(panelLista, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    // Getters
    public JList<String> getListaCursos() {
        return listaCursos;
    }

    public DefaultListModel<String> getModeloCursos() {
        return modeloCursos;
    }

    public JButton getBtnSeleccionar() {
        return btnSeleccionar;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    // Método para agregar cursos a la lista
    public void agregarCurso(String curso) {
        modeloCursos.addElement(curso);
    }

    // Método para obtener el curso seleccionado
    public String getCursoSeleccionado() {
        return listaCursos.getSelectedValue();
    }
}