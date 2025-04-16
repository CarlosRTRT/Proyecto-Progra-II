package init;

import control.*;
import views.*;

public class Main {
    public static void main(String[] args) {
        // Crear instancia de View (GUI).
        PrincipalMenu view = new PrincipalMenu();
        // Crear instancia de la Controller que recibe a View.
        Control controller = new Control(view);
        // Iniciar la GUI por medio de la controller.
        controller.startGUI();
    }
}