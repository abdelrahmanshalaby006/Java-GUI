package calculator;
import java.awt.*;
import javax.swing.*;

public class Frame {
    JFrame f1;
    JPanel p1, topPanel;
    JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,plus,menis,mul,div,reverse,equal,dot,mod,ans,delete;
    JTextField t;
    JLabel l;

    Frame() {
        f1 = new JFrame("Calculator");
        f1.setSize(320, 480);
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            ImageIcon img = new ImageIcon("D:\\calculator\\src\\calculator\\icon.jpg.jpg");
            f1.setIconImage(img.getImage());
        } catch (Exception ignored) {}

        t = new JTextField();
        t.setFont(new Font("Arial", Font.BOLD, 28));
        t.setHorizontalAlignment(JTextField.RIGHT);
        t.setEditable(false); 

        l = new JLabel(" ");
        l.setFont(new Font("Arial", Font.PLAIN, 15));
        l.setHorizontalAlignment(SwingConstants.RIGHT);

        topPanel = new JPanel(new BorderLayout());
        topPanel.add(l, BorderLayout.NORTH);
        topPanel.add(t, BorderLayout.CENTER);

        p1 = new JPanel(new GridLayout(5, 4, 5, 5)); 
        p1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        delete = new JButton("C"); ans = new JButton("An"); reverse = new JButton("←"); div = new JButton("/");
        b7 = new JButton("7"); b8 = new JButton("8"); b9 = new JButton("9"); mul = new JButton("x");
        b4 = new JButton("4"); b5 = new JButton("5"); b6 = new JButton("6"); menis = new JButton("-");
        b1 = new JButton("1"); b2 = new JButton("2"); b3 = new JButton("3"); plus = new JButton("+");
        mod = new JButton("%"); b0 = new JButton("0"); dot = new JButton("."); equal = new JButton("=");

        JButton[] btns = {delete, ans, reverse, div, b7, b8, b9, mul, b4, b5, b6, menis, b1, b2, b3, plus, mod, b0, dot, equal};
        for(JButton b : btns) {
            b.setFont(new Font("Arial", Font.BOLD, 18));
            p1.add(b);
        }

        f1.setLayout(new BorderLayout());
        f1.add(topPanel, BorderLayout.NORTH);
        f1.add(p1, BorderLayout.CENTER);
        f1.setVisible(true);
    }
}