//This is the main(Launcher class) of this project
package onlineexam;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class OnlineExaminationSystem extends JFrame {
    private Map<String, String> userDatabase = new HashMap<>();
    private String currentUser;

    public OnlineExaminationSystem() {
        userDatabase.put("Sachin", "123");
        userDatabase.put("CodingLover", "Bunge@12345");
        userDatabase.put("Ashutosh", "Ashu@2004");

        setTitle("Online Examination System");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel userLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(userLabel, gbc);

        JTextField userField = new JTextField(15);
        gbc.gridx = 1;
        mainPanel.add(userField, gbc);

        JLabel passLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(passLabel, gbc);

        JPasswordField passField = new JPasswordField(15);
        gbc.gridx = 1;
        mainPanel.add(passField, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(loginButton, gbc);

        add(mainPanel, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
                    currentUser = username;
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    openDashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
                }
            }
        });

        setVisible(true);
    }

    private void openDashboard() {
        dispose();
        new Dashboard(currentUser);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OnlineExaminationSystem());
    }
}
