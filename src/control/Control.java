package control;

import views.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.*;

public class Control {
	//Atributos de la clase.
	private View GUI;
	private Universidad universidad;
	private Escuela departamento;
	
	//Constructor completo que recibe a View para obtener los getText de la GUI.
	public Control(View pGUI) {
		GUI = pGUI;
		crearUniversidad();
	}
	
	//Métodos
	public void crearUniversidad() {
		GUI.getButtonAgregar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Variables temporales para crear la clase.
				String nombre = GUI.getNombreView();
				String direccion = GUI.getDireccionView();
				String telefono = GUI.getTelefonoView();
				departamento = new Escuela("EIF-Informática"); //Se debe de cambiar por un input de la View.
				
				//Crear la clase universidad con los inputs de View. (clase pasada por parámetros al constructor)
				
				//Sin el input de la View queda así, por ahora...
				universidad = new Universidad(nombre, direccion, telefono, departamento);
				
				//Verificación de dicha clase creada usando outputs en consola.
				System.out.println("Nombre de la universidad: " + universidad.getNombreU() + "\n" +
								   "Dirección de la universidad: " + universidad.getDireccionU() + "\n" +
								   "Teléfono de la universidad: " + universidad.getTelefonoU() + "\n" +
								   "Escuelas de la universidad: " + universidad.vectorToString());
			}
		});
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
