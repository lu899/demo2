import java.awt.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        RegisterDAO registerDAO = new RegisterDAO();

        JFrame mainFrame = new JFrame();
        mainFrame.setSize(new Dimension(400, 400));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel mainLabel = new JLabel("Registration Form");
        mainLabel.setFont(new Font("Courier New", Font.BOLD, 24));
        mainLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setMinimumSize(new Dimension(250, 200));
        detailsPanel.setMaximumSize(new Dimension(250, 200));
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nameLabel = new JLabel("Enter Full Names:");
        nameLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField name = new JTextField(20);
        Dimension fixedSize = new Dimension(name.getPreferredSize().width, 30);
        name.setMinimumSize(fixedSize);
        name.setMaximumSize(fixedSize);
        name.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel emailLabel = new JLabel("Enter Your Email:");
        emailLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
        emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField email = new JTextField(20);
        email.setMinimumSize(fixedSize);
        email.setMaximumSize(fixedSize);
        email.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel passwordLabel = new JLabel("Enter Your Password:");
        passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
        emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPasswordField password = new JPasswordField(20);
        password.setMinimumSize(fixedSize);
        password.setMaximumSize(fixedSize);
        password.setAlignmentX(Component.LEFT_ALIGNMENT);

        RoundedButton registerBtn = new RoundedButton("Register", 15);
        registerBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerBtn.setBackground(new Color(41, 74, 102));
        registerBtn.setForeground(Color.WHITE);
        registerBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        registerBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerBtn.addActionListener(e -> {
            registerDAO.addUser(name.getText(), email.getText(), password.getPassword().toString());
            JOptionPane.showMessageDialog(null, "User Registered Successfully!!");
        });

        detailsPanel.add(nameLabel);
        detailsPanel.add(name);
        detailsPanel.add(Box.createVerticalStrut(15));
        detailsPanel.add(emailLabel);
        detailsPanel.add(email);
        detailsPanel.add(Box.createVerticalStrut(15));
        detailsPanel.add(passwordLabel);
        detailsPanel.add(password);

        mainPanel.add(mainLabel);
        mainPanel.add(Box.createVerticalStrut(25));
        mainPanel.add(detailsPanel);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(registerBtn);

        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
    }
}
