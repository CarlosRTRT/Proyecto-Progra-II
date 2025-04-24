package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import models.*;
import views.*;

public class Control {
    private PrincipalMenu pMenu;
    private UniversityMenuView view;
    private Universidad universidad;
    private Logic logic;
    private SchoolsView schoolsView;
    private CursoController cursoController;
    
    public Control(UniversityMenuView pView, PrincipalMenu pMenu) {
        this.view = pView;
        this.pMenu = pMenu;
        configurarListeners();
    }

    
    private void configurarListeners() {
        pMenu.getButtonAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearUniversidad(view);
            }
        });
    }
    
    private void crearUniversidad(UniversityMenuView view) {
    	
    	ActualizarU optionsView = new ActualizarU();
    	AgregarEscuela agregarEscuela = new AgregarEscuela();
        String nombre = pMenu.getNombreView();
        String direccion = pMenu.getDireccionView();
        String telefono = pMenu.getTelefonoView();
        
        if(nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(pMenu, "Por favor, complete todos los campos", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        universidad = new Universidad(nombre, direccion, telefono);
        logic = new Logic(universidad);
        
        JOptionPane.showMessageDialog(pMenu, "Universidad " + nombre + " creada exitosamente", 
            "Información", JOptionPane.INFORMATION_MESSAGE);  
        
        view.getBtnActualizarU().addActionListener(new ActionListener() {
        	@Override
        		public void actionPerformed(ActionEvent e) {
        	actualizarPUni(optionsView);        
            }	
            });
         view.getBtnAgregarE().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPEscuela(agregarEscuela);
            }
         });    	    
         view.getBtnConsultarE().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                schoolsView = new SchoolsView(universidad);
                ActualizarEsc(schoolsView);
            }
        });
    }
    private void actualizarPUni(ActualizarU optionsView) {
    	view.cambiarPanelCentral(optionsView);
    	actualizarDUni(optionsView);
    }
    private void actualizarDUni(ActualizarU optionsView) {
        optionsView.getBtnModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDatosUniversidad(optionsView);
            }
        });
    }
    private void actualizarPEscuela(AgregarEscuela agregarEscuela) {
    	view.cambiarPanelCentral(agregarEscuela);
    	agregarDEscuela(agregarEscuela);
    }
    private void agregarDEscuela(AgregarEscuela agregarEscuela) {
        agregarEscuela.getBtnAgregarEscuela().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEscuela(agregarEscuela);
            }
        });
    }
    private void ActualizarEsc(SchoolsView schoolsView) {
    	view.cambiarPanelCentral(schoolsView);
    	ConsultarEsc(schoolsView);
    }
    private void ConsultarEsc(SchoolsView schoolsView) {
        schoolsView.getBtnGestionarCursos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaEscuelas();
            }
        });
    }
    
    private void actualizarDatosUniversidad(ActualizarU optionsView) {
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
    
    private void agregarEscuela(AgregarEscuela agregarEscuela) {
        String nombreEscuela = agregarEscuela.getTxtNombreEscuela().getText();
        
        if(nombreEscuela.isEmpty()) {
            JOptionPane.showMessageDialog(agregarEscuela, "Por favor, ingrese el nombre de la escuela", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Escuela nuevaEscuela = new Escuela(nombreEscuela);
        logic.agregarEscuela(nuevaEscuela);
        
        JOptionPane.showMessageDialog(agregarEscuela, "Escuela " + nombreEscuela + " agregada exitosamente", 
            "Información", JOptionPane.INFORMATION_MESSAGE);
        
        agregarEscuela.getTxtNombreEscuela().setText("");
    }
    
    private void abrirVentanaEscuelas() {

        // Crear el controlador para la gestion de cursos
        cursoController = new CursoController(logic, schoolsView, view);
        schoolsView.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //schoolsView.dispose();
            }
        });
        
    }
    
    public void startGUI() {
        view.setVisible(true);
    }
}