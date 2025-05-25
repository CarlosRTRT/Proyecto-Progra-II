package views.GestionDeProfesores.AdministrarProfesor.DetalleDeProfesor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

public class DetalleProfesor extends JPanel {

    private static final long serialVersionUID = 1L;

    private JPanel panelDatosProfesor;
    private JPanel panelCursosProfesor;
    private JButton btnModificarDatos;
    private JButton btnModificarCurso;
    private JButton btnVolver;
    private JTable tablaCursos;

    public DetalleProfesor() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout(10, 15));
        setPreferredSize(new Dimension(600, 400));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel para datos del profesor
        panelDatosProfesor = new JPanel(new GridLayout(3, 2, 5, 10));
        panelDatosProfesor.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Datos del Profesor",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("SansSerif", Font.BOLD, 14)
        ));

        // Agregar campos para los datos del profesor (serán llenados dinámicamente)
        panelDatosProfesor.add(new JLabel("Cédula:"));
        panelDatosProfesor.add(new JLabel(""));
        panelDatosProfesor.add(new JLabel("Nombre:"));
        panelDatosProfesor.add(new JLabel(""));
        panelDatosProfesor.add(new JLabel("Apellido:"));
        panelDatosProfesor.add(new JLabel(""));

        // Panel para cursos del profesor
        panelCursosProfesor = new JPanel(new BorderLayout(5, 5));
        panelCursosProfesor.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Cursos del Profesor",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("SansSerif", Font.BOLD, 14)
        ));

        // Tabla de cursos
        String[] columnNames = {"Sigla", "Nombre del Curso", "Escuela"};
        Object[][] data = {}; // Se llenará dinámicamente

        tablaCursos = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(tablaCursos);
        scrollPane.setPreferredSize(new Dimension(500, 150));

        panelCursosProfesor.add(scrollPane, BorderLayout.CENTER);

        // Panel para botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelBotones.setPreferredSize(new Dimension(650, 50));

        btnModificarDatos = new JButton("Modificar los datos");
        btnModificarDatos.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnModificarDatos.setPreferredSize(new Dimension(200, 40));

        btnModificarCurso = new JButton("Modificar curso");
        btnModificarCurso.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnModificarCurso.setPreferredSize(new Dimension(200, 40));

        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnVolver.setPreferredSize(new Dimension(150, 40));

        panelBotones.add(btnModificarDatos);
        panelBotones.add(btnModificarCurso);
        panelBotones.add(btnVolver);

        // Agregar componentes al panel principal
        add(panelDatosProfesor, BorderLayout.NORTH);
        add(panelCursosProfesor, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    // Getters para los botones
    public JButton getBtnModificarDatos() {
        return btnModificarDatos;
    }

    public JButton getBtnModificarCurso() {
        return btnModificarCurso;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JTable getTablaCursos() {
        return tablaCursos;
    }

    // Métodos para actualizar la información
    public void actualizarDatosProfesor(String cedula, String nombre, String apellido) {
        JLabel lblCedulaValor = (JLabel) panelDatosProfesor.getComponent(1);
        JLabel lblNombreValor = (JLabel) panelDatosProfesor.getComponent(3);
        JLabel lblApellidoValor = (JLabel) panelDatosProfesor.getComponent(5);

        lblCedulaValor.setText(cedula);
        lblNombreValor.setText(nombre);
        lblApellidoValor.setText(apellido);
    }
}