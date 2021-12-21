/* package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginGUI {
    private JTextField fieldUsername;
    private JPasswordField fieldPassword;

    public LoginGUI() {
        JFrame frame = new JFrame("Admin");
        frame.setSize(400, 250);
        frame.setResizable(false);

        JPanel panelUtama = new JPanel();
        frame.add(panelUtama);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        panelUtama.add(panel1);
        panelUtama.add(panel2);
        panelUtama.add(panel3);
        panelUtama.add(panel4);

        setFrameKeTengahLayar(frame);
        labelLogin(panel1);
        username(panel2);
        password(panel3);
        login(panel4);

        frame.setVisible(true);
    }

    public void setFrameKeTengahLayar(JFrame frame) {
        Dimension laptop = Toolkit.getDefaultToolkit().getScreenSize();
        int x = laptop.width/2 - frame.getWidth()/2;
        int y = laptop.height/2 - frame.getHeight()/2;
        frame.setLocation(x, y);
    }

    public void labelLogin(JPanel panel1) {
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel labelLogin = new JLabel("Login");
        Font font = new Font("Times New Roman", Font.BOLD, 50);
        labelLogin.setFont(font);

        panel1.add(labelLogin);
    }

    public void username(JPanel panel2) {
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel labelUsername = new JLabel("Username");
        Font font = new Font("Times New Roman", Font.BOLD, 16);
        labelUsername.setFont(font);

        fieldUsername = new JTextField(23);

        panel2.add(labelUsername);
        panel2.add(fieldUsername);
    }

    public void password(JPanel panel3) {
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel labelPassword = new JLabel("Password ");
        Font font = new Font("Times New Roman", Font.BOLD, 16);
        labelPassword.setFont(font);

        fieldPassword = new JPasswordField(23);

        panel3.add(labelPassword);
        panel3.add(fieldPassword);
    }

    public void login(JPanel panel4) {
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton buttonLogin = new JButton("Login");
        buttonLogin.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                SistemPecel sistemPecel = new SistemPecel();
                String user = "kelompok4";
                String pass = "kelompok4";

                if (fieldUsername.getText().equalsIgnoreCase(user) && fieldPassword.getText().equalsIgnoreCase(pass)) {
                    new SistemGUI(sistemPecel);
                }
                else {
                    JOptionPane.showMessageDialog(panel4, "Username Atau Password Salah!!",
                            "XXX", JOptionPane.WARNING_MESSAGE);

                    fieldUsername.setText("");
                    fieldPassword.setText("");
                    fieldUsername.requestFocus();
                }
            }
        });
        panel4.add(buttonLogin);
    }
} */
