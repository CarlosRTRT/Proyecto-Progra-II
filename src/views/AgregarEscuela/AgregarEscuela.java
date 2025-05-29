package views.AgregarEscuela;

import java.awt.BorderLayout;
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
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class AgregarEscuela extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtNombreEscuela;
    private JButton btnAgregarEscuela;

    public AgregarEscuela() {
        init();
    }

    private void init() {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(650, 350));

        // Panel para gestionar escuelas
        JPanel panelEscuelas = new JPanel(new GridLayout(1, 2));
        panelEscuelas.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(50, 0, 0, 0), // gap de 50px en la parte superior
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
                        "Agregar Escuelas",
                        TitledBorder.CENTER,
                        TitledBorder.TOP,
                        new Font("SansSerif", Font.PLAIN, 14),
                        Color.GRAY
                )
        ));


        // Label para el nombre de la escuela
        Font labelFont = new Font("SansSerif", Font.PLAIN, 13);
        JLabel lblNombreEscuela = new JLabel("Nombre de Escuela:");
        lblNombreEscuela.setFont(labelFont);
        lblNombreEscuela.setHorizontalAlignment(SwingConstants.LEFT);
        lblNombreEscuela.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));

        txtNombreEscuela = new JTextField();
        txtNombreEscuela.setPreferredSize(new Dimension(300, 40));

        // Panel para envolver el campo de texto
        JPanel panelTextField = new JPanel(new FlowLayout());
        panelTextField.add(txtNombreEscuela);
        panelTextField.setBorder(BorderFactory.createEmptyBorder(85, 0, 0, 0));

        // Agregar componentes al panel de escuelas
        panelEscuelas.add(lblNombreEscuela);
        panelEscuelas.add(panelTextField);

        // Boton
        btnAgregarEscuela = new JButton("Agregar Escuela");
        btnAgregarEscuela.setPreferredSize(new Dimension(250, 40));
        btnAgregarEscuela.setBackground(Color.BLUE);
        btnAgregarEscuela.setForeground(Color.WHITE);
        btnAgregarEscuela.setFocusPainted(false);
        btnAgregarEscuela.setFont(new Font("SansSerif", Font.PLAIN, 13));

        // Panel para el boton
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.add(btnAgregarEscuela);

        // Agregar paneles al panel principal
        add(panelEscuelas, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);
    }

    public JTextField getTxtNombreEscuela() {
        return txtNombreEscuela;
    }

    public JButton getBtnAgregarEscuela() {
        return btnAgregarEscuela;
    }
}