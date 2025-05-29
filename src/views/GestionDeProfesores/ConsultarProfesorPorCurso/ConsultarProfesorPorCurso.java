package views.GestionDeProfesores.ConsultarProfesorPorCurso;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class ConsultarProfesorPorCurso extends JPanel {

    private static final long serialVersionUID = 1L;

    // Estados de la vista
    public enum Estado {
        SELECCIONAR_ESCUELA,
        SELECCIONAR_CURSO,
        MOSTRAR_PROFESORES
    }

    private Estado estadoActual;

    // Componentes principales
    private JList<String> lista;
    private DefaultListModel<String> modelo;
    private JButton btnSeleccionar;
    private JButton btnVolver;
    private JButton btnAtras;
    private JLabel lblTitulo;
    private JTextArea txtAreaResultado;
    private JScrollPane scrollPaneResultado;

    // Datos para navegación
    private String escuelaSeleccionada;
    private String cursoSeleccionado;
    private CardLayout cardLayout;
    public ConsultarProfesorPorCurso() {
        init();
        setEstado(Estado.SELECCIONAR_ESCUELA);
    }

    private void init() {
        setLayout(new BorderLayout(15, 15));
        setPreferredSize(new Dimension(650, 450));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel superior con título
        JPanel panelTitulo = new JPanel(new BorderLayout());
        lblTitulo = new JLabel("Seleccionar Escuela");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelTitulo.add(lblTitulo, BorderLayout.CENTER);

        // Panel central con CardLayout para alternar entre lista y resultados
        JPanel panelCentral = new JPanel(new CardLayout());
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Panel para la lista
        JPanel panelLista = new JPanel(new BorderLayout());
        modelo = new DefaultListModel<>();
        lista = new JList<>(modelo);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setFixedCellHeight(30);
        lista.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JScrollPane scrollPaneLista = new JScrollPane(lista);
        scrollPaneLista.setPreferredSize(new Dimension(550, 400));
        panelLista.add(scrollPaneLista, BorderLayout.CENTER);

        // Panel para los resultados
        JPanel panelResultados = new JPanel(new BorderLayout());
        txtAreaResultado = new JTextArea();
        txtAreaResultado.setFont(new Font("SansSerif", Font.PLAIN, 12));
        txtAreaResultado.setEditable(false);
        txtAreaResultado.setLineWrap(true);
        txtAreaResultado.setWrapStyleWord(true);

        scrollPaneResultado = new JScrollPane(txtAreaResultado);
        scrollPaneResultado.setPreferredSize(new Dimension(550, 400));
        panelResultados.add(scrollPaneResultado, BorderLayout.CENTER);

        // Agregar ambos paneles al CardLayout
        panelCentral.add(panelLista, "LISTA");
        panelCentral.add(panelResultados, "RESULTADOS");

        // Panel inferior con botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));

        btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnSeleccionar.setPreferredSize(new Dimension(250, 40));
        btnSeleccionar.setFocusPainted(false);

        btnAtras = new JButton("Atrás");
        btnAtras.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnAtras.setPreferredSize(new Dimension(250, 40));

        btnAtras.setFocusPainted(false);
        btnAtras.setVisible(false);

        btnVolver = new JButton("Volver");
        btnVolver.setPreferredSize(new Dimension(250, 40));

        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnVolver.setFocusPainted(false);

        panelBotones.add(btnSeleccionar);
        panelBotones.add(btnAtras);
        panelBotones.add(btnVolver);

        // Agregar componentes al panel principal
        add(panelTitulo, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // Guardar referencia al CardLayout para poder cambiar las vistas
        cardLayout = (CardLayout) panelCentral.getLayout();
    }

    // Método para cambiar el estado de la vista


// Y reemplaza el metodo setEstado() con este codigo:
    public void setEstado(Estado nuevoEstado) {
        this.estadoActual = nuevoEstado;

        switch (estadoActual) {
            case SELECCIONAR_ESCUELA:
                lblTitulo.setText("Seleccionar Escuela");
                btnSeleccionar.setText("Seleccionar Escuela");
                btnSeleccionar.setVisible(true);
                btnAtras.setVisible(false);
                // Mostrar la vista de lista
                cardLayout.show((Container) getComponent(1), "LISTA"); // getComponent(1) es panelCentral
                break;

            case SELECCIONAR_CURSO:
                lblTitulo.setText("Seleccionar Curso - " + escuelaSeleccionada);
                btnSeleccionar.setText("Seleccionar Curso");
                btnSeleccionar.setVisible(true);
                btnAtras.setVisible(true);
                // Mostrar la vista de lista
                cardLayout.show((Container) getComponent(1), "LISTA");
                break;

            case MOSTRAR_PROFESORES:
                lblTitulo.setText("Profesores del Curso - " + cursoSeleccionado);
                btnSeleccionar.setVisible(false);
                btnAtras.setVisible(true);
                // Mostrar la vista de resultados
                cardLayout.show((Container) getComponent(1), "RESULTADOS");
                break;
        }

        // Limpiar la lista al cambiar de estado
        modelo.clear();
        lista.clearSelection();
    }

    // Getters
    public JList<String> getLista() {
        return lista;
    }

    public DefaultListModel<String> getModelo() {
        return modelo;
    }

    public JButton getBtnSeleccionar() {
        return btnSeleccionar;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JButton getBtnAtras() {
        return btnAtras;
    }

    public JTextArea getTxtAreaResultado() {
        return txtAreaResultado;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    // Métodos para agregar elementos a la lista
    public void agregarElemento(String elemento) {
        modelo.addElement(elemento);
    }

    // Método para obtener el elemento seleccionado
    public String getElementoSeleccionado() {
        return lista.getSelectedValue();
    }

    // Métodos para manejar los datos de navegación
    public String getEscuelaSeleccionada() {
        return escuelaSeleccionada;
    }

    public void setEscuelaSeleccionada(String escuelaSeleccionada) {
        this.escuelaSeleccionada = escuelaSeleccionada;
    }

    public String getCursoSeleccionado() {
        return cursoSeleccionado;
    }

    public void setCursoSeleccionado(String cursoSeleccionado) {
        this.cursoSeleccionado = cursoSeleccionado;
    }

    // Método para mostrar texto en el área de resultados
    public void mostrarResultado(String texto) {
        txtAreaResultado.setText(texto);
    }

    // Método para limpiar la vista
    public void limpiar() {
        modelo.clear();
        txtAreaResultado.setText("");
        escuelaSeleccionada = null;
        cursoSeleccionado = null;
        lista.clearSelection();
    }
}