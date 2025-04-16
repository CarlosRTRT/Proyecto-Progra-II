package control;

import views.PrincipalMenu;
import views.Options;
import views.SchoolsView;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.*;
import java.util.ArrayList;

public class Control {
    // Atributos de la clase.
    private PrincipalMenu principalGUI;
    private Options optionsGUI;
    private SchoolsView escuelasGUI;
    private Logic logic;
    private boolean universidadCreada = false;
    
    // Constructor completo que recibe a View para obtener los getText de la GUI.
    public Control(PrincipalMenu pGUI) {
        principalGUI = pGUI;
        optionsGUI = new Options();
        escuelasGUI = new SchoolsView();
        configurarBotones();
    }
    
    private void configurarBotones() {
        // Boton para crear universidad y abrir ventana de opciones
        principalGUI.getButtonAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearUniversidad();
            }
        });
        
        // Configurar botones de la ventana Options
        configurarBotonesOptions();
        
        // Configurar botones de la ventana EscuelasView
        configurarBotonesEscuelasView();
    }
    
    private void configurarBotonesOptions() {
        // Boton para actualizar datos de la universidad
        optionsGUI.getBtnModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDatosUniversidad();
            }
        });
        
        // Boton para agregar escuela
        optionsGUI.getBtnAgregarEscuela().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEscuelaDesdeUI();
            }
        });
        
        // Boton para consultar escuelas
        optionsGUI.getBtnConsultarEscuelas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaEscuelas();
            }
        });
    }
    
    private void configurarBotonesEscuelasView() {
        // Boton para agregar escuela desde la vista de escuelas
        escuelasGUI.getBtnAgregarEscuela().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEscuelaDesdeEscuelasView();
            }
        });
        
        // Boton para volver al menu de opciones
        escuelasGUI.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                escuelasGUI.setVisible(false);
                optionsGUI.setVisible(true);
            }
        });
        
        // Boton para gestionar cursos EN PROGRESO AUN
        escuelasGUI.getBtnGestionarCursos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(escuelasGUI, 
                    "Funcionalidad en desarrollo.", 
                    "Gestión de Cursos", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
    
    // Metodo para crear la universidad
    private void crearUniversidad() {
        // Variables temporales para crear la clase.
        String nombre = principalGUI.getNombreView().trim();
        String direccion = principalGUI.getDireccionView().trim();
        String telefono = principalGUI.getTelefonoView().trim();
        
        // Validar que se ingresaron los datos
        if (nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(principalGUI, 
                "Por favor complete todos los campos", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Crear universidad
        Universidad u = new Universidad(nombre, direccion, telefono);
        logic = new Logic(u);
        universidadCreada = true;
        
        // mensaje de exito y abrir ventana de opciones
        JOptionPane.showMessageDialog(principalGUI, 
            "Universidad creada exitosamente", 
            "Exito", JOptionPane.INFORMATION_MESSAGE);
        
        // Ocultar ventana principal y mostrar opciones
        principalGUI.setVisible(false);
        optionsGUI.setVisible(true);
    }
    
    // Metodo para actualizar datos de la universidad
    private void actualizarDatosUniversidad() {
        if (!universidadCreada) {
            JOptionPane.showMessageDialog(optionsGUI, 
                "No hay universidad creada", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String direccion = optionsGUI.getTxtDireccion().getText().trim();
        String telefono = optionsGUI.getTxtTelefono().getText().trim();
        
        if (!direccion.isEmpty()) {
            logic.actualizarDireccion(direccion);
        }
        
        if (!telefono.isEmpty()) {
            logic.actualizarTelefono(telefono);
        }
        
        if (!direccion.isEmpty() || !telefono.isEmpty()) {
            JOptionPane.showMessageDialog(optionsGUI, 
                "Datos actualizados correctamente", 
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(optionsGUI, 
                "No se ingresaron datos para actualizar", 
                "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    // Metodo para agregar escuela desde la interfaz de Options
    private void agregarEscuelaDesdeUI() {
        if (!universidadCreada) {
            JOptionPane.showMessageDialog(optionsGUI, 
                "No hay universidad creada", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String nombreEscuela = optionsGUI.getTxtNombreEscuela().getText().trim();
        
        if (nombreEscuela.isEmpty()) {
            JOptionPane.showMessageDialog(optionsGUI, 
                "Ingrese el nombre de la escuela", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        agregarEscuela(nombreEscuela);
        
        JOptionPane.showMessageDialog(optionsGUI, 
            "Escuela agregada correctamente", 
            "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        // Limpiar campo despues de agregar
        optionsGUI.getTxtNombreEscuela().setText("");
    }
    
    // Metodo para agregar escuela desde la vista de escuelas
    private void agregarEscuelaDesdeEscuelasView() {
        String nombreEscuela = escuelasGUI.getTxtNombreEscuela().getText().trim();
        
        if (nombreEscuela.isEmpty()) {
            JOptionPane.showMessageDialog(escuelasGUI, 
                "Ingrese el nombre de la escuela", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        agregarEscuela(nombreEscuela);
        
        JOptionPane.showMessageDialog(escuelasGUI, 
            "Escuela agregada correctamente", 
            "Exito", JOptionPane.INFORMATION_MESSAGE);
        
        // Limpiar campo despues de agregar
        escuelasGUI.getTxtNombreEscuela().setText("");
        
        // Actualizar la vista de escuelas
        actualizarVistaEscuelas();
    }
    
    // Metodo para agregar escuela a la universidad
    public void agregarEscuela(String pNombreEscuela) {
        logic.agregarEscuela(new Escuela(pNombreEscuela));
    }
    
    // Metodo para actualizar direccion de la universidad
    public void actualizarDireccion(String pDireccion) {
        logic.actualizarDireccion(pDireccion);
    }
    
    // Metodo para actualizar tele	fono de la universidad
    public void actualizarTelefono(String pTelefono) {
        logic.actualizarTelefono(pTelefono);
    }
    
    // Metodo para mostrar escuelas en un dialogo
    public void mostrarEscuelas() {
        if (!universidadCreada) {
            JOptionPane.showMessageDialog(optionsGUI, 
                "No hay universidad creada", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ArrayList<Escuela> escuelas = logic.getUniversidad().getVector();
        
        if (escuelas.isEmpty()) {
            JOptionPane.showMessageDialog(optionsGUI, 
                "No hay escuelas registradas", 
                "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String listaEscuelas = logic.mostrarEscuelas();
            JOptionPane.showMessageDialog(optionsGUI, 
                listaEscuelas, 
                "Lista de Escuelas", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    // Metodo para mostrar la ventana de escuelas
    private void mostrarVentanaEscuelas() {
        if (!universidadCreada) {
            JOptionPane.showMessageDialog(optionsGUI, 
                "No hay universidad creada", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Actualizar la informacion de escuelas en la vista
        actualizarVistaEscuelas();
        
        // Ocultar opciones y mostrar vista de escuelas
        optionsGUI.setVisible(false);
        escuelasGUI.setVisible(true);
    }
    
    // Metodo para actualizar la vista de escuelas
    private void actualizarVistaEscuelas() {
        ArrayList<Escuela> escuelas = logic.getUniversidad().getVector();
        
        // Actualizar el área de texto
        String texto = "Universidad: " + logic.getUniversidad().getNombreU() + "\n";
        texto += "Direccion: " + logic.getUniversidad().getDireccionU() + "\n";
        texto += "Telefono: " + logic.getUniversidad().getTelefonoU() + "\n\n";
        texto += "LISTA DE ESCUELAS:\n";
        texto += "-------------------\n";
        
        if (escuelas.isEmpty()) {
            texto += "No hay escuelas registradas.";
        } else {
            for (int i = 0; i < escuelas.size(); i++) {
                texto += (i+1) + ". " + escuelas.get(i).getNombre() + 
                         " (Cursos: " + escuelas.get(i).getVector().size() + ")\n";
            }
        }
        
        escuelasGUI.getAreaEscuelas().setText(texto);
        
        // Actualizar la tabla
        String[] nombres = new String[escuelas.size()];
        int[] cantidadCursos = new int[escuelas.size()];
        
        for (int i = 0; i < escuelas.size(); i++) {
            nombres[i] = escuelas.get(i).getNombre();
            cantidadCursos[i] = escuelas.get(i).getVector().size();
        }
        
        escuelasGUI.actualizarTablaEscuelas(nombres, cantidadCursos);
    }
    
    // Iniciar la GUI a traves del controlador
    public void startGUI() {
        principalGUI.setVisible(true);
    }
}