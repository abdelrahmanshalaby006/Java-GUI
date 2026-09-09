package calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Bhandling implements ActionListener {
    String op = "";
    double z = 0, y = 0, lastans = 0;
    Frame f;

    public Bhandling(Frame f1) {
        f = f1;
        JButton[] btns = {f.equal, f.mod, f.dot, f.reverse, f.delete, f.div, f.mul, f.plus, f.menis, f.b0, f.b1, f.b2, f.b3, f.b4, f.b5, f.b6, f.b7, f.b8, f.b9, f.ans};
        for(JButton b : btns) {
            b.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == f.b0) f.t.setText(f.t.getText() + "0");
            else if (e.getSource() == f.b1) f.t.setText(f.t.getText() + "1");
            else if (e.getSource() == f.b2) f.t.setText(f.t.getText() + "2");
            else if (e.getSource() == f.b3) f.t.setText(f.t.getText() + "3");
            else if (e.getSource() == f.b4) f.t.setText(f.t.getText() + "4");
            else if (e.getSource() == f.b5) f.t.setText(f.t.getText() + "5");
            else if (e.getSource() == f.b6) f.t.setText(f.t.getText() + "6");
            else if (e.getSource() == f.b7) f.t.setText(f.t.getText() + "7");
            else if (e.getSource() == f.b8) f.t.setText(f.t.getText() + "8");
            else if (e.getSource() == f.b9) f.t.setText(f.t.getText() + "9");
            
            else if (e.getSource() == f.ans) f.t.setText(String.valueOf(lastans));
            else if (e.getSource() == f.dot && !f.t.getText().contains(".")) f.t.setText(f.t.getText() + ".");
            else if (e.getSource() == f.delete) { f.t.setText(""); z = 0; y = 0; op = ""; f.l.setText(""); }
            else if (e.getSource() == f.reverse && !f.t.getText().isEmpty()) {
                f.t.setText(f.t.getText().substring(0, f.t.getText().length() - 1));
            }
            
            else if (e.getSource() == f.mod || e.getSource() == f.plus || e.getSource() == f.menis || e.getSource() == f.mul || e.getSource() == f.div) {
                if (!f.t.getText().isEmpty()) {
                    z = Double.parseDouble(f.t.getText());
                    f.t.setText("");
                    op = ((JButton)e.getSource()).getText();
                    f.l.setText(z + " " + op);
                }
            }
            
            else if (e.getSource() == f.equal && !f.t.getText().isEmpty() && !op.isEmpty()) {
                y = Double.parseDouble(f.t.getText());
                if (op.equals("+")) lastans = z + y;
                else if (op.equals("-")) lastans = z - y;
                else if (op.equals("x")) lastans = z * y;
                else if (op.equals("/")) lastans = z / y;
                else if (op.equals("%")) lastans = z % y;
                
                f.t.setText(String.valueOf(lastans));
                f.l.setText("");
                op = "";
            }
        } catch (Exception ex) {
            f.t.setText("Error");
        }
    }
}