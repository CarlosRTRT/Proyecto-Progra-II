package views.Estudiantes;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ModificarEstudiante extends JPanel {
    private JButton guardar;
    private JButton volver;
    private JLabel labelNombre;
    private JLabel labelApellidos;
    private JLabel labelNacionalidad;
    private JTextField inputNombre;
    private JTextField inputApellidos;
    private JComboBox<String> inputNacionalidad;

    public ModificarEstudiante(){
        init();
    }
    private void init(){
        setLayout(new BorderLayout(10, 15));
        setPreferredSize(new Dimension(600, 350));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel para los datos del estudiante
        JPanel panelDatos = new JPanel(new GridLayout(3, 2, 10, 15));
        panelDatos.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Modificar Estudiante",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("SansSerif", Font.BOLD, 14)
        ));

        labelNombre = new JLabel("Nombre:");
        inputNombre = new JTextField();

        labelApellidos = new JLabel("Apellidos:");
        inputApellidos = new JTextField();

        labelNacionalidad = new JLabel("Nacionalidad:");
        String[] opciones = {"Nacional", "Extranjero"};
        inputNacionalidad = new JComboBox<>(opciones);
        inputNacionalidad.setPreferredSize(new Dimension(300, 40));
        inputNacionalidad.setFont(new Font("SansSerif", Font.PLAIN, 13));

        panelDatos.add(labelNombre);
        panelDatos.add(inputNombre);

        panelDatos.add(labelApellidos);
        panelDatos.add(inputApellidos);

        panelDatos.add(labelNacionalidad);
        panelDatos.add(inputNacionalidad);


        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        panelBotones.setPreferredSize(new Dimension(600, 50));

        guardar = new JButton("Guardar");
        guardar.setPreferredSize(new Dimension(150, 40));
        guardar.setFont(new Font("SansSerif", Font.PLAIN, 12));

        volver = new JButton("Volver");
        volver.setPreferredSize(new Dimension(150, 40));
        volver.setFont(new Font("SansSerif", Font.PLAIN, 12));

        panelBotones.add(guardar);
        panelBotones.add(volver);

        // Agregar componentes al panel principal
        add(panelDatos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    // Getters
    public JButton getBtnGuardar() {
        return guardar;
    }
    public JButton getBtnVolver() {
        return volver;
    }
    public String getNombre() {
        return inputNombre.getText().trim();
    }
    public String getApellidos() {
        return inputApellidos.getText().trim();
    }
    public String getInputNacionalidad(){
       return (String) inputNacionalidad.getSelectedItem();
    }
}
