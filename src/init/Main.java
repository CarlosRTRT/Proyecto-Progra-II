package init;	

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import control.*;
import views.*;
import views.MenuPrincipal.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // Crear instancia de View (GUI).
        MenuPrincipal pMenu = new MenuPrincipal();
        VentanaPrincipal universityView = new VentanaPrincipal(pMenu);
        Controller controller = new Controller(universityView, pMenu);
        // Iniciar la GUI por medio de la controller.
        controller.startGUI();
    }
}