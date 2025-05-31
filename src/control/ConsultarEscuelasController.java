package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.*;
import views.*;
import views.ConsultarEscuelasMP.OpcionesDeGestionDeCursos.GestionDeCursos.*;
import views.ConsultarEscuelasMP.OpcionesDeGestionDeCursos.OpcionesDeGestionDeCursos;
import views.ConsultarEscuelasMP.SeleccionDeEscuela;
import views.ConsultarEscuelasMP.OpcionesDeGestionDeCursos.GestionDeCursos.ProfesoresDeEscuela;

public class ConsultarEscuelasController {
    private Logic logic;
    private SeleccionDeEscuela schoolsView;
    private OpcionesDeGestionDeCursos managerView;
    private VentanaPrincipal view;
    
    public ConsultarEscuelasController(Logic logic, SeleccionDeEscuela schoolsView, VentanaPrincipal pView) {
        this.logic = logic;
        this.schoolsView = schoolsView;
        this.view = pView;
        
        // Configurar listener para el Boton de gestionar cursos
        this.schoolsView.getBtnGestionarCursos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirGestionCursos();
                visibilidad();
            }
        });
    }

    private void abrirProfesoresDeEscuela() {
        // Obtener todas las escuelas de la universidad
        ArrayList<Escuela> escuelas = logic.getUniversidad().getVector();

        if (escuelas.isEmpty()) {
            JOptionPane.showMessageDialog(managerView,
                    "No hay escuelas registradas en la universidad",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear array de nombres de escuelas para el combo box
        String[] nombresEscuelas = new String[escuelas.size()];
        for (int i = 0; i < escuelas.size(); i++) {
            nombresEscuelas[i] = escuelas.get(i).getNombre();
        }

        // Mostrar dialog con combo box
        String escuelaSeleccionada = (String) JOptionPane.showInputDialog(
                managerView,
                "Seleccione la escuela para ver sus profesores:",
                "Seleccionar Escuela",
                JOptionPane.QUESTION_MESSAGE,
                null,
                nombresEscuelas,
                nombresEscuelas[0]
        );

        // Si el usuario seleccionó una escuela
        if (escuelaSeleccionada != null) {
            // Buscar la escuela seleccionada
            Escuela escuela = null;
            for (Escuela e : escuelas) {
                if (e.getNombre().equals(escuelaSeleccionada)) {
                    escuela = e;
                    break;
                }
            }

            if (escuela != null) {
                // Crear y mostrar el panel de profesores
                ProfesoresDeEscuela profesoresView = new ProfesoresDeEscuela(escuela, logic.getUniversidad());

                // Configurar listeners para el panel de profesores
                configurarListenersProfesores   (profesoresView);

                // Cambiar al panel de profesores
                view.cambiarPanelCentral(profesoresView);
            }
        }
    }
    private void configurarListenersProfesores(ProfesoresDeEscuela profesoresView) {
        // Listener para el botón Volver
        profesoresView.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.cambiarPanelCentral(managerView);
            }
        });

        // Listener para el botón Cambiar Director
        profesoresView.getBtnCambiarDirector().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarDirectorEscuela(profesoresView);
            }
        });
    }

    private void cambiarDirectorEscuela(ProfesoresDeEscuela profesoresView) {
        Profesor profesorSeleccionado = profesoresView.getProfesorSeleccionado();

        if (profesorSeleccionado == null) {
            JOptionPane.showMessageDialog(profesoresView,
                    "Por favor, seleccione un profesor de la tabla",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirmar el cambio
        int respuesta = JOptionPane.showConfirmDialog(profesoresView,
                "¿Está seguro que desea asignar a " + profesorSeleccionado.getNombre() +
                        " " + profesorSeleccionado.getApellidos() + " como director de la escuela?",
                "Confirmar Cambio de Director",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {
            try {
                // Cambiar el director usando el método de Logic
                logic.cambiarDirectorEscuela(profesorSeleccionado, profesoresView.getEscuelaSeleccionada());

                // Actualizar la vista
                profesoresView.actualizarDatos();

                JOptionPane.showMessageDialog(profesoresView,
                        "Director cambiado exitosamente",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(profesoresView,
                        "Error al cambiar el director: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    private void abrirGestionCursos() {
        Escuela escuelaSeleccionada = schoolsView.getEscuelaSeleccionada();
        if (escuelaSeleccionada == null) {
            JOptionPane.showMessageDialog(schoolsView, 
                "Por favor, seleccione una escuela", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        managerView = new OpcionesDeGestionDeCursos(escuelaSeleccionada, logic.getUniversidad());
        configurarListenersManager();
        
    }
    
    private void configurarListenersManager() {
        //Boton para incluir curso
        managerView.getBtnIncluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirIncluirCurso();
            }
        });
        
        // 	Boton para consultar curso
        managerView.getBtnConsultarCurso().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirConsultarCurso();
            }
        });
        
        // Boton para listar cursos de una escuela
        managerView.getBtnListarCursosEscuela().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirListarCursosEscuela();
            }
        });
        
        // Boton para listar todos los cursos
        managerView.getBtnListarTodosCursos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirListarTodosCursos();
            }
        });
        
        // Boton para modificar curso
        managerView.getBtnModificarCurso().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirModificarCurso();
            }
        });
        
        // Boton para eliminar curso
        managerView.getBtnEliminarCurso().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirEliminarCurso();
            }
        });

        // *** AGREGAR ESTE LISTENER PARA EL BOTÓN PROFESORES DE ESCUELA ***
        managerView.getBtnProfesoresDeEscuela().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirProfesoresDeEscuela();
            }
        });
        managerView.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	view.cambiarPanelCentral(schoolsView);
            }
        });
    }
    
    // Metodos para abrir las distintas vistas
    
    private void abrirIncluirCurso() {
        AgregarUnCurso incluirView = new AgregarUnCurso(managerView.getEscuelaActual());
        
        incluirView.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombreCurso = incluirView.getNombreCurso();
                    String siglasStr = incluirView.getSigla();
                    String creditosStr = incluirView.getCreditos(); // OBTENER CRÉDITOS
                    //AHORA TAMBIEN VALIDA CREDITOS
                    if (nombreCurso.isEmpty() || siglasStr.isEmpty() || creditosStr.isEmpty()) {
                        JOptionPane.showMessageDialog(incluirView, 
                            "Por favor, complete todos los campos", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    // Validar que el nombre del curso solo contenga letras y espacios
                    if(!nombreCurso.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                        JOptionPane.showMessageDialog(incluirView,
                            "El nombre del curso solo debe contener letras y espacios",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    // Validar que las siglas tengan exactamente 3 caracteres
                    if (siglasStr.length() != 3) {
                        JOptionPane.showMessageDialog(incluirView,
                            "Las siglas deben tener exactamente 3 caracteres",
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    // VALIDAR QUE LOS CRÉDITOS SEAN UN NÚMERO VÁLIDO
                    int creditos;
                    try {
                        creditos = Integer.parseInt(creditosStr);
                        if (creditos <= 0) {
                            JOptionPane.showMessageDialog(incluirView,
                                    "Los créditos deben ser un número mayor a 0",
                                    "Error de validación", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (creditos > 10) { // Límite razonable para créditos
                            JOptionPane.showMessageDialog(incluirView,
                                    "Los créditos no pueden ser mayores a 10",
                                    "Error de validación", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(incluirView,
                                "Los créditos deben ser un número válido",
                                "Error de validación", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    // Verificar si ya existe un curso con ese nombre en la escuela
                    boolean cursoExiste = false;
                    for(Curso curso : incluirView.getEscuelaActual().getCursos()) {
                        if(curso.getNombre().equalsIgnoreCase(nombreCurso)) {
                            cursoExiste = true;
                            break;
                        }
                    }

                    if(cursoExiste) {
                        JOptionPane.showMessageDialog(incluirView,
                            "Ya existe un curso con ese nombre en esta escuela",
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String siglas = siglasStr ;
                    Curso nuevoCurso = new Curso(siglas, nombreCurso, creditos);
                    logic.agregarCurso(nuevoCurso, incluirView.getEscuelaActual());
                    
                    JOptionPane.showMessageDialog(incluirView, 
                        "Curso agregado exitosamente", 
                        "Exito", JOptionPane.INFORMATION_MESSAGE);
                    view.cambiarPanelCentral(managerView);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(incluirView, 
                        "Error al agregar el curso: " + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        incluirView.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	view.cambiarPanelCentral(managerView);
            }
        });
        
        view.cambiarPanelCentral(incluirView);
    }
    
    private void abrirConsultarCurso() {
        final DatosDeCurso consultarView = new DatosDeCurso(managerView.getEscuelaActual());
        
        consultarView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombreCurso = consultarView.getNombreCursoBuscar();
                    if (nombreCurso.isEmpty()) {
                        JOptionPane.showMessageDialog(consultarView, 
                            "Por favor, ingrese el nombre del curso a buscar", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    String resultado = logic.consultarCurso(consultarView.getEscuelaActual(), nombreCurso);
                    consultarView.setResultado(resultado);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(consultarView, 
                        "Error al consultar el curso: " + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        consultarView.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	view.cambiarPanelCentral(managerView);
            }
        });
        
        view.cambiarPanelCentral(consultarView);
    }
    
    private void abrirListarCursosEscuela() {
        final ListaDeCursosPorEscuela listarView = new ListaDeCursosPorEscuela(managerView.getEscuelaActual());
        
        // Mostrar la lista inicial de cursos
        actualizarListaCursos(listarView);
        
//        listarView.getBtnActualizar().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                actualizarListaCursos(listarView);
//            }
//        });
        
        listarView.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	view.cambiarPanelCentral(managerView);
            }
        });
        
        view.cambiarPanelCentral(listarView);
    }
    
    private void actualizarListaCursos(ListaDeCursosPorEscuela view) {
        try {
            String listaCursos = logic.consultarCursosDeEscuela(view.getEscuelaActual());
            view.setListaCursos(listaCursos);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, 
                "Error al listar los cursos: " + ex.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void abrirListarTodosCursos() {
        final ListaDeCursosPorUniversidad listarView = new ListaDeCursosPorUniversidad(logic.getUniversidad());
        
        // Mostrar la lista inicial de todos los cursos
        actualizarListaTodosCursos(listarView);
        
//        listarView.getBtnActualizar().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                actualizarListaTodosCursos(listarView);
//            }
//        });
        
        listarView.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	view.cambiarPanelCentral(managerView);
            }
        });
        
        view.cambiarPanelCentral(listarView);
    }
    
    private void actualizarListaTodosCursos(ListaDeCursosPorUniversidad view) {
        try {
            String listaCursos = logic.consultarCursosUniversidad(view.getUniversidad());
            view.setListaCursos(listaCursos);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, 
                "Error al listar los cursos: " + ex.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void abrirModificarCurso() {
        final ModificarDatosDeUnCurso modificarView = new ModificarDatosDeUnCurso(managerView.getEscuelaActual());
        
        modificarView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreCurso = modificarView.getNombreCursoBuscar();
                if (nombreCurso.isEmpty()) {
                    JOptionPane.showMessageDialog(modificarView, 
                        "Por favor, ingrese el nombre del curso a modificar", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Verificar si el curso existe
                String resultado = logic.consultarCurso(modificarView.getEscuelaActual(), nombreCurso);
                if (resultado.equals("Curso no encontrado.")) {
                    JOptionPane.showMessageDialog(modificarView, 
                        "El curso no existe", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(modificarView, 
                        "Curso encontrado. Ahora puede modificar su nombre.", 
                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        modificarView.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombreCurso = modificarView.getNombreCursoBuscar();
                    String nuevoNombre = modificarView.getNuevoNombre();
                    
                    if (nombreCurso.isEmpty() || nuevoNombre.isEmpty()) {
                        JOptionPane.showMessageDialog(modificarView, 
                            "Por favor, complete todos los campos", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                 // Validar que el nuevo nombre solo contenga letras y espacios
                    if(!nuevoNombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                        JOptionPane.showMessageDialog(modificarView,
                            "El nuevo nombre del curso solo debe contener letras y espacios",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Verificar si ya existe un curso con el nuevo nombre en la escuela
                    boolean nuevoNombreExiste = false;
                    for(Curso curso : modificarView.getEscuelaActual().getCursos()) {
                        if(!curso.getNombre().equalsIgnoreCase(nombreCurso) && 
                           curso.getNombre().equalsIgnoreCase(nuevoNombre)) {
                            nuevoNombreExiste = true;
                            break;
                        }
                    }

                    if(nuevoNombreExiste) {
                        JOptionPane.showMessageDialog(modificarView,
                            "Ya existe un curso con ese nombre en esta escuela",
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    boolean resultado = logic.modificarCurso(nombreCurso, modificarView.getEscuelaActual(), nuevoNombre);
                    if (resultado) {
                        JOptionPane.showMessageDialog(modificarView, 
                            "Curso modificado exitosamente", 
                            "Exito", JOptionPane.INFORMATION_MESSAGE);
                        view.cambiarPanelCentral(managerView);
                    } else {
                        JOptionPane.showMessageDialog(modificarView, 
                            "No se encontro el curso", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(modificarView, 
                        "Error al modificar el curso: " + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        modificarView.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	view.cambiarPanelCentral(managerView);
            }
        });
        
        view.cambiarPanelCentral(modificarView);
    }
    
    private void abrirEliminarCurso() {
        EliminarUnCurso eliminarView = new EliminarUnCurso(managerView.getEscuelaActual());
        
        eliminarView.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombreCurso = eliminarView.getNombreCurso();
                    if (nombreCurso.isEmpty()) {
                        JOptionPane.showMessageDialog(eliminarView, 
                            "ingrese el nombre del curso a eliminar", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    // Confirmar antes de eliminar
                    int respuesta = JOptionPane.showConfirmDialog(eliminarView, 
                        "�Esta seguro que desea eliminar el curso \"" + nombreCurso + "\"?", 
                        "Confirmar eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    
                    if (respuesta == JOptionPane.YES_OPTION) {
                        boolean resultado = logic.eliminarCurso(nombreCurso, eliminarView.getEscuelaActual());
                        if (resultado) {
                            JOptionPane.showMessageDialog(eliminarView, 
                                "Curso eliminado exitosamente", 
                                "Exito", JOptionPane.INFORMATION_MESSAGE);
                            view.cambiarPanelCentral(managerView);
                        } else {
                            JOptionPane.showMessageDialog(eliminarView, 
                                "No se encontro el curso", 
                                "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(eliminarView, 
                        "Error al eliminar el curso: " + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        eliminarView.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	view.cambiarPanelCentral(managerView);
            }
        });
        
        view.cambiarPanelCentral(eliminarView);
    }
    private void visibilidad() {
    	view.cambiarPanelCentral(managerView);
    }
}