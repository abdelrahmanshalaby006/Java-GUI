import javax.swing.*;
import java.awt.*;

public class Myframe extends JFrame {

    public Myframe() {
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15); 
        
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);
        
        JCheckBox savePasswordCheckBox = new JCheckBox("Save Password");
        JButton loginButton = new JButton("Login");

        String[] roles = {"Admin", "User"};
        JComboBox<String> roleComboBox = new JComboBox<>(roles);

        String[] listItems = {"Item 1", "Item 2", "Item 3"};
        JList<String> itemList = new JList<>(listItems);
        JScrollPane listScrollPane = new JScrollPane(itemList);
        listScrollPane.setPreferredSize(new Dimension(80, 60));

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
        
        gbc.gridx = 2; gbc.gridy = 1; gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(listScrollPane, gbc);

        gbc.gridx = 1; gbc.gridy = 2; gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(savePasswordCheckBox, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        mainPanel.add(loginButton, gbc);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            new Myframe().setVisible(true);
        });
    }
}