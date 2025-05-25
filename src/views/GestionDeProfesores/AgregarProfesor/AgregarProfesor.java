package views.GestionDeProfesores.AgregarProfesor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import models.Escuela;
import models.Universidad;
import models.Curso;

public class AgregarProfesor extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JComboBox<String> comboCursos;
    private JButton btnGuardar;
    private JButton btnVolver;
    private Universidad universidad;

    public AgregarProfesor(Universidad universidad) {
        this.universidad = universidad;
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(650, 350));

        // Panel para datos del profesor
        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 10, 15));
        panelDatos.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
                "Datos del Profesor",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("SansSerif", Font.PLAIN, 14),
                Color.GRAY
        ));

        // Etiquetas con padding izquierdo
        Font labelFont = new Font("SansSerif", Font.PLAIN, 13);

        JLabel lblCedula = new JLabel("Cedula:");
        lblCedula.setFont(labelFont);
        lblCedula.setHorizontalAlignment(SwingConstants.LEFT);
        lblCedula.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(labelFont);
        lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
        lblNombre.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(labelFont);
        lblApellido.setHorizontalAlignment(SwingConstants.LEFT);
        lblApellido.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setFont(labelFont);
        lblCurso.setHorizontalAlignment(SwingConstants.LEFT);
        lblCurso.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));

        // Campos de texto
        txtCedula = new JTextField();
        txtNombre = new JTextField();
        txtApellido = new JTextField();

        // ComboBox para cursos
        comboCursos = new JComboBox<>();
        comboCursos.setPreferredSize(new Dimension(300, 40));
        comboCursos.setFont(new Font("SansSerif", Font.PLAIN, 13));
        actualizarListaCursos();

        // Configurar tamaño de los campos
        txtCedula.setPreferredSize(new Dimension(300, 40));
        txtNombre.setPreferredSize(new Dimension(300, 40));
        txtApellido.setPreferredSize(new Dimension(300, 40));

        // Panels para envolver cada campo
        JPanel panelCedula = new JPanel(new FlowLayout());
        panelCedula.add(txtCedula);

        JPanel panelNombre = new JPanel(new FlowLayout());
        panelNombre.add(txtNombre);

        JPanel panelApellido = new JPanel(new FlowLayout());
        panelApellido.add(txtApellido);

        JPanel panelCurso = new JPanel(new FlowLayout());
        panelCurso.add(comboCursos);

        // Agregar componentes al panel de datos
        panelDatos.add(lblCedula);
        panelDatos.add(panelCedula);
        panelDatos.add(lblNombre);
        panelDatos.add(panelNombre);
        panelDatos.add(lblApellido);
        panelDatos.add(panelApellido);
        panelDatos.add(lblCurso);
        panelDatos.add(panelCurso);

        // Panel para botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(Color.BLUE);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnGuardar.setPreferredSize(new Dimension(250, 40));

        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnVolver.setFocusPainted(false);
        btnVolver.setPreferredSize(new Dimension(250, 40));

        panelBotones.add(btnGuardar);
        panelBotones.add(btnVolver);

        // Agregar paneles al panel principal
        add(panelDatos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    // Getters
    public String getCedula() {
        return txtCedula.getText();
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getApellido() {
        return txtApellido.getText();
    }

    public String getCursoSeleccionado() {
        return (String) comboCursos.getSelectedItem();
    }

    public Curso getCursoObjetoSeleccionado() {
        int index = comboCursos.getSelectedIndex();
        if(index >= 0) {
            // Necesitamos buscar el curso en todas las escuelas
            int contador = 0;
            for(Escuela escuela : universidad.getVector()) {
                for(Curso curso : escuela.getCursos()) {
                    if(contador == index) {
                        return curso;
                    }
                    contador++;
                }
            }
        }
        return null;
    }

    public JComboBox<String> getComboCursos() {
        return comboCursos;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    // Método para limpiar campos
    public void limpiarCampos() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        if(comboCursos.getItemCount() > 0) {
            comboCursos.setSelectedIndex(0);
        }
    }

    public void actualizarListaCursos() {
        comboCursos.removeAllItems();
        for(Escuela escuela : universidad.getVector()) {
            for(Curso curso : escuela.getCursos()) {
                // Puedes mostrar solo el nombre del curso o incluir la escuela
                comboCursos.addItem(curso.getNombre()); // Asumiendo que Curso tiene método getNombre()
                // O si quieres mostrar escuela + curso:
                // comboCursos.addItem(escuela.getNombre() + " - " + curso.getNombre());
            }
        }
    }

    public Universidad getUniversidad() {
        return universidad;
    }
}