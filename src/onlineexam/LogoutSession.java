//logoutsession.java
package onlineexam;
import javax.swing.*;
public class LogoutSession extends JFrame {

    public LogoutSession() {
        int confirmLogout = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (confirmLogout == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "You have successfully logged out.");
            System.exit(0);
        } else {
            new OnlineExaminationSystem();
        }
    }
}
