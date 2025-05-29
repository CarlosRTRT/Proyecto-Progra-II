package views.GestionDeProfesores.ConsultarProfesorPorCurso.SeleccionarCurso.ProfesorPorCurso;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class ProfesoresPorCurso extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTable tablaProfesores;
    private JButton btnVolver;

    public ProfesoresPorCurso() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout(10, 15));
        setPreferredSize(new Dimension(600, 400));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel para mostrar el título
        JPanel panelTitulo = new JPanel(new BorderLayout());
        JLabel lblTitulo = new JLabel("Muestra Profes de curso");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelTitulo.add(lblTitulo, BorderLayout.CENTER);

        // Panel para curso seleccionado
        JPanel panelCurso = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelCurso.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Curso Seleccionado",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("SansSerif", Font.BOLD, 14)
        ));

        JLabel lblCursoNombre = new JLabel("");
        lblCursoNombre.setFont(new Font("SansSerif", Font.PLAIN, 14));
        panelCurso.add(lblCursoNombre);

        // Panel para la tabla de profesores
        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Profesores del Curso",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("SansSerif", Font.BOLD, 14)
        ));

        // Tabla de profesores
        String[] columnNames = {"Cédula", "Nombre", "Apellido"};
        Object[][] data = {}; // Se llenará dinámicamente

        tablaProfesores = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(tablaProfesores);
        scrollPane.setPreferredSize(new Dimension(550, 250));

        panelTabla.add(scrollPane, BorderLayout.CENTER);

        // Panel para botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnVolver.setFocusPainted(false);

        panelBotones.add(btnVolver);

        // Agregar componentes al panel principal
        add(panelTitulo, BorderLayout.NORTH);
        add(panelCurso, BorderLayout.CENTER);
        add(panelTabla, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    // Getters
    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JTable getTablaProfesores() {
        return tablaProfesores;
    }

    // Método para actualizar información del curso
    public void actualizarCurso(String nombreCurso) {
        JPanel panelCurso = (JPanel) this.getComponent(1);
        JLabel lblCursoNombre = (JLabel) panelCurso.getComponent(0);
        lblCursoNombre.setText(nombreCurso);
    }
}