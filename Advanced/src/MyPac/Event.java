package MyPac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Event extends JFrame {
    private int textY = 20, textX = 420;
    private JPanel mainPanel;
    private JTextField inputField;
    private JLabel displayLabel, grayLabel, lightGrayLabel;
    private JCheckBox boldCheck, italicCheck;
    private JRadioButton enableRadio, disableRadio;
    private JButton copyBtn, saveBtn, upBtn, downBtn, leftBtn, rightBtn, clearBtn, grayBtn, lightGrayBtn;
    private ButtonGroup radioGroup;

    public Event() {
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.CYAN);
        setContentPane(mainPanel);

        inputField = new JTextField();
        inputField.setBounds(20, 20, 130, 30);
        mainPanel.add(inputField);

        copyBtn = new JButton("Copy");
        copyBtn.setBounds(260, 25, 70, 25);
        mainPanel.add(copyBtn);

        displayLabel = new JLabel();
        displayLabel.setBounds(textX, textY, 150, 40);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        mainPanel.add(displayLabel);

        enableRadio = new JRadioButton("Enable");
        enableRadio.setBounds(20, 90, 80, 30);
        enableRadio.setBackground(Color.CYAN);
        
        disableRadio = new JRadioButton("Disable");
        disableRadio.setBounds(110, 90, 80, 30);
        disableRadio.setBackground(Color.CYAN);
        
        radioGroup = new ButtonGroup();
        radioGroup.add(enableRadio);
        radioGroup.add(disableRadio);
        mainPanel.add(enableRadio);
        mainPanel.add(disableRadio);

        boldCheck = new JCheckBox("Bold");
        boldCheck.setBounds(20, 200, 60, 20);
        boldCheck.setBackground(Color.CYAN);
        
        italicCheck = new JCheckBox("Italic");
        italicCheck.setBounds(130, 200, 60, 20);
        italicCheck.setBackground(Color.CYAN);
        mainPanel.add(boldCheck);
        mainPanel.add(italicCheck);

        grayBtn = new JButton("");
        grayBtn.setBounds(20, 270, 60, 25);
        grayBtn.setBackground(Color.gray);
        grayLabel = new JLabel("Gray");
        grayLabel.setBounds(30, 300, 60, 25);
        mainPanel.add(grayBtn);
        mainPanel.add(grayLabel);

        lightGrayBtn = new JButton("");
        lightGrayBtn.setBounds(120, 270, 80, 25);
        lightGrayBtn.setBackground(Color.lightGray);
        lightGrayLabel = new JLabel("LightGray");
        lightGrayLabel.setBounds(130, 300, 80, 25);
        mainPanel.add(lightGrayBtn);
        mainPanel.add(lightGrayLabel);

        saveBtn = new JButton("Save");
        saveBtn.setBounds(230, 320, 100, 40);
        saveBtn.setBackground(Color.white);
        mainPanel.add(saveBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(250, 270, 80, 25);
        mainPanel.add(clearBtn);

        upBtn = new JButton("\u2191");
        downBtn = new JButton("\u2193");
        leftBtn = new JButton("\u2190");
        rightBtn = new JButton("\u2192");
        
        upBtn.setBounds(500, 260, 50, 30);
        downBtn.setBounds(500, 320, 50, 30);
        leftBtn.setBounds(450, 290, 50, 30);
        rightBtn.setBounds(550, 290, 50, 30);
        
        JButton[] arrows = {upBtn, downBtn, leftBtn, rightBtn};
        for (JButton btn : arrows) {
            btn.setBackground(Color.CYAN);
            btn.setFocusable(false);
            mainPanel.add(btn);
        }

        setupListeners();
        setFocusable(true);
        requestFocusInWindow();
    }

    private void setupListeners() {
        copyBtn.addActionListener(e -> displayLabel.setText(inputField.getText()));
        
        grayBtn.addActionListener(e -> {
            mainPanel.setBackground(Color.gray);
            displayLabel.setForeground(Color.white);
            updateComponentsBackground(Color.gray);
        });
        
        lightGrayBtn.addActionListener(e -> {
            mainPanel.setBackground(Color.lightGray);
            displayLabel.setForeground(Color.white);
            updateComponentsBackground(Color.lightGray);
        });
        
        clearBtn.addActionListener(e -> {
            mainPanel.setBackground(Color.CYAN);
            displayLabel.setForeground(Color.BLACK);
            textX = 420;
            textY = 20;
            displayLabel.setLocation(textX, textY);
            displayLabel.setFont(new Font("Arial", Font.PLAIN, 30));
            updateComponentsBackground(Color.CYAN);
            boldCheck.setSelected(false);
            italicCheck.setSelected(false);
            radioGroup.clearSelection();
            inputField.setEnabled(true);
            inputField.setText("");
            displayLabel.setText("");
        });
        
        saveBtn.addActionListener(e -> new SecondFrame());

        upBtn.addActionListener(e -> moveLabel(0, -5));
        downBtn.addActionListener(e -> moveLabel(0, 5));
        leftBtn.addActionListener(e -> moveLabel(-5, 0));
        rightBtn.addActionListener(e -> moveLabel(5, 0));

        ItemListener radioListener = e -> inputField.setEnabled(enableRadio.isSelected());
        enableRadio.addItemListener(radioListener);
        disableRadio.addItemListener(radioListener);

        ItemListener fontListener = e -> updateFont();
        boldCheck.addItemListener(fontListener);
        italicCheck.addItemListener(fontListener);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP: moveLabel(0, -5); break;
                    case KeyEvent.VK_DOWN: moveLabel(0, 5); break;
                    case KeyEvent.VK_LEFT: moveLabel(-5, 0); break;
                    case KeyEvent.VK_RIGHT: moveLabel(5, 0); break;
                }
            }
        });
    }

    private void moveLabel(int dx, int dy) {
        textX += dx;
        textY += dy;
        displayLabel.setLocation(textX, textY);
    }

    private void updateFont() {
        int style = Font.PLAIN;
        if (boldCheck.isSelected() && italicCheck.isSelected()) {
            style = Font.BOLD | Font.ITALIC;
        } else if (boldCheck.isSelected()) {
            style = Font.BOLD;
        } else if (italicCheck.isSelected()) {
            style = Font.ITALIC;
        }
        displayLabel.setFont(new Font("Arial", style, 30));
    }

    private void updateComponentsBackground(Color color) {
        enableRadio.setBackground(color);
        disableRadio.setBackground(color);
        boldCheck.setBackground(color);
        italicCheck.setBackground(color);
        upBtn.setBackground(color);
        downBtn.setBackground(color);
        leftBtn.setBackground(color);
        rightBtn.setBackground(color);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new Event().setVisible(true);
        });
    }
}