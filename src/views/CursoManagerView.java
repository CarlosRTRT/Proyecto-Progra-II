package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import models.Escuela;
import models.Universidad;

public class CursoManagerView extends JFrame {
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
        // Configuracion basica de la ventana
        setTitle("Gestion de Cursos - " + escuelaActual.getNombre());
        setLayout(new BorderLayout(15, 15));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        
        // Panel principal con las opciones
        JPanel panelOpciones = new JPanel(new GridLayout(6, 1, 10, 10));
        panelOpciones.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1, true),
            "Opciones de Gestion de Cursos",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("SansSerif", Font.PLAIN, 14),
            Color.GRAY 	
        ));
        
        // Crear botones con estilo similar al resto de la aplicacion
        btnIncluir = createStyledButton("Agregar un Curso");
        btnConsultarCurso = createStyledButton("Datos De Curso");
        btnListarCursosEscuela = createStyledButton("Lista de cursos de la escuela de " + escuelaActual.getNombre());
        btnListarTodosCursos = createStyledButton("Lista de cursos impartidos por la Universidad " + universidad.getNombreU());
        btnModificarCurso = createStyledButton("Modificar los datos de un curso");
        btnEliminarCurso = createStyledButton("Eliminar un curso");
        
        // Añadir botones al panel
        panelOpciones.add(btnIncluir);
        panelOpciones.add(btnConsultarCurso);
        panelOpciones.add(btnListarCursosEscuela);
        panelOpciones.add(btnListarTodosCursos);
        panelOpciones.add(btnModificarCurso);
        panelOpciones.add(btnEliminarCurso);
        
        // Panel para el boton Volver
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnVolver = new JButton("Volver");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 12));
        panelBotones.add(btnVolver);
        
        // Añadir paneles a la ventana
        add(panelOpciones, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
    
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.PLAIN, 13));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));
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