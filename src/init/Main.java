package init;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import control.*;
import views.*;

public class Main {
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // Crear instancia de View (GUI).
        PrincipalMenu view = new PrincipalMenu();
        // Crear instancia de la Controller que recibe a View.
        Control controller = new Control(view);
        // Iniciar la GUI por medio de la controller.
        controller.startGUI();
    }
}