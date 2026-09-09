package MyPac;

import javax.swing.*;

public class SecondFrame extends JFrame {
    private JButton okBtn;
    private JLabel messageLabel;

    public SecondFrame() {
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        okBtn = new JButton("OK");
        okBtn.setBounds(100, 110, 80, 30);
        add(okBtn);

        messageLabel = new JLabel("Saved Successfully", SwingConstants.CENTER);
        messageLabel.setBounds(0, 40, 300, 30);
        add(messageLabel);

        okBtn.addActionListener(e -> dispose());

        setVisible(true);
    }
}