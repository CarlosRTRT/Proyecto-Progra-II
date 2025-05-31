package views.Estudiantes;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class AdministrarEstudiantes extends JPanel {
private static final long serialVersionUID = 1L;
    
    private JButton btnAgregarEstudiante;
    private JButton btnAdministrarEstudiante;
    private JButton btnMostrarAranceles;
    private JButton btnConsultarEstudiantesPorCurso;
    
    public AdministrarEstudiantes() {
        init();
    }
    
    void init(){ 
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(650, 350));

        // Panel principal con los botones
        JPanel panelOpciones = new JPanel(new GridLayout(4, 1, 20, 20));
        panelOpciones.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
                "Administración de Estudiantes",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("SansSerif", Font.PLAIN, 14),
                Color.GRAY
        ));

        // Crear botones
        btnAgregarEstudiante = crearBoton("Agregar Estudiante");
        btnAdministrarEstudiante = crearBoton("Administrar Estudiante");
        btnMostrarAranceles = crearBoton("Mostrar Aranceles");
        btnConsultarEstudiantesPorCurso = crearBoton("Consultar Estudiantes por Curso");

        // Añadir botones al panel
        panelOpciones.add(btnAgregarEstudiante);
        panelOpciones.add(btnAdministrarEstudiante);
        panelOpciones.add(btnMostrarAranceles);
        panelOpciones.add(btnConsultarEstudiantesPorCurso);

        // Panel contenedor para centrar las opciones
        JPanel panelContenedor = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelContenedor.add(panelOpciones);

        add(panelContenedor, BorderLayout.CENTER);
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setPreferredSize(new Dimension(450, 40));
        boton.setFocusPainted(false);
        boton.setFont(new Font("SansSerif", Font.PLAIN, 13));
        return boton;
    }

    // Getters para los botones
    public JButton getBtnAgregarEstudiante() {
        return btnAgregarEstudiante;
    }

    public JButton getBtnAdministrarEstudiante() {
        return btnAdministrarEstudiante;
    }

    public JButton getBtnMostrarAranceles() {
        return btnMostrarAranceles;
    }

    public JButton getBtnConsultarEstudiantesPorCurso() {
        return btnConsultarEstudiantesPorCurso;
    }
	 
}
