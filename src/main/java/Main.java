
import javax.swing.*;

/**
 * Created by Вадим on 08.04.2016.
 */
public class Main {
    public static void main(String[] args) {
        Settings.getSettings();
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            new jFrame();
        });

    }
}