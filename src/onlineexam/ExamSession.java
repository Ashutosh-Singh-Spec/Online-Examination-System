package onlineexam;
import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class ExamSession extends JFrame {
    private String username;
    private int timeLeft = 120;
    private Timer timer;
    private Map<String, String> userDatabase;

    public ExamSession(String username, Map<String, String> userDatabase) {
        this.username = username;
        this.userDatabase = userDatabase;

        setTitle("Exam Session - " + username);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel timerLabel = new JLabel("Time left: " + timeLeft + " seconds");
        topPanel.add(timerLabel);
        add(topPanel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel questionLabel1 = new JLabel("Which method is called to start a thread in Java?");
        JRadioButton option1_1 = new JRadioButton("Run");
        JRadioButton option1_2 = new JRadioButton("Execute");
        JRadioButton option1_3 = new JRadioButton("Start");

        ButtonGroup group1 = new ButtonGroup();
        group1.add(option1_1);
        group1.add(option1_2);
        group1.add(option1_3);

        JPanel questionPanel1 = new JPanel();
        questionPanel1.setLayout(new BoxLayout(questionPanel1, BoxLayout.Y_AXIS));
        questionPanel1.setBorder(BorderFactory.createTitledBorder("Question 1"));
        questionPanel1.add(questionLabel1);
        questionPanel1.add(option1_1);
        questionPanel1.add(option1_2);
        questionPanel1.add(option1_3);

        JLabel questionLabel2 = new JLabel("What is the default value of a boolean variable in Java?");
        JRadioButton option2_1 = new JRadioButton("True");
        JRadioButton option2_2 = new JRadioButton("False");
        JRadioButton option2_3 = new JRadioButton("Null");

        ButtonGroup group2 = new ButtonGroup();
        group2.add(option2_1);
        group2.add(option2_2);
        group2.add(option2_3);

        JPanel questionPanel2 = new JPanel();
        questionPanel2.setLayout(new BoxLayout(questionPanel2, BoxLayout.Y_AXIS));
        questionPanel2.setBorder(BorderFactory.createTitledBorder("Question 2"));
        questionPanel2.add(questionLabel2);
        questionPanel2.add(option2_1);
        questionPanel2.add(option2_2);
        questionPanel2.add(option2_3);

        JLabel questionLabel3 = new JLabel("Which keyword is used to inherit a class in Java?");
        JRadioButton option3_1 = new JRadioButton("super");
        JRadioButton option3_2 = new JRadioButton("this");
        JRadioButton option3_3 = new JRadioButton("extends");

        ButtonGroup group3 = new ButtonGroup();
        group3.add(option3_1);
        group3.add(option3_2);
        group3.add(option3_3);

        JPanel questionPanel3 = new JPanel();
        questionPanel3.setLayout(new BoxLayout(questionPanel3, BoxLayout.Y_AXIS));
        questionPanel3.setBorder(BorderFactory.createTitledBorder("Question 3"));
        questionPanel3.add(questionLabel3);
        questionPanel3.add(option3_1);
        questionPanel3.add(option3_2);
        questionPanel3.add(option3_3);

        JLabel questionLabel4 = new JLabel("Which package is automatically imported in every Java program?");
        JRadioButton option4_1 = new JRadioButton("java.util");
        JRadioButton option4_2 = new JRadioButton("java.lang");
        JRadioButton option4_3 = new JRadioButton("java.io");

        ButtonGroup group4 = new ButtonGroup();
        group4.add(option4_1);
        group4.add(option4_2);
        group4.add(option4_3);

        JPanel questionPanel4 = new JPanel();
        questionPanel4.setLayout(new BoxLayout(questionPanel4, BoxLayout.Y_AXIS));
        questionPanel4.setBorder(BorderFactory.createTitledBorder("Question 4"));
        questionPanel4.add(questionLabel4);
        questionPanel4.add(option4_1);
        questionPanel4.add(option4_2);
        questionPanel4.add(option4_3);

        mainPanel.add(questionPanel1);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(questionPanel2);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(questionPanel3);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(questionPanel4);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        add(mainPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        bottomPanel.add(submitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(e -> submitExam());
        startTimer(timerLabel);

        setVisible(true);
    }

    private void startTimer(JLabel timerLabel) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                timeLeft--;
                timerLabel.setText("Time left: " + timeLeft + " seconds");
                if (timeLeft <= 0) {
                    timer.cancel();
                    submitExam();
                }
            }
        }, 0, 1000);
    }

    private void submitExam() {
        timer.cancel();
        JOptionPane.showMessageDialog(null, "Exam submitted!");
        dispose();
        new Dashboard(username, userDatabase);
    }
}
