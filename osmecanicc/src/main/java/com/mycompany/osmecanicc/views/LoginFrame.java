
package com.mycompany.osmecanicc.views;

import javax.swing.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel userLabel = new JLabel("Usuário:");
        JTextField userField = new JTextField(15);
        JLabel passLabel = new JLabel("Senha:");
        JPasswordField passField = new JPasswordField(15);
        JButton loginButton = new JButton("Entrar");

        loginButton.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if (user.equals("admin") && pass.equals("admin")) {
                new MenuPrincipalFrame().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(loginButton);
        add(panel);
    }
}
