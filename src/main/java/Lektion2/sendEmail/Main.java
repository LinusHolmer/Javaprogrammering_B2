package Lektion2.sendEmail;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        EmailSend newEmail = new EmailSend("linus.holmer@stud.sti.se","2288Rust!");
        newEmail.sendEmail("linus.holmer@stud.sti.se","hej","hej");

        JTextField emailTextField = new JTextField(20);
        JTextField subjectTextField = new JTextField(20);
        JTextField messageTextField = new JTextField(20);

        JLabel emailLabel = new JLabel("Skicka till: ");
        JLabel subjectLabel = new JLabel("Ämne: ");
        JLabel messageLabel = new JLabel("Innehåll: ");

        JPanel emailPanel = new JPanel();

        emailPanel.add(emailLabel);
        emailPanel.add(emailTextField);
        emailPanel.add(Box.createHorizontalStrut(15));

        emailPanel.add(subjectLabel);
        emailPanel.add(subjectTextField);
        emailPanel.add(Box.createHorizontalStrut(15));

        emailPanel.add(messageLabel);
        emailPanel.add(messageTextField);

        int result = JOptionPane.showConfirmDialog(null, emailPanel,
                "Skicka mejl", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String mailAdress = emailTextField.getText();

            String subject = subjectTextField.getText();

            String message = messageTextField.getText();



            System.out.println("Skicka mejl till: " + mailAdress
                    + "\nÄmne: " + subject + "\nInnehåll: "+ message);

            emailTextField.setText("");
            subjectTextField.setText("");
            messageTextField.setText("");
        }

    }
}
