import javax.swing.*;
public class Myframe {
	JFrame k = new JFrame();
	public Myframe()
	{
		JFrame f = new JFrame("login page");
        f.setSize(400, 300);
        f.setLayout(null); // 🔥 Absolute Layout

        JLabel l1 = new JLabel("Username:");
        l1.setBounds(50, 100, 80, 25);
        f.add(l1);

        JTextField t1 = new JTextField("Ahmed");
        t1.setBounds(140, 100, 150, 25);
        f.add(t1);

        JLabel l2 = new JLabel("Password:");
        l2.setBounds(50, 140, 80, 25);
        f.add(l2);

        JPasswordField p1 = new JPasswordField("12345678345621");
        p1.setBounds(140, 140, 150, 25);
        f.add(p1);

        JCheckBox c1 = new JCheckBox("save password");
        c1.setBounds(140, 170, 150, 25);
        f.add(c1);

        JButton b1 = new JButton("login");
        b1.setBounds(140, 210, 100, 30);
        f.add(b1);

        String[] items = {"Admin", "User"};
        JComboBox<String> combo = new JComboBox<>(items);
        combo.setBounds(300, 100, 80, 25);
        f.add(combo);

        String[] listItems = {"Item1", "Item2", "Item3"};
        JList<String> list = new JList<>(listItems);
        list.setBounds(300, 140, 80, 60);
        f.add(list);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	}

}
