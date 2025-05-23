package views.GestionDeProfesores.AdministrarProfesor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConsultarProfesor extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtCedula;
    private JButton btnBuscar;
    private JButton btnVolver;

    public ConsultarProfesor() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 180));

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout(10, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 0, 40));

        // Panel para la cedula
        JPanel panelCedula = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel lblCedula = new JLabel("Digite su cedula");
        lblCedula.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblCedula.setHorizontalAlignment(SwingConstants.CENTER);

        txtCedula = new JTextField();
        txtCedula.setPreferredSize(new Dimension(200, 25));
        txtCedula.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));



        panelCedula.add(lblCedula, BorderLayout.NORTH);
        panelCedula.add(txtCedula, BorderLayout.CENTER);

        // Panel para botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        btnBuscar = new JButton("Buscar");
        btnBuscar.setFocusPainted(false);
        btnBuscar.setFont(new Font("SansSerif", Font.PLAIN, 13));

        btnVolver = new JButton("Volver");
        btnVolver.setFocusPainted(false);
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 13));

        panelBotones.add(btnBuscar);
        panelBotones.add(btnVolver);

        // Agregar paneles al panel principal
        mainPanel.add(panelCedula, BorderLayout.CENTER);
        mainPanel.add(panelBotones, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
    }

    // Getters
    public String getCedula() {
        return txtCedula.getText();
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
    }
}