package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import models.Escuela;
import models.Universidad;

public class CursoManagerView extends JPanel {
    private static final long serialVersionUID = 1L;
    
    private JButton btnIncluir, btnConsultarCurso, btnListarCursosEscuela;
    private JButton btnListarTodosCursos, btnModificarCurso, btnEliminarCurso;
    private JButton btnVolver;
    private Escuela escuelaActual;
    private Universidad universidad;
    
    public CursoManagerView(Escuela escuela, Universidad universidad) {
        this.escuelaActual = escuela;
        this.universidad = universidad;
        init();	
    }
    
    private void init() {
        //Configuracion basica de la ventana
        setLayout(new BorderLayout(15, 15));
        setSize(600, 350);

        // Panel principal con las opciones
        JPanel panelOpciones = new JPanel();
        panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.Y_AXIS));
        panelOpciones.setAlignmentX(Component.CENTER_ALIGNMENT); // Alinea el panel al centro
        panelOpciones.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1, true),
            "Opciones de Gestion de Cursos",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("SansSerif", Font.PLAIN, 14),
            Color.GRAY
        ));
        
        // Crear botones
        btnIncluir = createStyledButton("Agregar un Curso");
        btnIncluir.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnConsultarCurso = createStyledButton("Datos De Curso");
        btnConsultarCurso.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnListarCursosEscuela = createStyledButton("Lista de cursos de la escuela de " + escuelaActual.getNombre());
        btnListarCursosEscuela.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnListarTodosCursos = createStyledButton("Lista de cursos impartidos por la Universidad " + universidad.getNombreU());
        btnListarTodosCursos.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnModificarCurso = createStyledButton("Modificar los datos de un curso");
        btnModificarCurso.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEliminarCurso = createStyledButton("Eliminar un curso");
        btnEliminarCurso.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Añadir botones al panel
        panelOpciones.add(btnIncluir);
        panelOpciones.add(btnConsultarCurso);
        panelOpciones.add(btnListarCursosEscuela);
        panelOpciones.add(btnListarTodosCursos);
        panelOpciones.add(btnModificarCurso);
        panelOpciones.add(btnEliminarCurso);
        
        // Panel para el boton Volver
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));  // Alineación centrada
        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 12));
        panelBotones.add(btnVolver);
        
        // Añadir paneles a la ventana
        add(panelOpciones, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
    
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.PLAIN, 13));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setPreferredSize(new Dimension(350, 36));
        return button;
    }
    
    // Getters para los botones
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
