package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.ArrayList;
import models.Escuela;
import models.Universidad;

public class SchoolsView extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private JComboBox<String> comboEscuelas;
    private JButton btnConsultar, btnGestionarCursos, btnVolver;
    private Universidad universidad;
    
    public SchoolsView(Universidad universidad) {
        this.universidad = universidad;
        init();
    }
    
    private void init() {
        // Configuracion de la ventana
        setTitle("Gestion de Escuelas - " + universidad.getNombreU());
        setLayout(new BorderLayout(15, 15));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        
        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1, true),
            "Seleccion de Escuela",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("SansSerif", Font.PLAIN, 14),
            Color.GRAY
        ));
        
        // Panel de seleccion
        JPanel panelSeleccion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JLabel lblEscuela = new JLabel("Escuela:");
        lblEscuela.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        // Llenar el combo box con las escuelas
        comboEscuelas = new JComboBox<>();
        actualizarListaEscuelas();
        
        panelSeleccion.add(lblEscuela);
        panelSeleccion.add(comboEscuelas);
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        
        btnGestionarCursos = new JButton("Gestionar Cursos");
        btnGestionarCursos.setBackground(Color.BLUE);
        btnGestionarCursos.setForeground(Color.WHITE);
        btnGestionarCursos.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        
        panelBotones.add(btnGestionarCursos);
        
        // Panel inferior con boton volver
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        btnVolver = new JButton("Volver");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        panelInferior.add(btnVolver);
        
        // Añadir paneles a la ventana
        panelPrincipal.add(panelSeleccion, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);
        
        add(panelPrincipal, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }
    
    public void actualizarListaEscuelas() {
        comboEscuelas.removeAllItems();
        for(Escuela escuela : universidad.getVector()) {
            comboEscuelas.addItem(escuela.getNombre());
        }
    }
    
    public Escuela getEscuelaSeleccionada() {
        int index = comboEscuelas.getSelectedIndex();
        if(index >= 0) {
            return universidad.getVector().get(index);
        }
        return null;
    }
    
    // Getters para los botones
    public JButton getBtnConsultar() {
        return btnConsultar;
    }
    
    public JButton getBtnGestionarCursos() {
        return btnGestionarCursos;
    }
    
    public JButton getBtnVolver() {
        return btnVolver;
    }
    
    public Universidad getUniversidad() {
        return universidad;
    }
}
