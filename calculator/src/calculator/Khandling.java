package calculator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Khandling extends KeyAdapter {
    Frame k;
    Bhandling b;

    public Khandling(Frame f1, Bhandling b1) {
        k = f1;
        b = b1;
        k.f1.setFocusable(true); 
        k.f1.addKeyListener(this);
        k.t.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        char c = e.getKeyChar();

        if (code == KeyEvent.VK_DELETE || code == KeyEvent.VK_ESCAPE) k.delete.doClick();
        else if (code == KeyEvent.VK_BACK_SPACE) k.reverse.doClick();
        else if (code == KeyEvent.VK_ENTER || c == '=') k.equal.doClick();
        else if (c == '+') k.plus.doClick();
        else if (c == '-') k.menis.doClick();
        else if (c == '*' || c == 'x') k.mul.doClick();
        else if (c == '/') k.div.doClick();
        else if (c == '%') k.mod.doClick();
        
        else if (c == '0') k.b0.doClick();
        else if (c == '1') k.b1.doClick();
        else if (c == '2') k.b2.doClick();
        else if (c == '3') k.b3.doClick();
        else if (c == '4') k.b4.doClick();
        else if (c == '5') k.b5.doClick();
        else if (c == '6') k.b6.doClick();
        else if (c == '7') k.b7.doClick();
        else if (c == '8') k.b8.doClick();
        else if (c == '9') k.b9.doClick();
        else if (c == '.') k.dot.doClick();
    }
}