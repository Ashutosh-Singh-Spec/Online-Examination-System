package onlineexam;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ChangePassword extends JFrame {
    private String username;
    private Map<String, String> userDatabase;

    public ChangePassword(String username) {
        this.username = username;
        this.userDatabase = userDatabase;

        setTitle("Change Password - " + username);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        JLabel oldPassLabel = new JLabel("Old Password:");
        JPasswordField oldPassField = new JPasswordField();
        JLabel newPassLabel = new JLabel("New Password:");
        JPasswordField newPassField = new JPasswordField();
        JButton updateButton = new JButton("Update");

        add(oldPassLabel);
        add(oldPassField);
        add(newPassLabel);
        add(newPassField);
        add(new JLabel());
        add(updateButton);

        updateButton.addActionListener(e -> {
            String oldPassword = new String(oldPassField.getPassword());
            String newPassword = new String(newPassField.getPassword());

            if (userDatabase.get(username).equals(oldPassword)) {
                userDatabase.put(username, newPassword);
                JOptionPane.showMessageDialog(null, "Password changed successfully!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Old password is incorrect.");
            }
        });

        setVisible(true);
    }
}
