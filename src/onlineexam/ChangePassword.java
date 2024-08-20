package onlineexam;
import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ChangePassword extends JFrame {
    private String username;
    private Map<String, String> userDatabase;

    public ChangePassword(String username, Map<String, String> userDatabase) {
        this.username = username;
        this.userDatabase = userDatabase;

        setTitle("Change Password - " + username);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel currentPasswordLabel = new JLabel("Current Password:");
        JPasswordField currentPasswordField = new JPasswordField();

        JLabel newPasswordLabel = new JLabel("New Password:");
        JPasswordField newPasswordField = new JPasswordField();

        JLabel confirmPasswordLabel = new JLabel("Confirm New Password:");
        JPasswordField confirmPasswordField = new JPasswordField();

        panel.add(currentPasswordLabel);
        panel.add(currentPasswordField);
        panel.add(newPasswordLabel);
        panel.add(newPasswordField);
        panel.add(confirmPasswordLabel);
        panel.add(confirmPasswordField);

        JButton changePasswordButton = new JButton("Change Password");
        changePasswordButton.addActionListener(e -> {
            String currentPassword = new String(currentPasswordField.getPassword());
            String newPassword = new String(newPasswordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            String storedPassword = userDatabase.get(username);
            if (storedPassword == null) {
                JOptionPane.showMessageDialog(this, "User does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!storedPassword.equals(currentPassword)) {
                JOptionPane.showMessageDialog(this, "Current password is incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!newPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "New passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Update the password in the database
                userDatabase.put(username, newPassword);
                JOptionPane.showMessageDialog(this, "Password changed successfully!");
                dispose();
                new Dashboard(username, userDatabase);
            }
        });

        add(panel, BorderLayout.CENTER);
        add(changePasswordButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}
