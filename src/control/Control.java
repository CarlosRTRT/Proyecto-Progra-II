package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import models.*;
import views.*;

public class Control {
    private MenuPrincipal pMenu;
    private AgregarUniversidad view;
    private Universidad universidad;
    private Logic logic;
    private SeleccionDeEscuela schoolsView;
    private CursoController cursoController;
    private GestionDeProfesores profesoresPanel;

    public Control(AgregarUniversidad pView, MenuPrincipal pMenu) {
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

    private void crearUniversidad(AgregarUniversidad view) {

        ModificarUniversidad optionsView = new ModificarUniversidad();
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
                "Informacion", JOptionPane.INFORMATION_MESSAGE);

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
                schoolsView = new SeleccionDeEscuela(universidad);
                ActualizarEsc(schoolsView);
            }
        });
        view.getBtnAdministrarP().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirPanelProfesores();
            }
        });
    }

    private void abrirPanelProfesores() {
        profesoresPanel = new GestionDeProfesores();
        view.cambiarPanelCentral(profesoresPanel);

        // Configurar listeners para los botones del panel de profesores
        configurarListenersProfesores();
    }

    private void configurarListenersProfesores() {
        // Aquí puedes configurar los listeners para cada botón del panel de profesores
        profesoresPanel.getBtnAgregarProfesor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para agregar profesor
                JOptionPane.showMessageDialog(profesoresPanel, "Funcionalidad para agregar profesor",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        profesoresPanel.getBtnAdministrarProfesor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para administrar profesor
                JOptionPane.showMessageDialog(profesoresPanel, "Funcionalidad para administrar profesor",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        profesoresPanel.getBtnConsultarEscuelas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para consultar escuelas
                schoolsView = new SeleccionDeEscuela(universidad);
                ActualizarEsc(schoolsView);
            }
        });

        profesoresPanel.getBtnConsultarProfesorPorCurso().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para consultar profesor por curso
                JOptionPane.showMessageDialog(profesoresPanel, "Funcionalidad para consultar profesor por curso",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private void actualizarPUni(ModificarUniversidad optionsView) {
        view.cambiarPanelCentral(optionsView);
        actualizarDUni(optionsView);
    }
    private void actualizarDUni(ModificarUniversidad optionsView) {
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
    private void ActualizarEsc(SeleccionDeEscuela schoolsView) {
        view.cambiarPanelCentral(schoolsView);
        ConsultarEsc(schoolsView);
    }
    private void ConsultarEsc(SeleccionDeEscuela schoolsView) {
        schoolsView.getBtnGestionarCursos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaEscuelas();
            }
        });
    }

    private void actualizarDatosUniversidad(ModificarUniversidad optionsView) {
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
                "Informacion", JOptionPane.INFORMATION_MESSAGE);

        agregarEscuela.getTxtNombreEscuela().setText("");
    }

    private void abrirVentanaEscuelas() {
        // Crear el controlador para la gestion de cursos
        cursoController = new CursoController(logic, schoolsView, view);
    }

    public void startGUI() {
        view.setVisible(true);
    }
}