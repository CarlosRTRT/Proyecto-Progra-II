package init;

import control.*;
import views.*;

public class Main {
	public static void main(String[] args) {
		//Crear instancia de View (GUI).
		View view = new View();
		//Crear instancia de la Controller que recibe a View.
		Control controller = new Control(view);
		//Iniciar la GUI por medio de la controller.
		controller.startGUI();
	}
}
