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
        MenuPrincipal pMenu = new MenuPrincipal();
        AgregarUniversidad universityView = new AgregarUniversidad(pMenu);
        Control controller = new Control(universityView, pMenu);
        // Iniciar la GUI por medio de la controller.
        controller.startGUI();
    }
}