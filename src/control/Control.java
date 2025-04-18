package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import models.*;
import views.*;

public class Control {
    private PrincipalMenu view;
    private Universidad universidad;
    private Logic logic;
    private SchoolsView schoolsView;
    private CursoController cursoController;
    
    public Control(PrincipalMenu pView) {
        view = pView;
        configurarListeners();
    }
    
    private void configurarListeners() {
        view.getButtonAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearUniversidad();
            }
        });
    }
    
    private void crearUniversidad() {
        String nombre = view.getNombreView();
        String direccion = view.getDireccionView();
        String telefono = view.getTelefonoView();
        
        if(nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Por favor, complete todos los campos", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        universidad = new Universidad(nombre, direccion, telefono);
        logic = new Logic(universidad);
        
        JOptionPane.showMessageDialog(view, "Universidad " + nombre + " creada exitosamente", 
            "Información", JOptionPane.INFORMATION_MESSAGE);
        
        // Abrir ventana de opciones
        abrirVentanaOpciones();
    }
    
    private void abrirVentanaOpciones() {
        // Nueva implementacion que pasa la universidad como parámetro
        OptionsView optionsView = new OptionsView();
        
        // Configurar listeners para los botones
        optionsView.getBtnModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDatosUniversidad(optionsView);
            }
        });
        
        optionsView.getBtnAgregarEscuela().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEscuela(optionsView);
            }
        });
        
        optionsView.getBtnConsultarEscuelas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaEscuelas();
            }
        });
        
        optionsView.setVisible(true);
        view.setVisible(false);
    }
    
    private void actualizarDatosUniversidad(OptionsView optionsView) {
        String nuevaDireccion = optionsView.getTxtDireccion().getText();
        String nuevoTelefono = optionsView.getTxtTelefono().getText();
        
        if(!nuevaDireccion.isEmpty()) {
            logic.actualizarDireccion(nuevaDireccion);
        }
        
        if(!nuevoTelefono.isEmpty()) {
            logic.actualizarTelefono(nuevoTelefono);
        }
        
        JOptionPane.showMessageDialog(optionsView, "Datos de la universidad actualizados", 
            "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void agregarEscuela(OptionsView optionsView) {
        String nombreEscuela = optionsView.getTxtNombreEscuela().getText();
        
        if(nombreEscuela.isEmpty()) {
            JOptionPane.showMessageDialog(optionsView, "Por favor, ingrese el nombre de la escuela", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Escuela nuevaEscuela = new Escuela(nombreEscuela);
        logic.agregarEscuela(nuevaEscuela);
        
        JOptionPane.showMessageDialog(optionsView, "Escuela " + nombreEscuela + " agregada exitosamente", 
            "Información", JOptionPane.INFORMATION_MESSAGE);
        
        optionsView.getTxtNombreEscuela().setText("");
    }
    
    private void abrirVentanaEscuelas() {
        schoolsView = new SchoolsView(universidad);
        
        // Crear el controlador para la gestion de cursos
        cursoController = new CursoController(logic, schoolsView);
        
        schoolsView.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                schoolsView.dispose();
            }
        });
        
        schoolsView.setVisible(true);
    }
    
    public void startGUI() {
        view.setVisible(true);
    }
}