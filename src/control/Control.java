package control;

import views.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.*;

public class Control {
	//Atributos de la clase.
	private View GUI;
	private Logic logic;
	
	//Constructor completo que recibe a View para obtener los getText de la GUI.
	public Control(View pGUI) {
		GUI = pGUI;
		crearUniversidad();
	}
	//Métodos respecto a la universidad
	public void crearUniversidad() {
		GUI.getButtonAgregar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Variables temporales para crear la clase.
				String nombre = GUI.getNombreView();
				String direccion = GUI.getDireccionView();
				String telefono = GUI.getTelefonoView();
				//
				Universidad u = new Universidad(nombre, direccion, telefono);
				
				//Crear la clase universidad con los inputs de View. (clase pasada por parámetros al constructor)
				logic = new Logic(u);
				agregarEscuela("EIF");
				mostrarEscuelas();
			}
		});
	}
	public void agregarEscuela(String pNombreEscuela) {
		logic.agregarEscuela(new Escuela(pNombreEscuela));
	}
	public void actualizarDireccion(String pDireccion) {
		logic.actualizarDireccion(pDireccion);
	}
	public void actualizarTelefono(String pTelefono) {
		logic.actualizarTelefono(pTelefono);
	}
	public void mostrarEscuelas() {
		System.out.println(logic.mostrarEscuelas());
	}
	//Métodos respecto a las escuelas
	
	//Iniciar la GUI a través de la controller.
	public void startGUI() {
		GUI.setVisible(true);
	}
}
