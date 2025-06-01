package views.Estudiantes;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import models.Universidad;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AgregarEstudiante extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtCedula;
    private JTextField txtCarnet;
    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JComboBox<String> comboNacionalidad;
    private JTextField txtPorcentajeBeca;
    private JLabel lblPorcentajeBeca;
    private JPanel panelPorcentajeBeca;
    private JButton btnGuardar;
    private JButton btnVolver;
    private Universidad universidad;

    public AgregarEstudiante(Universidad universidad) {
        this.universidad = universidad;
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(650, 420));

        // Panel para datos del estudiante
        JPanel panelDatos = new JPanel(new GridLayout(6, 2, 10, 15));
        panelDatos.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
                "Datos del Estudiante",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("SansSerif", Font.PLAIN, 14),
                Color.GRAY
        ));

        // Etiquetas con padding izquierdo
        Font labelFont = new Font("SansSerif", Font.PLAIN, 13);

        JLabel lblCedula = new JLabel("Número de Cédula:");
        lblCedula.setFont(labelFont);
        lblCedula.setHorizontalAlignment(SwingConstants.LEFT);
        lblCedula.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));

        JLabel lblCarnet = new JLabel("Número de Carnet:");
        lblCarnet.setFont(labelFont);
        lblCarnet.setHorizontalAlignment(SwingConstants.LEFT);
        lblCarnet.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(labelFont);
        lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
        lblNombre.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setFont(labelFont);
        lblApellidos.setHorizontalAlignment(SwingConstants.LEFT);
        lblApellidos.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));

        JLabel lblNacionalidad = new JLabel("Nacionalidad:");
        lblNacionalidad.setFont(labelFont);
        lblNacionalidad.setHorizontalAlignment(SwingConstants.LEFT);
        lblNacionalidad.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));

        lblPorcentajeBeca = new JLabel("Porcentaje de Beca (%):");
        lblPorcentajeBeca.setFont(labelFont);
        lblPorcentajeBeca.setHorizontalAlignment(SwingConstants.LEFT);
        lblPorcentajeBeca.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));

        // Campos de texto
        txtCedula = new JTextField();
        txtCarnet = new JTextField();
        txtNombre = new JTextField();
        txtApellidos = new JTextField();
        txtPorcentajeBeca = new JTextField();

        // ComboBox para nacionalidad
        String[] nacionalidades = {"Nacional", "Extranjero"};
        comboNacionalidad = new JComboBox<>(nacionalidades);
        comboNacionalidad.setPreferredSize(new Dimension(300, 40));
        comboNacionalidad.setFont(new Font("SansSerif", Font.PLAIN, 13));

        // Configurar tamaño de los campos
        txtCedula.setPreferredSize(new Dimension(300, 40));
        txtCarnet.setPreferredSize(new Dimension(300, 40));
        txtNombre.setPreferredSize(new Dimension(300, 40));
        txtApellidos.setPreferredSize(new Dimension(300, 40));
        txtPorcentajeBeca.setPreferredSize(new Dimension(300, 40));

        // Panels para envolver cada campo
        JPanel panelCedula = new JPanel(new FlowLayout());
        panelCedula.add(txtCedula);

        JPanel panelCarnet = new JPanel(new FlowLayout());
        panelCarnet.add(txtCarnet);

        JPanel panelNombre = new JPanel(new FlowLayout());
        panelNombre.add(txtNombre);

        JPanel panelApellidos = new JPanel(new FlowLayout());
        panelApellidos.add(txtApellidos);

        JPanel panelNacionalidad = new JPanel(new FlowLayout());
        panelNacionalidad.add(comboNacionalidad);

        panelPorcentajeBeca = new JPanel(new FlowLayout());
        panelPorcentajeBeca.add(txtPorcentajeBeca);

        // Agregar componentes al panel de datos
        panelDatos.add(lblCedula);
        panelDatos.add(panelCedula);
        panelDatos.add(lblCarnet);
        panelDatos.add(panelCarnet);
        panelDatos.add(lblNombre);
        panelDatos.add(panelNombre);
        panelDatos.add(lblApellidos);
        panelDatos.add(panelApellidos);
        panelDatos.add(lblNacionalidad);
        panelDatos.add(panelNacionalidad);
        panelDatos.add(lblPorcentajeBeca);
        panelDatos.add(panelPorcentajeBeca);

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
        this.add(panelDatos, BorderLayout.CENTER);
        this.add(panelBotones, BorderLayout.SOUTH);

        // Configurar eventos
        configurarEventos();
    }

    private void configurarEventos() {
        // Listener para el combo de nacionalidad
        comboNacionalidad.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String nacionalidad = (String) e.getItem();
                    boolean esNacional = "Nacional".equals(nacionalidad);
                    
                    // Habilitar/deshabilitar el campo de porcentaje de beca
                    txtPorcentajeBeca.setEnabled(esNacional);
                    lblPorcentajeBeca.setEnabled(esNacional);
                    
                    if (!esNacional) {
                        txtPorcentajeBeca.setText("");
                        txtPorcentajeBeca.setBackground(Color.DARK_GRAY);
                    } else {
                        txtPorcentajeBeca.setBackground(Color.DARK_GRAY);
                    }
                }
            }
        });

        // Configuración inicial
        String nacionalidadInicial = (String) comboNacionalidad.getSelectedItem();
        boolean esNacional = "Nacional".equals(nacionalidadInicial);
        txtPorcentajeBeca.setEnabled(esNacional);
        lblPorcentajeBeca.setEnabled(esNacional);
        if (!esNacional) {
            txtPorcentajeBeca.setBackground(Color.LIGHT_GRAY);
        }
    }

    // Getters
    public String getCedula() {
        return txtCedula.getText().trim();
    }

    public String getCarnet() {
        return txtCarnet.getText().trim();
    }

    public String getNombre() {
        return txtNombre.getText().trim();
    }

    public String getApellidos() {
        return txtApellidos.getText().trim();
    }

    public String getNacionalidad() {
        return (String) comboNacionalidad.getSelectedItem();
    }

    public String getPorcentajeBeca() {
        if (txtPorcentajeBeca.isEnabled()) {
            return txtPorcentajeBeca.getText().trim();
        }
        return "0"; // Si es extranjero, devolver 0
    }

    public boolean esNacional() {
        return "Nacional".equals(getNacionalidad());
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
        txtCarnet.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtPorcentajeBeca.setText("");
        comboNacionalidad.setSelectedIndex(0);
        
        // Reconfigurar el estado del campo de beca
        configurarEventos();
    }

    // Método para validar campos
    public boolean validarCampos() {
        if (getCedula().isEmpty()) {
            return false;
        }

        if (getCarnet().isEmpty()) {
            return false;
        }

        if (getNombre().isEmpty()) {
            return false;
        }

        if (getApellidos().isEmpty()) {
            return false;
        }

        // Validar porcentaje de beca si es nacional
        if (esNacional() && !getPorcentajeBeca().isEmpty()) {
            try {
                double porcentaje = Double.parseDouble(getPorcentajeBeca());
                if (porcentaje < 0 || porcentaje > 100) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    public Universidad getUniversidad() {
        return universidad;
    }
}
