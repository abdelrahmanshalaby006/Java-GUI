package MyPac;

import javax.swing.*;
import java.awt.*;

public class SecondFrame extends JDialog {
    private JButton okBtn;
    private JLabel messageLabel;

    public SecondFrame(JFrame parentFrame) {
        super(parentFrame, "Save Status", true);
        setSize(300, 150);
        setLocationRelativeTo(parentFrame);
        setLayout(new BorderLayout());
        setResizable(false);

        messageLabel = new JLabel("Saved Successfully!", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(messageLabel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        okBtn = new JButton("OK");
        okBtn.setPreferredSize(new Dimension(80, 30));
        okBtn.addActionListener(e -> dispose());
        bottomPanel.add(okBtn);
        
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}