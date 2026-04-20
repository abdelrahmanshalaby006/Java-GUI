package MyPac;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;


public class Event extends JFrame{
    int y =20 , x = 420 ;
    JPanel p1;
    JTextField t1;
    JLabel l1 , l2 , l3; 
    JCheckBox c1 , c2 ;
    JRadioButton r1 , r2 ;
    JButton b1  , b4 ,b5 , b6 , b7 , b8 , b9 ;
    JButton b2 , b3;
    ButtonGroup g1 ;

    public Event()
    {
        InnerEvent obj =new InnerEvent();
        this.setSize(600, 400);
        this.setLocation(50, 50);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 600, 400);
        this.add(p1);
        p1.setBackground(Color.CYAN);
        //===========================
        t1 = new JTextField();
        t1.setBounds(20, 20, 130, 30);
        p1.add(t1);
        //===========================
        b1 = new JButton("copy");
        b1.setBounds(260, 25, 60, 20);
        p1.add(b1);
        //===========================
        l1 = new JLabel();
        l1.setBounds(x, y, 130, 30);
        p1.add(l1);
        l1.setFont(new Font("Arial",Font.PLAIN,30));

        //===========================
        r1 = new JRadioButton("enable");
        r1.setBounds(20, 90, 70, 30);
        p1.add(r1);
        //=======
        r2 = new JRadioButton("disable");
        r2.setBounds(120, 90, 70, 30);
        p1.add(r2);
        g1 = new ButtonGroup();
        g1.add(r1);g1.add(r2);
        //============================
        c1 = new JCheckBox("Bold");
        c1.setBounds(20, 200, 60, 20);
        c1.setBackground(Color.CYAN);
        c2 = new JCheckBox("italic");
        c2.setBounds(130, 200, 60, 20);
        c2.setBackground(Color.CYAN);
        p1.add(c1);p1.add(c2);
        //=============================
        b2 = new JButton("");
        b2.setBounds(20, 270, 60, 25);
        b2.setBackground(Color.gray);
        l2 = new JLabel("gray");
        l2.setBounds(30, 300, 60, 25);
        p1.add(b2);p1.add(l2);
        //=========
        b3 = new JButton("");
        b3.setBounds(120, 270, 80, 25);
        b3.setBackground(Color.lightGray);
        l3 = new JLabel("lightGray");
        l3.setBounds(130, 300, 60, 25);
        p1.add(b3);p1.add(l3);
        //=======   
        b4 = new JButton("Save");
        b4.setBounds(230, 320, 100, 40);
        b4.setBackground(Color.white);
        p1.add(b4);
        //======= 
        b9 = new JButton("Clear");
        b9.setBounds(250, 270, 80, 25);
        p1.add(b9);
        //===============================
        
        b5 = new JButton("\u2191"); 
        b5.setBackground(Color.CYAN);
        b6 = new JButton("\u2193"); 
        b6.setBackground(Color.CYAN);
        b7 = new JButton("\u2190"); 
        b7.setBackground(Color.CYAN);
        b8 = new JButton("\u2192"); 
        b8.setBackground(Color.CYAN);
        b5.setBorderPainted(false);
        b6.setBorderPainted(false);
        b7.setBorderPainted(false);
        b8.setBorderPainted(false);

        b5.setBounds(500, 260, 50, 30); // Up
        b6.setBounds(500, 320, 50, 30); // Down
        b7.setBounds(450, 290, 50, 30); // Left
        b8.setBounds(550, 290, 50, 30); // Right

        p1.add(b5);
        p1.add(b6);
        p1.add(b7);
        p1.add(b8);
        b1.addActionListener(obj);
        r1.addItemListener(obj);
        r2.addItemListener(obj);
        c1.addItemListener(obj);
        c2.addItemListener(obj);
        b2.addActionListener(obj);
        b3.addActionListener(obj);
        b4.addActionListener(obj);
        b5.addActionListener(obj);
        b6.addActionListener(obj);
        b7.addActionListener(obj);
        b8.addActionListener(obj);
        b9.addActionListener(obj) ;
        this.addKeyListener(obj);
        this.setFocusable(true);
        
        this.setVisible(true);
        this.requestFocusInWindow();

    }

    public static void main(String[] args) {
        Event e = new Event();
        

    }
    public class InnerEvent implements ActionListener , ItemListener  , KeyListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        String s1 ;
        if(e.getSource()==b1)
        {
            s1=t1.getText().toString();
            l1.setText(s1);
        }
        if(e.getSource()==b2)
        {
            p1.setBackground(Color.gray);
            l1.setForeground(Color.white);
        }
        if(e.getSource()==b3)
        {
            p1.setBackground(Color.lightGray);
            l1.setForeground(Color.white);
        }
        if(e.getSource()==b5)
        {
            y-=5;
            l1.setBounds(x, y, 130, 30);
        }
        if(e.getSource()==b6)
        {
            y+=5;
            l1.setBounds(x, y, 130, 30);
        }
        if(e.getSource()==b7)
        {
            x-=5;
            l1.setBounds(x, y, 130, 30);
        }
        if(e.getSource()==b8)
        {
            x+=5;
            l1.setBounds(x, y, 130, 30);
        }
        if(e.getSource()==b9)
        {
            p1.setBackground(Color.CYAN);
            l1.setForeground(Color.BLACK);
            l1.setBounds(420, 20, 130, 30);
            l1.setFont(new Font("Arial",Font.PLAIN,30));
        }
        if(e.getSource()==b4)
        {
            new SecondFrame();   
        }

        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(r1.isSelected())
            {
                t1.setEnabled(true);
            }
            if(r2.isSelected())
            {
                t1.setEnabled(false);
            }
            if (c1.isSelected() && c2.isSelected()) {
                l1.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, y));
            }
            else if (c1.isSelected()) {
                l1.setFont(new Font("Arial", Font.BOLD, y));
            }
            else if (c2.isSelected()) {
                l1.setFont(new Font("Arial", Font.ITALIC, y ));
            }
            else {
                l1.setFont(new Font("Arial", Font.PLAIN, y));
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        switch (k) {
            case KeyEvent.VK_UP:
                y+=5;
                break;
                case KeyEvent.VK_DOWN:
                y-=5;
                break;
                case KeyEvent.VK_RIGHT:
                x+=5;
                break;
                case KeyEvent.VK_LEFT:
                x-=5;
                break;  
        }
        l1.setBounds(x, y, 130, 30);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        
        
    }
}