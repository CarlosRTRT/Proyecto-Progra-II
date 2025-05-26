package views.ModificarUniversidad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ModificarUniversidad extends JPanel {

    private static final long serialVersionUID = 1L;

    // Componentes para modificar universidad
    private JTextField txtDireccion, txtTelefono;
    private JButton btnModificar;


    public ModificarUniversidad() {
        init();
    }

    private void init() {
        setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(600, 350));

        PModificar(mainPanel);
        add(mainPanel);
    }

    public void PModificar(JPanel mainPanel) {
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Panel para modificar datos de universidad
        JPanel panelModificar = new JPanel();
        panelModificar.setLayout(null); // Layout absoluto para control total
        panelModificar.setPreferredSize(new Dimension(550, 250));
        panelModificar.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
                "Modificar Universidad",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("SansSerif", Font.PLAIN, 14),
                Color.GRAY
        ));

        // Labels y campos posicionados manualmente
        JLabel lblDireccion = new JLabel("Nueva Direccion:");
        lblDireccion.setBounds(30, 40, 120, 25);
        panelModificar.add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(160, 40, 350, 40);
        panelModificar.add(txtDireccion);

        JLabel lblTelefono = new JLabel("Nuevo Telefono:");
        lblTelefono.setBounds(30, 90, 120, 25);
        panelModificar.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(160, 90, 350, 40);
        panelModificar.add(txtTelefono);

        // Botón centrado
        btnModificar = new JButton("Actualizar Datos");
        btnModificar.setBounds(200, 150, 150, 40);
		btnModificar.setBackground(Color.BLUE);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFocusPainted(false);
		btnModificar.setFont(new Font("SansSerif", Font.PLAIN, 13));
        panelModificar.add(btnModificar);

        mainPanel.add(panelModificar);
    }

    // Getters para los componentes
    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }
    public void setBlanks() {
    	txtDireccion.setText("");
    	txtTelefono.setText("");
    }
}