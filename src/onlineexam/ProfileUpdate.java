package onlineexam;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ProfileUpdate extends JFrame {
    private String username;
    private String updatedUsername;
    private Map<String, String> userDatabase;

    public ProfileUpdate(String username, Map<String, String> userDatabase) {
        this.username = username;
        this.updatedUsername = username;
        this.userDatabase = userDatabase;

        setTitle("Update Profile - " + username);
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        JLabel nameLabel = new JLabel("New Username:");
        JTextField nameField = new JTextField(username);
        JButton updateButton = new JButton("Update");

        add(nameLabel);
        add(nameField);
        add(new JLabel());
        add(updateButton);

        updateButton.addActionListener(e -> {
            String newUsername = nameField.getText();
            if (!newUsername.isEmpty() && !newUsername.equals(username)) {
                String currentPassword = userDatabase.get(username);
                userDatabase.remove(username);
                userDatabase.put(newUsername, currentPassword);
                updatedUsername = newUsername;
                JOptionPane.showMessageDialog(null, "Profile updated successfully!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a valid username.");
            }
        });

        setVisible(true);
    }

    public String getUpdatedUsername() {
        return updatedUsername;
    }
}
