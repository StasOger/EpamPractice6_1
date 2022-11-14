import service.BookService;

import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.internet.*;
import javax.swing.JOptionPane;



public class MainApp {

    public static void main(String[] args) {
        BookService bookService = new BookService();
        bookService.run();

//        String username = "noname.justpath@gmail.com";
//        String password = "Dean_Winchester_jut_1";
//
//        Properties props = new Properties();
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "465");
//
//        Session session = Session.getDefaultInstance(props,
//                new javax.mail.Authenticator() {
//            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
//                return new javax.mail.PasswordAuthentication(username, password);
//            }
//        });
//        session.setDebug(true);
//            try {
//                Message message = new MimeMessage(session);
//                //от кого
//                message.setFrom(new InternetAddress("noname.justpath@gmail.com"));
//                //кому
//                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("stas.oger.99@yandex.by"));
//                //тема сообщения
//                message.setSubject("test mail");
//                //текст
//                message.setText("im gay");
//                //отправляем сообщение
//                javax.mail.Transport.send(message);
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
    }
}

