package dao;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static org.apache.tomcat.jni.User.username;

public class JavaMailApp {

    public static void main(String email, String codigo) {
        Properties props = new Properties();
        String mailUsuario = "xxx@gmail.com";
        String mailSenha = "XXXXX";
        String mailPortaSMTP = "587";
        String mailHost = "smtp.gmail.com";
        //String mailHost = "smtp.googlemail.com";

        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", mailHost);
        props.put("mail.smtp.port", mailPortaSMTP);
        props.put("mail.smtp.socketFactory.port", mailPortaSMTP);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.ssl.trust", mailHost);
        props.put("mail.smtp.auth", true);
        props.put("mail.debug", true);
        props.put("java.net.preferIPv4Stack", true);

        /**
         * Parâmetros de conexão com servidor Gmail
         */
        //props.setProperty("mail.smtp.host", "smtp.gmail.com");
        //props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        //props.setProperty("mail.smtp.port", "587");
        //props.setProperty("mail.smtp.socketFactory.port", "587");
        //props.put("mail.smtp.auth", "true");
        //props.put("mail.debug", "true");
        //props.put("mail.store.protocol", "pop3");
        props.put("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.ssl.enable", "true");
        //props.put("mail.transport.protocol", "smtps");
        //props.setProperty("mail.smtp.port", "8088");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("civa.forsoft.suporte@gmail.com",
                        "suporteciva2021A@");
            }
        });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);
        System.err.println("Entrou!!!");

        try {

            System.err.println("Entrou no try!!!");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("civa.forsoft.suporte@gmail.com"));
            //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(email);

            System.err.println("Destinatario: " + email);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Forsoft CIVA Códico Para Mudar Senha");//Assunto
            message.setText("Código de Recuperação: " + codigo);
            /**
             * Método para enviar a mensagem criada
             */
            System.err.println("message: " + message);

            // Transport.send(message, toUser);
            try {
                Transport transport;
                transport = session.getTransport();
                transport.connect(mailHost, mailUsuario, mailSenha);
                transport.sendMessage(message, message.getAllRecipients());
                      System.err.println("Feito!!!");
            } catch (MessagingException e) {
                    System.err.println("Nao Feito!!!: " + e.getMessage());
            }
              
            
      

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
