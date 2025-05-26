package control;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import models.*;
import views.*;
import views.AgregarEscuela.AgregarEscuela;
import views.ConsultarEscuelasMP.SeleccionDeEscuela;
import views.GestionDeProfesores.AdministrarProfesor.ConsultarProfesor;
import views.GestionDeProfesores.AgregarProfesor.AgregarProfesor;
import views.GestionDeProfesores.ConsultarProfesorPorCurso.ConsultarProfesorPorCurso;
import views.GestionDeProfesores.GestionDeProfesores;
import views.MenuPrincipal.MenuPrincipal;
import views.ModificarUniversidad.ModificarUniversidad;
import views.GestionDeProfesores.AdministrarProfesor.DetalleDeProfesor.DetalleProfesor;

public class Controller {
    private MenuPrincipal pMenu;
    private VentanaPrincipal view;
    private Universidad universidad;
    private Logic logic;
    private SeleccionDeEscuela schoolsView;
    private ConsultarEscuelasController cursoController;
    private GestionDeProfesores profesoresPanel;

    public Controller(VentanaPrincipal pView, MenuPrincipal pMenu) {
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

    private void crearUniversidad(VentanaPrincipal view) {

        ModificarUniversidad optionsView = new ModificarUniversidad();
        AgregarEscuela agregarEscuela = new AgregarEscuela();
        String nombre = pMenu.getNombreView();
        String direccion = pMenu.getDireccionView();
        String telefono = pMenu.getTelefonoView();
        //Validar si los campos estan vacios
        if(nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(pMenu, "Por favor, complete todos los campos",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Validar que el nombre solo contenga letras y espacios
        if(!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            JOptionPane.showMessageDialog(pMenu, "El nombre de la universidad solo debe contener letras y espacios",
                "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Validar que el telefono sean numeros
        if(!telefono.matches("^[0-9]+$")) {
            JOptionPane.showMessageDialog(pMenu, "El teléfono solo debe contener números",
                "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        universidad = new Universidad(nombre, direccion, telefono);
        logic = new Logic(universidad);

        // Habilitar la visualización del título en la ventana principal
        view.setNombreUniversidad("Bienvenido a " + nombre);

        JOptionPane.showMessageDialog(pMenu, "Universidad " + nombre + " creada exitosamente",
                "Informacion", JOptionPane.INFORMATION_MESSAGE);

        // CAMBIO PRINCIPAL: Automáticamente abrir el panel de actualizar universidad
        actualizarPUni(optionsView);

        // Configurar listeners para todos los botones
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
                AgregarProfesor agregarProfesor = new AgregarProfesor(universidad);
                view.cambiarPanelCentral(agregarProfesor);

                // Configurar listeners para los botones del formulario
                configurarListenersAgregarProfesor(agregarProfesor);
            }
        });

        profesoresPanel.getBtnAdministrarProfesor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultarProfesor consultarProfesor = new ConsultarProfesor();
                view.cambiarPanelCentral(consultarProfesor);

                // Configurar listeners para el panel de consultar profesor
                configurarListenersConsultarProfesor(consultarProfesor);
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
                ConsultarProfesorPorCurso consultarProfesorPorCurso = new ConsultarProfesorPorCurso();
                view.cambiarPanelCentral(consultarProfesorPorCurso);

                // ¡AGREGAR ESTAS LÍNEAS QUE FALTAN!
                configurarListenersConsultarProfesorPorCurso(consultarProfesorPorCurso);
                cargarEscuelasEnConsulta(consultarProfesorPorCurso);
            }
        });
    }

    private void configurarListenersConsultarProfesorPorCurso(ConsultarProfesorPorCurso consultarView) {
        // Listener para el botón Seleccionar
        consultarView.getBtnSeleccionar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarSeleccionConsultaProfesorCurso(consultarView);
            }
        });

        // Listener para el botón Atrás
        consultarView.getBtnAtras().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarAtrasConsultaProfesorCurso(consultarView);
            }
        });

        // Listener para el botón Volver
        consultarView.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirPanelProfesores(); // Regresa al panel de profesores
            }
        });
    }

    private void cargarEscuelasEnConsulta(ConsultarProfesorPorCurso consultarView) {
        // Limpiar y configurar para mostrar escuelas
        consultarView.limpiar();
        consultarView.setEstado(ConsultarProfesorPorCurso.Estado.SELECCIONAR_ESCUELA);

        // Agregar las escuelas a la lista
        for (Escuela escuela : universidad.getVector()) {
            consultarView.agregarElemento(escuela.getNombre());
        }

        if (universidad.getVector().isEmpty()) {
            JOptionPane.showMessageDialog(consultarView,
                    "No hay escuelas registradas en la universidad",
                    "Sin escuelas", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void manejarSeleccionConsultaProfesorCurso(ConsultarProfesorPorCurso consultarView) {
        String elementoSeleccionado = consultarView.getElementoSeleccionado();

        if (elementoSeleccionado == null) {
            String mensaje = "";
            switch (consultarView.getEstadoActual()) {
                case SELECCIONAR_ESCUELA:
                    mensaje = "Por favor, seleccione una escuela";
                    break;
                case SELECCIONAR_CURSO:
                    mensaje = "Por favor, seleccione un curso";
                    break;
            }
            JOptionPane.showMessageDialog(consultarView, mensaje,
                    "Selección requerida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        switch (consultarView.getEstadoActual()) {
            case SELECCIONAR_ESCUELA:
                manejarSeleccionEscuela(consultarView, elementoSeleccionado);
                break;
            case SELECCIONAR_CURSO:
                manejarSeleccionCurso(consultarView, elementoSeleccionado);
                break;
        }
    }

    private void manejarSeleccionEscuela(ConsultarProfesorPorCurso consultarView, String nombreEscuela) {
        // Buscar la escuela seleccionada
        Escuela escuelaSeleccionada = null;
        for (Escuela escuela : universidad.getVector()) {
            if (escuela.getNombre().equals(nombreEscuela)) {
                escuelaSeleccionada = escuela;
                break;
            }
        }

        if (escuelaSeleccionada == null) {
            JOptionPane.showMessageDialog(consultarView,
                    "Error: No se encontró la escuela seleccionada",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar si la escuela tiene cursos
        if (escuelaSeleccionada.getCursos().isEmpty()) {
            JOptionPane.showMessageDialog(consultarView,
                    "La escuela " + nombreEscuela + " no tiene cursos registrados",
                    "Sin cursos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Cambiar al estado de selección de cursos
        consultarView.setEscuelaSeleccionada(nombreEscuela);
        consultarView.setEstado(ConsultarProfesorPorCurso.Estado.SELECCIONAR_CURSO);

        // Cargar los cursos de la escuela
        for (Curso curso : escuelaSeleccionada.getCursos()) {
            consultarView.agregarElemento(curso.getNombre() + " (" + curso.getSigla() + ")");
        }
    }

    private void manejarSeleccionCurso(ConsultarProfesorPorCurso consultarView, String cursoInfo) {
        // Extraer el nombre del curso (antes del paréntesis)
        String nombreCurso = cursoInfo.substring(0, cursoInfo.lastIndexOf(" (")).trim();

        // Buscar la escuela y el curso
        Escuela escuelaSeleccionada = null;
        for (Escuela escuela : universidad.getVector()) {
            if (escuela.getNombre().equals(consultarView.getEscuelaSeleccionada())) {
                escuelaSeleccionada = escuela;
                break;
            }
        }

        if (escuelaSeleccionada == null) {
            JOptionPane.showMessageDialog(consultarView,
                    "Error: No se encontró la escuela",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Buscar el curso en la escuela
        Curso cursoSeleccionado = null;
        for (Curso curso : escuelaSeleccionada.getCursos()) {
            if (curso.getNombre().equals(nombreCurso)) {
                cursoSeleccionado = curso;
                break;
            }
        }

        if (cursoSeleccionado == null) {
            JOptionPane.showMessageDialog(consultarView,
                    "Error: No se encontró el curso seleccionado",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Mostrar los profesores del curso
        mostrarProfesoresDelCurso(consultarView, cursoSeleccionado, cursoInfo);
    }

    private void mostrarProfesoresDelCurso(ConsultarProfesorPorCurso consultarView,
                                           Curso curso, String cursoInfo) {
        // Cambiar al estado de mostrar profesores
        consultarView.setCursoSeleccionado(cursoInfo);
        consultarView.setEstado(ConsultarProfesorPorCurso.Estado.MOSTRAR_PROFESORES);

        // Generar el texto con la información de los profesores
        StringBuilder resultado = new StringBuilder();
        resultado.append("CURSO: ").append(curso.getNombre())
                .append(" (").append(curso.getSigla()).append(")\n");
        resultado.append("ESCUELA: ").append(consultarView.getEscuelaSeleccionada()).append("\n\n");

        if (curso.getProfesoresDelCurso().isEmpty()) {
            resultado.append("Este curso no tiene profesores asignados.");
        } else {
            resultado.append("PROFESORES ASIGNADOS:\n");
            resultado.append("========================\n\n");

            int contador = 1;
            for (Profesor profesor : curso.getProfesoresDelCurso()) {
                resultado.append(contador++).append(". ");
                resultado.append("Cédula: ").append(profesor.getCedula()).append("\n");
                resultado.append("   Nombre: ").append(profesor.getNombre())
                        .append(" ").append(profesor.getApellidos()).append("\n");

                // Mostrar otros cursos del profesor
                resultado.append("   Otros cursos que imparte:\n");
                boolean tieneOtrosCursos = false;
                for (Curso otroCurso : profesor.getCursosDelProfesor()) {
                    if (!otroCurso.getSigla().equals(curso.getSigla())) {
                        resultado.append("     - ").append(otroCurso.getNombre())
                                .append(" (").append(otroCurso.getSigla()).append(")\n");
                        tieneOtrosCursos = true;
                    }
                }
                if (!tieneOtrosCursos) {
                    resultado.append("     - Ninguno\n");
                }
                resultado.append("\n");
            }
        }

        // Mostrar el resultado en el área de texto
        consultarView.mostrarResultado(resultado.toString());
    }

    private void manejarAtrasConsultaProfesorCurso(ConsultarProfesorPorCurso consultarView) {
        switch (consultarView.getEstadoActual()) {
            case SELECCIONAR_CURSO:
                // Volver a la selección de escuelas
                cargarEscuelasEnConsulta(consultarView);
                break;
            case MOSTRAR_PROFESORES:
                // Volver a la selección de cursos
                String escuela = consultarView.getEscuelaSeleccionada();
                consultarView.setEstado(ConsultarProfesorPorCurso.Estado.SELECCIONAR_CURSO);

                // Recargar los cursos de la escuela
                Escuela escuelaObj = null;
                for (Escuela e : universidad.getVector()) {
                    if (e.getNombre().equals(escuela)) {
                        escuelaObj = e;
                        break;
                    }
                }

                if (escuelaObj != null) {
                    for (Curso curso : escuelaObj.getCursos()) {
                        consultarView.agregarElemento(curso.getNombre() + " (" + curso.getSigla() + ")");
                    }
                }
                break;
        }
    }
    // Método nuevo para manejar los listeners del formulario AgregarProfesor

    private void configurarListenersConsultarProfesor(ConsultarProfesor consultarProfesor) {
        // Listener para el botón Buscar
        consultarProfesor.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarYMostrarProfesor(consultarProfesor);
            }
        });

        // Listener para el botón Volver
        consultarProfesor.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirPanelProfesores(); // Regresa al panel de profesores
            }
        });
    }

    private void configurarListenersAgregarProfesor(AgregarProfesor agregarProfesor) {
        // Listener para el botón Guardar
        agregarProfesor.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarNuevoProfesor(agregarProfesor);
            }
        });

        // Listener para el botón Volver
        agregarProfesor.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirPanelProfesores(); // Regresa al panel de profesores
            }
        });
    }
    // Agrega este nuevo método para buscar y mostrar el profesor
    private void buscarYMostrarProfesor(ConsultarProfesor consultarProfesor) {
        String cedula = consultarProfesor.getCedula().trim();

        // Validar que se haya ingresado una cédula
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(consultarProfesor,
                    "Por favor, ingrese una cedula",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Buscar el profesor usando la lógica existente
        Profesor profesorEncontrado = logic.buscarProfesor(cedula, universidad);

        if (profesorEncontrado != null) {
            // Si se encontró el profesor, mostrar el panel de detalles
            mostrarDetalleProfesor(profesorEncontrado);
        } else {
            // Si no se encontró, mostrar mensaje de error
            JOptionPane.showMessageDialog(consultarProfesor,
                    "No se encontro ningun profesor con la cedula: " + cedula,
                    "Profesor no encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void mostrarDetalleProfesor(Profesor profesor) {
        DetalleProfesor detalleProfesor = new DetalleProfesor();
        view.cambiarPanelCentral(detalleProfesor);

        // Actualizar los datos del profesor en el panel
        detalleProfesor.actualizarDatosProfesor(
                profesor.getCedula(),
                profesor.getNombre(),
                profesor.getApellidos()
        );

        // Actualizar la tabla de cursos del profesor
        actualizarTablaCursos(detalleProfesor, profesor);

        // Configurar listeners para los botones del panel de detalles
        configurarListenersDetalleProfesor(detalleProfesor, profesor);
    }
    private void actualizarTablaCursos(DetalleProfesor detalleProfesor, Profesor profesor) {
        // Obtener los cursos del profesor
        ArrayList<Curso> cursosProfesor = profesor.getCursosDelProfesor();

        // Crear datos para la tabla
        Object[][] datosCursos = new Object[cursosProfesor.size()][3];

        for (int i = 0; i < cursosProfesor.size(); i++) {
            Curso curso = cursosProfesor.get(i);
            // Buscar la escuela que contiene este curso
            String nombreEscuela = "No encontrada";
            for (Escuela escuela : universidad.getVector()) {
                if (escuela.getCursos().contains(curso)) {
                    nombreEscuela = escuela.getNombre();
                    break;
                }
            }

            datosCursos[i][0] = curso.getSigla(); // Usar getSigla() en lugar de getCodigo()
            datosCursos[i][1] = curso.getNombre();
            datosCursos[i][2] = nombreEscuela;
        }

        // Actualizar la tabla
        String[] columnNames = {"Sigla", "Nombre del Curso", "Escuela"};
        detalleProfesor.getTablaCursos().setModel(new javax.swing.table.DefaultTableModel(datosCursos, columnNames));
    }
    private void configurarListenersDetalleProfesor(DetalleProfesor detalleProfesor, Profesor profesor) {
        // Listener para el botón Modificar Datos
        detalleProfesor.getBtnModificarDatos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarDatosProfesor(profesor);
            }
        });

        // Listener para el botón Modificar Curso
        detalleProfesor.getBtnModificarCurso().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarCursosProfesor(profesor, detalleProfesor);
            }
        });

        // Listener para el botón Volver
        detalleProfesor.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirPanelProfesores(); // Regresa al panel de profesores
            }
        });
    }
    // Agrega este método para modificar/asignar cursos al profesor
    private void modificarCursosProfesor(Profesor profesor, DetalleProfesor detalleProfesor) {
        // Crear opciones del diálogo
        String[] opciones = {"Asignar Curso", "Quitar Curso", "Cancelar"};

        int opcion = JOptionPane.showOptionDialog(
                view,
                "¿Qué desea hacer con los cursos del profesor?",
                "Modificar Cursos",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        switch (opcion) {
            case 0: // Asignar Curso
                asignarCursoAProfesor(profesor, detalleProfesor);
                break;
            case 1: // Quitar Curso
                quitarCursoAProfesor(profesor, detalleProfesor);
                break;
            case 2: // Cancelar
            default:
                break;
        }
    }
    // Método para asignar un nuevo curso al profesor
    private void asignarCursoAProfesor(Profesor profesor, DetalleProfesor detalleProfesor) {
    	  // Determinar la escuela del profesor basándose en sus cursos actuales
        Escuela escuelaDelProfesor = null;
        
        if (!profesor.getCursosDelProfesor().isEmpty()) {
            // El profesor ya tiene cursos, encontrar su escuela
            Curso primerCurso = profesor.getCursosDelProfesor().get(0);
            
            for (Escuela escuela : universidad.getVector()) {
                if (escuela.getCursos().contains(primerCurso)) {
                    escuelaDelProfesor = escuela;
                    break;
                }
            }
        }
        
        // Obtener cursos disponibles según la situación del profesor
        JComboBox<String> comboCursos = new JComboBox<>();
        ArrayList<Curso> cursosDisponibles = new ArrayList<>();
        
        if (escuelaDelProfesor != null) {
            // El profesor ya pertenece a una escuela, solo mostrar cursos de esa escuela
            for (Curso curso : escuelaDelProfesor.getCursos()) {
                if (!profesor.getCursosDelProfesor().contains(curso)) {
                    comboCursos.addItem(escuelaDelProfesor.getNombre() + " - " + curso.getNombre() + " (" + curso.getSigla() + ")");
                    cursosDisponibles.add(curso);
                }
            }
        } else {
            // El profesor no tiene cursos asignados, puede elegir de cualquier escuela
            for (Escuela escuela : universidad.getVector()) {
                for (Curso curso : escuela.getCursos()) {
                    comboCursos.addItem(escuela.getNombre() + " - " + curso.getNombre() + " (" + curso.getSigla() + ")");
                    cursosDisponibles.add(curso);
                }
            }
        }
        
        if (comboCursos.getItemCount() == 0) {
            String mensaje;
            if (escuelaDelProfesor != null) {
                mensaje = "No hay cursos disponibles para asignar al profesor.\n" +
                         "El profesor ya tiene todos los cursos de la escuela \"" + 
                         escuelaDelProfesor.getNombre() + "\" asignados.";
            } else {
                mensaje = "No hay cursos disponibles para asignar al profesor.";
            }
            
            JOptionPane.showMessageDialog(view, mensaje,
                "Sin cursos disponibles", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // Crear panel personalizado con el ComboBox
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        
        String tituloPanel;
        if (escuelaDelProfesor != null) {
            tituloPanel = "Seleccione el curso a asignar (Solo escuela: " + escuelaDelProfesor.getNombre() + "):";
        } else {
            tituloPanel = "Seleccione el curso a asignar (Primera asignación - puede elegir cualquier escuela):";
        }
        
        panel.add(new JLabel(tituloPanel), BorderLayout.NORTH);
        panel.add(comboCursos, BorderLayout.CENTER);
        
        int resultado = JOptionPane.showConfirmDialog(
            view,
            panel,
            "Asignar Curso",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );
        
        if (resultado == JOptionPane.OK_OPTION) {
            int indiceSeleccionado = comboCursos.getSelectedIndex();
            if (indiceSeleccionado >= 0) {
                Curso cursoSeleccionado = cursosDisponibles.get(indiceSeleccionado);
                
                // Usar el método existente de la lógica
                logic.agregarCursoProfesor(profesor, cursoSeleccionado);
                
                JOptionPane.showMessageDialog(view,
                    "Curso asignado exitosamente al profesor",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
                
                // Actualizar la vista
                mostrarDetalleProfesor(profesor);
            }
        }
    }
    
    // Método para quitar un curso del profesor
    private void quitarCursoAProfesor(Profesor profesor, DetalleProfesor detalleProfesor) {
        ArrayList<Curso> cursosProfesor = profesor.getCursosDelProfesor();

        if (cursosProfesor.isEmpty()) {
            JOptionPane.showMessageDialog(view,
                    "El profesor no tiene cursos asignados para quitar.",
                    "Sin cursos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Crear ComboBox con los cursos del profesor
        JComboBox<String> comboCursos = new JComboBox<>();

        for (Curso curso : cursosProfesor) {
            // Buscar la escuela del curso para mostrar información completa
            String nombreEscuela = "Escuela no encontrada";
            for (Escuela escuela : universidad.getVector()) {
                if (escuela.getCursos().contains(curso)) {
                    nombreEscuela = escuela.getNombre();
                    break;
                }
            }
            comboCursos.addItem(nombreEscuela + " - " + curso.getNombre() + " (" + curso.getSigla() + ")");
        }

        // Crear panel personalizado
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(new JLabel("Seleccione el curso a quitar:"), BorderLayout.NORTH);
        panel.add(comboCursos, BorderLayout.CENTER);

        int resultado = JOptionPane.showConfirmDialog(
                view,
                panel,
                "Quitar Curso",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (resultado == JOptionPane.OK_OPTION) {
            int indiceSeleccionado = comboCursos.getSelectedIndex();
            if (indiceSeleccionado >= 0) {
                Curso cursoAQuitar = cursosProfesor.get(indiceSeleccionado);

                // Quitar el curso del profesor
                profesor.eliminarCurso(cursoAQuitar);
                // También quitar el profesor del curso
                cursoAQuitar.getProfesoresDelCurso().remove(profesor);

                JOptionPane.showMessageDialog(view,
                        "Curso removido exitosamente del profesor",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);

                // Actualizar la vista
                mostrarDetalleProfesor(profesor);
            }
        }
    }
    private void modificarDatosProfesor(Profesor profesor) {
        String nuevoNombre = JOptionPane.showInputDialog(view,
                "Ingrese el nuevo nombre:", profesor.getNombre());

        String nuevosApellidos = JOptionPane.showInputDialog(view,
                "Ingrese los nuevos apellidos:", profesor.getApellidos());
        
        // Verificar si el usuario canceló algún diálogo
        if (nuevoNombre == null || nuevosApellidos == null) {
            return; // El usuario canceló, no hacer nada
        }
        
     // Validar que los campos no estén vacíos
        if (nuevoNombre.isEmpty() || nuevosApellidos.isEmpty()) {
            JOptionPane.showMessageDialog(view,
                "Por favor, complete todos los campos",
                "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validación: El nombre debe contener solo letras (incluyendo espacios y acentos)
        if (!nuevoNombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            JOptionPane.showMessageDialog(view,
                "El nombre debe contener únicamente letras",
                "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validación: Los apellidos deben contener solo letras (incluyendo espacios y acentos)
        if (!nuevosApellidos.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            JOptionPane.showMessageDialog(view,
                "Los apellidos deben contener únicamente letras",
                "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Si todas las validaciones pasan, proceder con la modificación
        logic.modificarDatosProfesor(profesor, nuevoNombre, nuevosApellidos);
        JOptionPane.showMessageDialog(view,"Datos del profesor actualizados exitosamente","Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Actualizar la vista con los nuevos datos
            mostrarDetalleProfesor(profesor);
    }
    // Método para procesar y guardar el nuevo profesor
    private void guardarNuevoProfesor(AgregarProfesor agregarProfesor) {
        String cedula = agregarProfesor.getCedula().trim();
        String nombre = agregarProfesor.getNombre().trim();
        String apellido = agregarProfesor.getApellido().trim();
        Curso cursoSeleccionado = agregarProfesor.getCursoObjetoSeleccionado();

        // Validaciones
        if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            JOptionPane.showMessageDialog(agregarProfesor,
                    "Por favor, complete todos los campos obligatorios",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!cedula.matches("\\d+")) {
            JOptionPane.showMessageDialog(agregarProfesor,
                "La cédula debe contener únicamente números",
                "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validación: El nombre debe contener solo letras (incluyendo espacios y acentos)
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            JOptionPane.showMessageDialog(agregarProfesor,
                "El nombre debe contener únicamente letras",
                "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validación: El apellido debe contener solo letras (incluyendo espacios y acentos)
        if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            JOptionPane.showMessageDialog(agregarProfesor,
                "El apellido debe contener únicamente letras",
                "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cursoSeleccionado == null) {
            JOptionPane.showMessageDialog(agregarProfesor,
                    "Por favor, seleccione un curso",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Encontrar la escuela que contiene el curso seleccionado
        Escuela escuelaDelCurso = null;
        for (Escuela escuela : universidad.getVector()) {
            if (escuela.getCursos().contains(cursoSeleccionado)) {
                escuelaDelCurso = escuela;
                break;
            }
        }

        if (escuelaDelCurso == null) {
            JOptionPane.showMessageDialog(agregarProfesor,
                    "Error: No se encontró la escuela del curso seleccionado",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        // Intentar agregar el profesor usando la lógica existente
        // Parámetros: nombre, cedula, apellido1, apellido2, escuela, universidad
        String resultado = logic.agregarNuevoProfesor(nombre, cedula, apellido, escuelaDelCurso, universidad);

        if (resultado.contains("exitosamente")) {
            // Si se agregó correctamente, también asociarlo con el curso
            Profesor profesorRecienCreado = logic.buscarProfesor(cedula, universidad);
            if (profesorRecienCreado != null) {
                logic.agregarCursoProfesor(profesorRecienCreado, cursoSeleccionado);
            }

            JOptionPane.showMessageDialog(agregarProfesor, resultado,
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Limpiar el formulario
            agregarProfesor.limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(agregarProfesor, resultado,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        boolean datosActualizados = false;

        if(!nuevaDireccion.isEmpty()) {
            logic.actualizarDireccion(nuevaDireccion);
            datosActualizados = true;
        }

        if(!nuevoTelefono.isEmpty()) {
        	// Validar que el teléfono solo contenga números
            if(!nuevoTelefono.matches("^[0-9]+$")) {
                JOptionPane.showMessageDialog(optionsView, "El telefono solo debe contener numeros",
                    "Error de validacion", JOptionPane.ERROR_MESSAGE);
                return;
            }
            logic.actualizarTelefono(nuevoTelefono);
            datosActualizados = true;
        }

     // Solo mostrar mensaje de éxito si se actualizó algo
        if(datosActualizados) {
            JOptionPane.showMessageDialog(optionsView, "Datos de la universidad actualizados",
                "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(optionsView, "No se ingresaron datos para actualizar",
                "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void agregarEscuela(AgregarEscuela agregarEscuela) {
        String nombreEscuela = agregarEscuela.getTxtNombreEscuela().getText();
       //Verificar si el espacio esta vacio
        if(nombreEscuela.isEmpty()) {
            JOptionPane.showMessageDialog(agregarEscuela, "Por favor, ingrese el nombre de la escuela",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validar que el nombre solo contenga letras y espacios
        if(!nombreEscuela.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            JOptionPane.showMessageDialog(agregarEscuela, "El nombre de la escuela solo debe contener letras y espacios",
                "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Verificar si la escuela ya existe
        boolean escuelaExiste = false;
        for(Escuela escuela : universidad.getVector()) {
            if(escuela.getNombre().equalsIgnoreCase(nombreEscuela)) {
                escuelaExiste = true;
                break;
            }
        }
        
        if(escuelaExiste) {
            JOptionPane.showMessageDialog(agregarEscuela, "Esta escuela ya existe dentro de la universidad",
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
        cursoController = new ConsultarEscuelasController(logic, schoolsView, view);
    }

    public void startGUI() {
        view.setVisible(true);
    }
}