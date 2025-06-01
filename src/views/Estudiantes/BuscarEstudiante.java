package views.Estudiantes;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BuscarEstudiante extends JPanel {
	private static final long serialVersionUID = 1L;

    private JTextField txtCedula;
    private JTextField txtCarnet;
    private JButton btnBuscar;
    private JButton btnVolver;

    public BuscarEstudiante() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(700, 210));

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout(10, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));

        // Panel para búsquedas
        JPanel panelBusquedas = new JPanel(new GridLayout(2, 1, 0, 5));
        panelBusquedas.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(20, 0, 0, 0),
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
                "Buscar Estudiante",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("SansSerif", Font.PLAIN, 14),
                Color.GRAY
            )
        ));

        // Panel para búsqueda por cédula
        JPanel panelCedula = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));

        JLabel lblCedula = new JLabel("Buscar por Cédula:");
        lblCedula.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        txtCedula = new JTextField();
        txtCedula.setPreferredSize(new Dimension(200, 25));
        txtCedula.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));

        panelCedula.add(lblCedula);
        panelCedula.add(txtCedula);

        // Panel para búsqueda por carnet
        JPanel panelCarnet = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
        
        JLabel lblCarnet = new JLabel("Buscar por Carnet:");
        lblCarnet.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        txtCarnet = new JTextField();
        txtCarnet.setPreferredSize(new Dimension(200, 25));
        txtCarnet.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));

        panelCarnet.add(lblCarnet);
        panelCarnet.add(txtCarnet);

        // Agregar paneles de búsqueda
        panelBusquedas.add(panelCedula);
        panelBusquedas.add(panelCarnet);

        // Panel para botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setFocusPainted(false);
        btnBuscar.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnBuscar.setPreferredSize(new Dimension(180, 35));
        
        btnVolver = new JButton("Volver");
        btnVolver.setFocusPainted(false);
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnVolver.setPreferredSize(new Dimension(180, 35));
        
        panelBotones.add(btnBuscar);
        panelBotones.add(btnVolver);

        // Agregar paneles al panel principal
        mainPanel.add(panelBusquedas, BorderLayout.CENTER);
        mainPanel.add(panelBotones, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
    }

    // Getters
    public String getCedula() {
        return txtCedula.getText();
    }

    public String getCarnet() {
        return txtCarnet.getText();
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    // Limpiar campos
    public void limpiarCampos() {
        txtCedula.setText("");
        txtCarnet.setText("");
    }

    // Limpiar campo específico
    public void limpiarCedula() {
        txtCedula.setText("");
    }

    public void limpiarCarnet() {
        txtCarnet.setText("");
    }
}
