package calculator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Khandling extends KeyAdapter {
    String op = "";
    double z = 0, y = 0,lastans=0;
    Frame k;
    Bhandling b;
    public Khandling(Frame f1,Bhandling b1) {
        k = f1;
        b=b1;
        k.t.addKeyListener(this);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
         String text = k.t.getText();
        if (Character.isLetter(c)) {
            e.consume();}
      else if (Character.isDigit(c)) {
            k.t.setText(text) ;}
      else if(text.contains(".")){e.consume();}
    }
    @Override
    public void keyPressed(KeyEvent e) {
        String text = k.t.getText();
        if (e.getKeyCode() == KeyEvent.VK_DELETE) {
            k.t.setText("");
            z = 0;
            y = 0;
            op = "";
        }
        else if (e.getKeyCode() == KeyEvent.VK_ADD || e.isShiftDown() && e.getKeyCode()==KeyEvent.VK_EQUALS ) {z = Double.parseDouble(text);
            k.t.setText("");
            op = "+";
            k.l.setText(op);}
        else if (e.getKeyCode() == KeyEvent.VK_MINUS || e.getKeyCode() == KeyEvent.VK_SUBTRACT) { z = Double.parseDouble(text);
            k.t.setText("");
            op = "-";
            k.l.setText(op);}
        else if (e.getKeyCode() == KeyEvent.VK_MULTIPLY) {z = Double.parseDouble(text);
            k.t.setText("");
            op = "*";
            k.l.setText(op);}
        else if (e.getKeyCode() == KeyEvent.VK_DIVIDE || e.getKeyCode() == KeyEvent.VK_SLASH) {z = Double.parseDouble(text);
            k.t.setText("");
            op = "/";
            k.l.setText(op);}

        else if (e.getKeyCode()== KeyEvent.VK_BACK_SLASH){k.t.setText(String.valueOf(b.lastans));}

        else if (e.getKeyCode() == KeyEvent.VK_EQUALS || e.getKeyCode() == KeyEvent.VK_ENTER) {
//k.t.setText("I Love You<3");
            y = Double.parseDouble(text.substring(1));
            if (op.equals("+")) {
                b.lastans = z + y;
                k.t.setText(z+" + "+y+" = "+ b.lastans);} 
            else if (op.equals("-")) {
                b.lastans = z - y;
                k.t.setText(z+" - "+y+" = "+ b.lastans);}
            else if (op.equals("*")) {
                b.lastans = z * y;
                k.t.setText(z+" x "+y+ " = " + b.lastans);} 
            else if (op.equals("/")) {
                b.lastans = z / y;
                k.t.setText(z+" / "+y+" = "+ (z/y));} 
            else if (op.equals("%")) {
                b.lastans = z /100;
                k.t.setText(z + " % " +" = " + b.lastans);}
        }
        else if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_5) {
            if (!text.isEmpty()) {
                z = Double.parseDouble(text);
                k.t.setText("");
                op = "%";
                k.l.setText(op);
            }
        }
    }
}
