package views.Estudiantes;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class DetalleEstudiante extends JPanel{

    private static final long serialVersionUID = 1L;

    private JPanel panelDatosEstudiante;
    private JPanel panelCursosEstudiante;
    private JButton btnModificarDatos;
    private JButton btnModificarCurso;
    private JButton btnVolver;
    private JTable tablaCursos;

    public DetalleEstudiante() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout(10, 15));
        setPreferredSize(new Dimension(700, 500));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel para datos del estudiante
        panelDatosEstudiante = new JPanel(new GridLayout(6, 2, 5, 10));
        panelDatosEstudiante.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Datos del Estudiante",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("SansSerif", Font.BOLD, 14)
        ));

        // Agregar campos para los datos del estudiante (serán llenados dinámicamente)
        panelDatosEstudiante.add(new JLabel("Cédula:"));
        panelDatosEstudiante.add(new JLabel(""));
        panelDatosEstudiante.add(new JLabel("Carnet:"));
        panelDatosEstudiante.add(new JLabel(""));
        panelDatosEstudiante.add(new JLabel("Nombre:"));
        panelDatosEstudiante.add(new JLabel(""));
        panelDatosEstudiante.add(new JLabel("Apellidos:"));
        panelDatosEstudiante.add(new JLabel(""));
        panelDatosEstudiante.add(new JLabel("Nacionalidad:"));
        panelDatosEstudiante.add(new JLabel(""));
        panelDatosEstudiante.add(new JLabel("Porcentaje de Beca:"));
        panelDatosEstudiante.add(new JLabel(""));

        // Panel para cursos del estudiante
        panelCursosEstudiante = new JPanel(new BorderLayout(5, 5));
        panelCursosEstudiante.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Cursos Matriculados",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("SansSerif", Font.BOLD, 14)
        ));

        // Tabla de cursos
        String[] columnNames = {"Sigla", "Nombre del Curso", "Escuela", "Créditos"};
        Object[][] data = {}; // Se llenará dinámicamente

        tablaCursos = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(tablaCursos);
        scrollPane.setPreferredSize(new Dimension(600, 150));

        panelCursosEstudiante.add(scrollPane, BorderLayout.CENTER);

        // Panel para botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelBotones.setPreferredSize(new Dimension(750, 50));

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
        add(panelDatosEstudiante, BorderLayout.NORTH);
        add(panelCursosEstudiante, BorderLayout.CENTER);
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
    public void actualizarDatosEstudiante(String cedula, String carnet, String nombre, 
                                         String apellidos, String nacionalidad, String porcentajeBeca) {
        JLabel lblCedulaValor = (JLabel) panelDatosEstudiante.getComponent(1);
        JLabel lblCarnetValor = (JLabel) panelDatosEstudiante.getComponent(3);
        JLabel lblNombreValor = (JLabel) panelDatosEstudiante.getComponent(5);
        JLabel lblApellidosValor = (JLabel) panelDatosEstudiante.getComponent(7);
        JLabel lblNacionalidadValor = (JLabel) panelDatosEstudiante.getComponent(9);
        JLabel lblBecaValor = (JLabel) panelDatosEstudiante.getComponent(11);

        lblCedulaValor.setText(cedula);
        lblCarnetValor.setText(carnet);
        lblNombreValor.setText(nombre);
        lblApellidosValor.setText(apellidos);
        lblNacionalidadValor.setText(nacionalidad);
        lblBecaValor.setText(porcentajeBeca + "%");
    }
	
}
