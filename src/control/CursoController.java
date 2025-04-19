package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import models.*;
import views.*;
import com.formdev.flatlaf.FlatDarkLaf;
public class CursoController {
    private Logic logic;
    private SchoolsView schoolsView;
    private CursoManagerView managerView;
    
    public CursoController(Logic logic, SchoolsView schoolsView) {
        this.logic = logic;
        this.schoolsView = schoolsView;
        
        // Configurar listener para el Boton de gestionar cursos
        this.schoolsView.getBtnGestionarCursos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirGestionCursos();
            }
        });
    }
    
    private void abrirGestionCursos() {
        Escuela escuelaSeleccionada = schoolsView.getEscuelaSeleccionada();
        if (escuelaSeleccionada == null) {
            JOptionPane.showMessageDialog(schoolsView, 
                "Por favor, seleccione una escuela", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        managerView = new CursoManagerView(escuelaSeleccionada, logic.getUniversidad());
        configurarListenersManager();
        managerView.setVisible(true);
    }
    
    private void configurarListenersManager() {
        // Boton para incluir curso
        managerView.getBtnIncluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirIncluirCurso();
            }
        });
        
        // Boton para consultar curso
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
        
        // Boton para volver
        managerView.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                managerView.dispose();
            }
        });
    }
    
    // Metodos para abrir las distintas vistas
    
    private void abrirIncluirCurso() {
        IncluirCursoView incluirView = new IncluirCursoView(managerView.getEscuelaActual());
        
        incluirView.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombreCurso = incluirView.getNombreCurso();
                    String siglasStr = incluirView.getSigla();
                    
                    if (nombreCurso.isEmpty() || siglasStr.isEmpty()) {
                        JOptionPane.showMessageDialog(incluirView, 
                            "Por favor, complete todos los campos", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if (siglasStr.length() > 3) {
                        JOptionPane.showMessageDialog(incluirView, 
                            "Las siglas deben deben de tener 3 caracteres ", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    String siglas = siglasStr ;
                    Curso nuevoCurso = new Curso(siglas, nombreCurso);
                    logic.agregarCurso(nuevoCurso, incluirView.getEscuelaActual());
                    
                    JOptionPane.showMessageDialog(incluirView, 
                        "Curso agregado exitosamente", 
                        "Exito", JOptionPane.INFORMATION_MESSAGE);
                    incluirView.dispose();
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
                incluirView.dispose();
            }
        });
        
        incluirView.setVisible(true);
    }
    
    private void abrirConsultarCurso() {
        final ConsultarCursoView consultarView = new ConsultarCursoView(managerView.getEscuelaActual());
        
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
                consultarView.dispose();
            }
        });
        
        consultarView.setVisible(true);
    }
    
    private void abrirListarCursosEscuela() {
        final ListarCursosEscuelaView listarView = new ListarCursosEscuelaView(managerView.getEscuelaActual());
        
        // Mostrar la lista inicial de cursos
        actualizarListaCursos(listarView);
        
        listarView.getBtnActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarListaCursos(listarView);
            }
        });
        
        listarView.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarView.dispose();
            }
        });
        
        listarView.setVisible(true);
    }
    
    private void actualizarListaCursos(ListarCursosEscuelaView view) {
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
        final ListarTodosCursosView listarView = new ListarTodosCursosView(logic.getUniversidad());
        
        // Mostrar la lista inicial de todos los cursos
        actualizarListaTodosCursos(listarView);
        
        listarView.getBtnActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarListaTodosCursos(listarView);
            }
        });
        
        listarView.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarView.dispose();
            }
        });
        
        listarView.setVisible(true);
    }
    
    private void actualizarListaTodosCursos(ListarTodosCursosView view) {
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
        final ModificarCursoView modificarView = new ModificarCursoView(managerView.getEscuelaActual());
        
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
                        "Información", JOptionPane.INFORMATION_MESSAGE);
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
                    
                    boolean resultado = logic.modificarCurso(nombreCurso, modificarView.getEscuelaActual(), nuevoNombre);
                    if (resultado) {
                        JOptionPane.showMessageDialog(modificarView, 
                            "Curso modificado exitosamente", 
                            "Exito", JOptionPane.INFORMATION_MESSAGE);
                        modificarView.dispose();
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
                modificarView.dispose();
            }
        });
        
        modificarView.setVisible(true);
    }
    
    private void abrirEliminarCurso() {
        EliminarCursoView eliminarView = new EliminarCursoView(managerView.getEscuelaActual());
        
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
                        "¿Esta seguro que desea eliminar el curso \"" + nombreCurso + "\"?", 
                        "Confirmar eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    
                    if (respuesta == JOptionPane.YES_OPTION) {
                        boolean resultado = logic.eliminarCurso(nombreCurso, eliminarView.getEscuelaActual());
                        if (resultado) {
                            JOptionPane.showMessageDialog(eliminarView, 
                                "Curso eliminado exitosamente", 
                                "Exito", JOptionPane.INFORMATION_MESSAGE);
                            eliminarView.dispose();
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
                eliminarView.dispose();
            }
        });
        
        eliminarView.setVisible(true);
    }
}