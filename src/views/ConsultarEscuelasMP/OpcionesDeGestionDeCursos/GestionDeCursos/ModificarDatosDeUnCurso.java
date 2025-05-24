package views.ConsultarEscuelasMP.OpcionesDeGestionDeCursos.GestionDeCursos;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import models.Escuela;

public class ModificarDatosDeUnCurso extends JPanel {
    private static final long serialVersionUID = 1L;

    private JTextField txtNombreCursoBuscar, txtNuevoNombre;
    private JButton btnBuscar, btnGuardar, btnCancelar;
    private Escuela escuelaActual;

    public ModificarDatosDeUnCurso(Escuela escuela) {
        this.escuelaActual = escuela;
        init();
    }

    private void init() {
        // Configuracion basica de la ventana - tamaño más grande
        setLayout(new BorderLayout(20, 20));
        setPreferredSize(new Dimension(650, 400));

        // Panel de busqueda
        JPanel panelBusqueda = new JPanel(new GridLayout(1, 3, 5, 0));
        panelBusqueda.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 50, 10, 50),
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.GRAY, 1, true),
                        "Buscar Curso",
                        TitledBorder.CENTER,
                        TitledBorder.TOP,
                        new Font("SansSerif", Font.PLAIN, 14),
                        Color.GRAY
                )
        ));

        JLabel lblNombreBuscar = new JLabel("Nombre del Curso:");
        lblNombreBuscar.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblNombreBuscar.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        txtNombreCursoBuscar = new JTextField();
        txtNombreCursoBuscar.setPreferredSize(new Dimension(150, 40));
        txtNombreCursoBuscar.setFont(new Font("SansSerif", Font.PLAIN, 12));

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(Color.BLUE);
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnBuscar.setPreferredSize(new Dimension(100, 40));


        // Crear paneles para envolver cada componente de búsqueda
        JPanel panelLabelBuscar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelLabelBuscar.add(lblNombreBuscar);
        panelLabelBuscar.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        JPanel panelTextoBuscar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelTextoBuscar.add(txtNombreCursoBuscar);
        panelTextoBuscar.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        JPanel panelBotonBuscar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotonBuscar.add(btnBuscar);
        panelBotonBuscar.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        panelBusqueda.add(panelLabelBuscar);
        panelBusqueda.add(panelTextoBuscar);
        panelBusqueda.add(panelBotonBuscar);

        // Panel de modificacion
        JPanel panelModificacion = new JPanel(new BorderLayout(15, 15));
        panelModificacion.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 50, 30, 50),
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.GRAY, 1),
                        "Modificar Curso",
                        TitledBorder.CENTER,
                        TitledBorder.TOP,
                        new Font("SansSerif", Font.PLAIN, 14),
                        Color.GRAY
                )
        ));

        JPanel panelCampos = new JPanel(new GridLayout(1, 2, 20, 0));

        JLabel lblNuevoNombre = new JLabel("Nuevo Nombre:");
        lblNuevoNombre.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblNuevoNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lblNuevoNombre.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        txtNuevoNombre = new JTextField();
        txtNuevoNombre.setPreferredSize(new Dimension(250, 40));
        txtNuevoNombre.setFont(new Font("SansSerif", Font.PLAIN, 12));

        // Crear paneles para envolver los componentes de modificación
        JPanel panelLabelNuevo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelLabelNuevo.add(lblNuevoNombre);
        panelLabelNuevo.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        JPanel panelTextoNuevo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelTextoNuevo.add(txtNuevoNombre);
        panelTextoNuevo.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        panelCampos.add(panelLabelNuevo);
        panelCampos.add(panelTextoNuevo);

        JPanel panelBotonesAccion = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(Color.GREEN.darker());
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnGuardar.setPreferredSize(new Dimension(120, 40));
        btnGuardar.setFocusPainted(false);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(Color.RED.darker());
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnCancelar.setPreferredSize(new Dimension(120, 40));
        btnCancelar.setFocusPainted(false);

        panelBotonesAccion.add(btnGuardar);
        panelBotonesAccion.add(btnCancelar);

        panelModificacion.add(panelCampos, BorderLayout.NORTH);
        panelModificacion.add(panelBotonesAccion, BorderLayout.CENTER);

        // Añadir paneles a la ventana
        add(panelBusqueda, BorderLayout.NORTH);
        add(panelModificacion, BorderLayout.CENTER);
    }

    // Getters
    public String getNombreCursoBuscar() {
        return txtNombreCursoBuscar.getText();
    }

    public String getNuevoNombre() {
        return txtNuevoNombre.getText();
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public Escuela getEscuelaActual() {
        return escuelaActual;
    }
}