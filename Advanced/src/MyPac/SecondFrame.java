package MyPac;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class SecondFrame extends JFrame {
    JButton b1 ;
    JLabel l1;
    InnerEvent2 i = new InnerEvent2();
    public SecondFrame() {
        this.setSize(300, 200);
        this.setLocation(700, 200);
        this.setLayout(null);
        this.isResizable();
        b1 = new JButton("OK");
        b1.setBounds(100, 120, 70, 20);
        this.add(b1);
        l1 = new JLabel("Saved Successfully");
        l1.setBounds(80, 40, 150, 30);
        add(l1);
        b1.addActionListener(i);

        setVisible(true);
    }
    public class InnerEvent2 implements ActionListener 
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b1)
            {
                dispose();
            }
        }
        
    }
}