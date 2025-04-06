package control;

import views.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import models.*;

public class Control {
	//Atributos de la clase.
	private View GUI;
	private Universidad universidad;
	//Vector de escuelas y la clase escuela no se maneja en la clase Universidad
	//según dice explícitamente el PDF. (No me quedó claro esta parte)
	private Escuela departamento;
	private ArrayList <Escuela> departamentos;
	
	//Constructor completo que recibe a View para obtener los getText de la GUI.
	public Control(View pGUI) {
		GUI = pGUI;
		crearUniversidad();
	}
	//Método que incluye el listener al botón de agregar en la interfaz.
	public void crearUniversidad() {
		GUI.getButtonAgregar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Variables temporales para crear la clase.
				String nombre = GUI.getNombreView();
				String direccion = GUI.getDireccionView();
				String telefono = GUI.getTelefonoView();
				//Crear la clase universidad con los inputs de View. (clase pasada por parámetros al constructor)
				universidad = new Universidad(nombre, direccion, telefono);
				//Verificación de dicha clase creada usando outputs en consola.
				System.out.println("Nombre universidad: " + universidad.getNombreU());
				System.out.println("Dirección universidad: " + universidad.getDireccionU());
				System.out.println("Teléfono universidad: " + universidad.getTelefonoU());
			}
		});
	}
	
	//Not sure about this, se debe evaluar de nuevo la implementación de las escuelas.(Quedé confundido).
	public void agregarEscuelas(String pNombreEscuela) {
		departamento = new Escuela(pNombreEscuela);
		departamentos.add(departamento);
	}
	public void cambiarTelefono(String pTelefono) {
		universidad.setTelefonoU(pTelefono);
	}
	public void cambiarDireccion(String pDireccion) {
		universidad.setDireccionU(pDireccion);
	}
	//Iniciar la GUI a través de la controller.
	public void startGUI() {
		GUI.setVisible(true);
	}
}
