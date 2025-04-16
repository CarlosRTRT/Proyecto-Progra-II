package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SchoolsView extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    // Componentes para agregar escuelas
    private JTextField txtNombreEscuela;
    private JButton btnAgregarEscuela;
    private JButton btnVolver;
    
    // Componentes para mostrar escuelas
    private JTextArea areaEscuelas;
    private JTable tablaEscuelas;
    private DefaultTableModel modeloTabla;
    
    // Componentes para gestionar cursos (para futura expansión)
    private JButton btnGestionarCursos;
    
    public SchoolsView() {
        init();
    }
    
    private void init() {
        // Configuración de la ventana
        setTitle("Gestión de Escuelas");
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        // Panel superior para agregar escuelas
        JPanel panelAgregar = new JPanel(new GridLayout(2, 2, 10, 10));
        panelAgregar.setBorder(BorderFactory.createTitledBorder("Información de la Escuela"));
        
        panelAgregar.add(new JLabel("Nombre de la Escuela:"));
        txtNombreEscuela = new JTextField();
        panelAgregar.add(txtNombreEscuela);
        
        btnAgregarEscuela = new JButton("Agregar Escuela");
        panelAgregar.add(btnAgregarEscuela);
        
        btnGestionarCursos = new JButton("Gestionar Cursos");
        panelAgregar.add(btnGestionarCursos);
        
        // Panel central con dos áreas: TextArea y Tabla
        JPanel panelCentral = new JPanel(new GridLayout(1, 2, 10, 10));
        
        // Área de texto para mostrar escuelas
        areaEscuelas = new JTextArea();
        areaEscuelas.setEditable(false);
        JScrollPane scrollArea = new JScrollPane(areaEscuelas);
        scrollArea.setBorder(BorderFactory.createTitledBorder("Lista de Escuelas"));
        panelCentral.add(scrollArea);
        
        // Tabla para mostrar escuelas (alternativa visual)
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre de Escuela");
        modeloTabla.addColumn("Cantidad de Cursos");
        
        tablaEscuelas = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaEscuelas);
        scrollTabla.setBorder(BorderFactory.createTitledBorder("Detalle de Escuelas"));
        panelCentral.add(scrollTabla);
        
        // Panel inferior con botón para volver
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnVolver = new JButton("Volver al Menú Principal");
        panelInferior.add(btnVolver);
        
        // Agregar paneles a la ventana
        add(panelAgregar, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }
    
    // Getters para los componentes
    public JTextField getTxtNombreEscuela() {
        return txtNombreEscuela;
    }
    
    public JButton getBtnAgregarEscuela() {
        return btnAgregarEscuela;
    }
    
    public JButton getBtnVolver() {
        return btnVolver;
    }
    
    public JButton getBtnGestionarCursos() {
        return btnGestionarCursos;
    }
    
    public JTextArea getAreaEscuelas() {
        return areaEscuelas;
    }
    
    // Metodo para actualizar la tabla de escuelas
    public void actualizarTablaEscuelas(String[] nombres, int[] cantidadCursos) {
        // Limpiar la tabla
        modeloTabla.setRowCount(0);
        
        // Agregar filas con los datos
        for (int i = 0; i < nombres.length; i++) {
            modeloTabla.addRow(new Object[] {nombres[i], cantidadCursos[i]});
        }
    }
}
