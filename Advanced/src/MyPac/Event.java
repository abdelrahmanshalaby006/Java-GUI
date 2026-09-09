package MyPac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Event extends JFrame {
    private static final int MOVEMENT_SPEED = 5;
    private static final int DEFAULT_TEXT_X = 350;
    private static final int DEFAULT_TEXT_Y = 25;
    private final Color DEFAULT_BG = new Color(230, 240, 250);

    private int textX = DEFAULT_TEXT_X;
    private int textY = DEFAULT_TEXT_Y;
    
    private JPanel mainPanel;
    private JTextField inputField;
    private JLabel displayLabel, grayLabel, lightGrayLabel;
    private JCheckBox boldCheck, italicCheck;
    private JRadioButton enableRadio, disableRadio;
    private JButton copyBtn, saveBtn, upBtn, downBtn, leftBtn, rightBtn, clearBtn, grayBtn, lightGrayBtn;
    private ButtonGroup radioGroup;

    public Event() {
        setTitle("Text Formatter & Mover");
        setSize(600, 420);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        setupListeners();
        
        setFocusable(true);
        requestFocusInWindow();
    }

    private void initComponents() {
        mainPanel = new JPanel(null);
        mainPanel.setBackground(DEFAULT_BG);
        setContentPane(mainPanel);

        inputField = new JTextField();
        inputField.setBounds(25, 25, 180, 35);
        mainPanel.add(inputField);

        copyBtn = new JButton("Copy");
        copyBtn.setBounds(215, 25, 80, 35);
        mainPanel.add(copyBtn);

        displayLabel = new JLabel();
        displayLabel.setBounds(textX, textY, 200, 50);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        mainPanel.add(displayLabel);

        enableRadio = new JRadioButton("Enable", true);
        enableRadio.setBounds(25, 80, 80, 30);
        enableRadio.setBackground(DEFAULT_BG);
        
        disableRadio = new JRadioButton("Disable");
        disableRadio.setBounds(115, 80, 80, 30);
        disableRadio.setBackground(DEFAULT_BG);
        
        radioGroup = new ButtonGroup();
        radioGroup.add(enableRadio);
        radioGroup.add(disableRadio);
        mainPanel.add(enableRadio);
        mainPanel.add(disableRadio);

        boldCheck = new JCheckBox("Bold");
        boldCheck.setBounds(25, 125, 80, 30);
        boldCheck.setBackground(DEFAULT_BG);
        
        italicCheck = new JCheckBox("Italic");
        italicCheck.setBounds(115, 125, 80, 30);
        italicCheck.setBackground(DEFAULT_BG);
        mainPanel.add(boldCheck);
        mainPanel.add(italicCheck);

        grayBtn = new JButton();
        grayBtn.setBounds(25, 180, 40, 30);
        grayBtn.setBackground(Color.GRAY);
        grayLabel = new JLabel("Gray");
        grayLabel.setBounds(75, 180, 60, 30);
        mainPanel.add(grayBtn);
        mainPanel.add(grayLabel);

        lightGrayBtn = new JButton();
        lightGrayBtn.setBounds(145, 180, 40, 30);
        lightGrayBtn.setBackground(Color.LIGHT_GRAY);
        lightGrayLabel = new JLabel("Light Gray");
        lightGrayLabel.setBounds(195, 180, 80, 30);
        mainPanel.add(lightGrayBtn);
        mainPanel.add(lightGrayLabel);

        saveBtn = new JButton("Save");
        saveBtn.setBounds(25, 240, 100, 40);
        saveBtn.setBackground(Color.WHITE);
        mainPanel.add(saveBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(135, 240, 100, 40);
        clearBtn.setBackground(Color.WHITE);
        mainPanel.add(clearBtn);

        upBtn = new JButton("\u2191");
        downBtn = new JButton("\u2193");
        leftBtn = new JButton("\u2190");
        rightBtn = new JButton("\u2192");
        
        upBtn.setBounds(470, 250, 50, 40);
        leftBtn.setBounds(415, 295, 50, 40);
        downBtn.setBounds(470, 295, 50, 40);
        rightBtn.setBounds(525, 295, 50, 40);
        
        JButton[] arrows = {upBtn, downBtn, leftBtn, rightBtn};
        for (JButton btn : arrows) {
            btn.setBackground(DEFAULT_BG);
            btn.setFocusable(false);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            mainPanel.add(btn);
        }
    }

    private void setupListeners() {
        copyBtn.addActionListener(e -> {
            displayLabel.setText(inputField.getText());
            requestFocusInWindow();
        });
        
        grayBtn.addActionListener(e -> updateTheme(Color.GRAY, Color.WHITE));
        lightGrayBtn.addActionListener(e -> updateTheme(Color.LIGHT_GRAY, Color.BLACK));
        
        clearBtn.addActionListener(e -> resetApplication());
        
        saveBtn.addActionListener(e -> new SecondFrame(this));

        upBtn.addActionListener(e -> moveLabel(0, -MOVEMENT_SPEED));
        downBtn.addActionListener(e -> moveLabel(0, MOVEMENT_SPEED));
        leftBtn.addActionListener(e -> moveLabel(-MOVEMENT_SPEED, 0));
        rightBtn.addActionListener(e -> moveLabel(MOVEMENT_SPEED, 0));

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
                    case KeyEvent.VK_UP: moveLabel(0, -MOVEMENT_SPEED); break;
                    case KeyEvent.VK_DOWN: moveLabel(0, MOVEMENT_SPEED); break;
                    case KeyEvent.VK_LEFT: moveLabel(-MOVEMENT_SPEED, 0); break;
                    case KeyEvent.VK_RIGHT: moveLabel(MOVEMENT_SPEED, 0); break;
                }
            }
        });
    }

    private void moveLabel(int dx, int dy) {
        textX += dx;
        textY += dy;
        
        textX = Math.max(0, Math.min(textX, getWidth() - displayLabel.getWidth() - 20));
        textY = Math.max(0, Math.min(textY, getHeight() - displayLabel.getHeight() - 40));
        
        displayLabel.setLocation(textX, textY);
    }

    private void updateFont() {
        int style = Font.PLAIN;
        if (boldCheck.isSelected()) style |= Font.BOLD;
        if (italicCheck.isSelected()) style |= Font.ITALIC;
        displayLabel.setFont(new Font("Arial", style, 30));
    }

    private void updateTheme(Color bgColor, Color fgColor) {
        mainPanel.setBackground(bgColor);
        displayLabel.setForeground(fgColor);
        
        Component[] components = {enableRadio, disableRadio, boldCheck, italicCheck, upBtn, downBtn, leftBtn, rightBtn};
        for (Component comp : components) {
            comp.setBackground(bgColor);
            comp.setForeground(fgColor);
        }
        requestFocusInWindow();
    }

    private void resetApplication() {
        updateTheme(DEFAULT_BG, Color.BLACK);
        textX = DEFAULT_TEXT_X;
        textY = DEFAULT_TEXT_Y;
        displayLabel.setLocation(textX, textY);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        
        boldCheck.setSelected(false);
        italicCheck.setSelected(false);
        enableRadio.setSelected(true);
        inputField.setEnabled(true);
        inputField.setText("");
        displayLabel.setText("");
        
        requestFocusInWindow();
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