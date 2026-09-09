package calculator;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class calc1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {}
            
            Frame a = new Frame();
            Bhandling b = new Bhandling(a);
            new Khandling(a, b);
        });
    }
}