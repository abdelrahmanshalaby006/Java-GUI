import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Myframe extends JFrame {

    public Myframe() {
        setTitle("System Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 350);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "User Authentication", 
                TitledBorder.LEFT, TitledBorder.TOP, 
                new Font("Arial", Font.BOLD, 14), new Color(0, 51, 102)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        JTextField usernameField = new JTextField(15);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 12));
        JPasswordField passwordField = new JPasswordField(15);
        
        JCheckBox savePasswordCheckBox = new JCheckBox("Remember Me");
        savePasswordCheckBox.setFont(new Font("Arial", Font.PLAIN, 12));
        
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        String[] roles = {"Admin", "Standard User", "Guest"};
        JComboBox<String> roleComboBox = new JComboBox<>(roles);
        roleComboBox.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel deptLabel = new JLabel("Select Department:");
        deptLabel.setFont(new Font("Arial", Font.BOLD, 12));
        
        String[] departments = {"IT Department", "HR Department", "Finance"};
        JList<String> itemList = new JList<>(departments);
        itemList.setFont(new Font("Arial", Font.PLAIN, 12));
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemList.setSelectedIndex(0); 
        
        JScrollPane listScrollPane = new JScrollPane(itemList);
        listScrollPane.setPreferredSize(new Dimension(130, 60));

        gbc.gridx = 0; gbc.gridy = 0;
        mainPanel.add(usernameLabel, gbc);
        
        gbc.gridx = 1; gbc.gridy = 0;
        mainPanel.add(usernameField, gbc);
        
        gbc.gridx = 2; gbc.gridy = 0;
        mainPanel.add(roleComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        mainPanel.add(passwordLabel, gbc);
        
        gbc.gridx = 1; gbc.gridy = 1;
        mainPanel.add(passwordField, gbc);

        gbc.gridx = 2; gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 0, 10);
        mainPanel.add(deptLabel, gbc);

        gbc.gridx = 2; gbc.gridy = 2; gbc.gridheight = 2;
        gbc.insets = new Insets(5, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(listScrollPane, gbc);

        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 1; gbc.gridy = 2;
        mainPanel.add(savePasswordCheckBox, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        mainPanel.add(loginButton, gbc);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {}
            
            new Myframe().setVisible(true);
        });
    }
}