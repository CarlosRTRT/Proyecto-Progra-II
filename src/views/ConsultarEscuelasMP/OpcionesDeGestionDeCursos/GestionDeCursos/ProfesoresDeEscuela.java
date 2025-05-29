package views.ConsultarEscuelasMP.OpcionesDeGestionDeCursos.GestionDeCursos;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import models.*;

public class ProfesoresDeEscuela extends JPanel {
    private static final long serialVersionUID = 1L;

    private JTable tablaProfesores;
    private DefaultTableModel modeloTabla;
    private JButton btnCambiarDirector, btnVolver;
    private JLabel lblNombreEscuela, lblDirectorActual;
    private Escuela escuelaSeleccionada;
    private Universidad universidad;

    public ProfesoresDeEscuela(Escuela escuela, Universidad universidad) {
        this.escuelaSeleccionada = escuela;
        this.universidad = universidad;
        init();
        cargarDatos();
    }

    private void init() {
        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(650, 450));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel superior con información de la escuela
        JPanel panelSuperior = createPanelSuperior();

        // Panel central con la tabla de profesores
        JPanel panelCentral = createPanelCentral();

        // Panel inferior con botones
        JPanel panelInferior = createPanelInferior();

        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    private JPanel createPanelSuperior() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
                "Informacion de la Escuela",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("SansSerif", Font.PLAIN, 14),
                Color.DARK_GRAY
        ));

        lblNombreEscuela = new JLabel();
        lblNombreEscuela.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblNombreEscuela.setForeground(Color.WHITE);

        lblDirectorActual = new JLabel();
        lblDirectorActual.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblDirectorActual.setForeground(Color.WHITE);

        panel.add(lblNombreEscuela);
        panel.add(lblDirectorActual);

        return panel;
    }

    private JPanel createPanelCentral() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
                "Profesores y sus Cursos Asignados",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("SansSerif", Font.PLAIN, 14),
                Color.DARK_GRAY
        ));

        // Crear tabla
        String[] columnas = {"Cedula", "Nombre", "Apellidos", "Cursos Asignados", "Es Director"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer la tabla no editable
            }
        };

        tablaProfesores = new JTable(modeloTabla);
        tablaProfesores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaProfesores.setRowHeight(25);
        tablaProfesores.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 13));

        // Configurar ancho de columnas
        tablaProfesores.getColumnModel().getColumn(0).setPreferredWidth(100); // Cédula
        tablaProfesores.getColumnModel().getColumn(1).setPreferredWidth(120); // Nombre
        tablaProfesores.getColumnModel().getColumn(2).setPreferredWidth(120); // Apellidos
        tablaProfesores.getColumnModel().getColumn(3).setPreferredWidth(200); // Cursos
        tablaProfesores.getColumnModel().getColumn(4).setPreferredWidth(80);  // Es Director

        JScrollPane scrollPane = new JScrollPane(tablaProfesores);
        scrollPane.setPreferredSize(new Dimension(750, 390));

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createPanelInferior() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        btnCambiarDirector = new JButton("Cambiar Director");
        btnCambiarDirector.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btnCambiarDirector.setPreferredSize(new Dimension(250, 40));
        btnCambiarDirector.setFocusPainted(false);
        btnCambiarDirector.setBackground(new Color(70, 130, 180));
        btnCambiarDirector.setForeground(Color.WHITE);

        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btnVolver.setPreferredSize(new Dimension(250, 40));
        btnVolver.setFocusPainted(false);

        panel.add(btnCambiarDirector);
        panel.add(btnVolver);

        return panel;
    }

    private void cargarDatos() {
        // Actualizar información de la escuela
        lblNombreEscuela.setText("Escuela: " + escuelaSeleccionada.getNombre());

        // Verificar si hay director actual
        String directorInfo = "Director Actual: ";
        if (escuelaSeleccionada.getDirector() != null) {
            Profesor director = escuelaSeleccionada.getDirector();
            directorInfo += director.getNombre() + " " + director.getApellidos() +
                    " (Cédula: " + director.getCedula() + ")";
        } else {
            directorInfo += "No asignado";
        }
        lblDirectorActual.setText(directorInfo);

        // Limpiar tabla
        modeloTabla.setRowCount(0);

        // Cargar profesores
        ArrayList<Profesor> profesores = escuelaSeleccionada.getProfesores();

        if (profesores.isEmpty()) {
            Object[] fila = {"", "No hay profesores registrados", "", "", ""};
            modeloTabla.addRow(fila);
            btnCambiarDirector.setEnabled(false);
        } else {
            btnCambiarDirector.setEnabled(true);

            for (Profesor profesor : profesores) {
                Object[] fila = new Object[5];
                fila[0] = profesor.getCedula();
                fila[1] = profesor.getNombre();
                fila[2] = profesor.getApellidos();

                // Obtener cursos del profesor
                ArrayList<Curso> cursosProfesor = profesor.getCursosDelProfesor();
                if (cursosProfesor.isEmpty()) {
                    fila[3] = "Sin cursos asignados";
                } else {
                    StringBuilder cursos = new StringBuilder();
                    for (int i = 0; i < cursosProfesor.size(); i++) {
                        if (i > 0) cursos.append(", ");
                        cursos.append(cursosProfesor.get(i).getNombre())
                                .append(" (").append(cursosProfesor.get(i).getSigla()).append(")");
                    }
                    fila[3] = cursos.toString();
                }

                // Verificar si es director
                if (escuelaSeleccionada.getDirector() != null &&
                        escuelaSeleccionada.getDirector().getCedula().equals(profesor.getCedula())) {
                    fila[4] = "SÍ";
                } else {
                    fila[4] = "NO";
                }

                modeloTabla.addRow(fila);
            }
        }
    }

    public void actualizarDatos() {
        cargarDatos();
    }

    // Getters
    public JButton getBtnCambiarDirector() {
        return btnCambiarDirector;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JTable getTablaProfesores() {
        return tablaProfesores;
    }

    public Escuela getEscuelaSeleccionada() {
        return escuelaSeleccionada;
    }

    public Profesor getProfesorSeleccionado() {
        int filaSeleccionada = tablaProfesores.getSelectedRow();
        if (filaSeleccionada >= 0 && !escuelaSeleccionada.getProfesores().isEmpty()) {
            String cedula = (String) modeloTabla.getValueAt(filaSeleccionada, 0);

            // Buscar el profesor por cédula
            for (Profesor profesor : escuelaSeleccionada.getProfesores()) {
                if (profesor.getCedula().equals(cedula)) {
                    return profesor;
                }
            }
        }
        return null;
    }
}