package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import models.Universidad;

public class ListarTodosCursosView extends JPanel {
    private static final long serialVersionUID = 1L;
    
    private JTextArea txtListaCursos;
    private JButton btnActualizar, btnVolver;
    private Universidad universidad;
    
    public ListarTodosCursosView(Universidad universidad) {
        this.universidad = universidad;
        init();
    }
    
    private void init() {
        // Configuracion básica de la ventana
        setLayout(new BorderLayout(15, 15));
        setSize(600, 500);
        
        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1, true),
            "Todos los Cursos",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("SansSerif", Font.PLAIN, 14),
            Color.GRAY
        ));
        
        //Area de texto para mostrar los cursos
        txtListaCursos = new JTextArea();
        txtListaCursos.setEditable(false);
        txtListaCursos.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtListaCursos.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        JScrollPane scrollPane = new JScrollPane(txtListaCursos);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        btnVolver = new JButton("Volver");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        panelBotones.add(btnActualizar);
        panelBotones.add(btnVolver);
        
        // Añadir paneles a la ventana
        add(panelPrincipal, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
    
    // Getters y setters
    public void setListaCursos(String texto) {
        txtListaCursos.setText(texto);
    }
    
    public JButton getBtnActualizar() {
        return btnActualizar;
    }
    
    public JButton getBtnVolver() {
        return btnVolver;
    }
    
    public Universidad getUniversidad() {
        return universidad;
    }
}