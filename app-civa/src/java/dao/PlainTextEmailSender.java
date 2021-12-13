/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PlainTextEmailSender {

    public void sendPlainTextEmail(String Host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message) throws AddressException,
            MessagingException {

        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.Host", Host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        properties.setProperty("mail.smtp.user", "meu login");   //setei o login
        properties.setProperty("mail.smtp.password", "minha senha"); // e a senha
        properties.put("mail.smtp.starttls.enable", "true"); //não sei ao certo para que serve, mas tive que colocar...
        properties.setProperty("mail.smtp.auth", "true");  //setei a autenticação
        String user = properties.getProperty("mail.smtp.user");
        String password2 = properties.getProperty("mail.smtp.password");

        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };

        Session session = Session.getInstance(properties, auth);

        // creates a new e-mail message
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        // set plain text message
        msg.setText(message);

        // sends the e-mail
        Transport.send(msg);

    }

    /**
     * Test the send e-mail method
     *
     * @param email
     * @param codigo
     */
    public static void main(String email, String codigo) {
        // SMTP server information
        String Host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "XXX";
        String password = "XXXXXX";

        // outgoing message information
        String mailTo = email;
        String subject = "Forsoft CIVA Recuperar Senha";
        String message = "Código recuperação: " + codigo;

        PlainTextEmailSender mailer = new PlainTextEmailSender();

        try {
            mailer.sendPlainTextEmail(Host, port, mailFrom, password, mailTo,
                    subject, message);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
            ex.printStackTrace();
        }
    }
}
