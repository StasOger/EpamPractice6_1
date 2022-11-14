package service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.MessagingException;


public class EmailService {



    public void sendEmail(String email, String message){
//        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
//
//        Properties prop = new Properties();
//        prop.put("mail.smtp.host", "smtp.mail.ru");
//        prop.put("mail.smtp.port", "465");
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.socketFactory.port", "465");
//        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//
//        final String username = "stas.oger.99@mail.ru";//
//        final String password = "Stanislau19stas";
////        Session session = Session.getDefaultInstance(properties); // default session
//
//        try {
//            Session session = Session.getDefaultInstance(prop,
//                    new Authenticator(){
//                        protected PasswordAuthentication getPasswordAuthentication() {
//                            return new PasswordAuthentication(username, password);
//                        }});
//            MimeMessage mimeMessage = new MimeMessage(session); // email message
//            mimeMessage.setFrom(new InternetAddress(username)); // setting header fields
//            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
//            mimeMessage.setSubject("Test Mail from Java Program"); // subject line
//            mimeMessage.setText(message);
//            // Send message
//            Transport.send(mimeMessage);
//            System.out.println("Email Sent successfully....");
//        } catch (MessagingException mex){
//            mex.printStackTrace();
//        }
//    }


    //        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
//
//        Properties prop = new Properties();
//        prop.put("mail.smtp.host", "smtp.mail.ru");
//        prop.put("mail.smtp.port", "465");
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.socketFactory.port", "465");
//        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//
//        final String username = "stas.oger.99@mail.ru";//
//        final String password = "Stanislau19stas";
////        Session session = Session.getDefaultInstance(properties); // default session
//
//        try {
//            Session session = Session.getDefaultInstance(prop,
//                    new Authenticator(){
//                        protected PasswordAuthentication getPasswordAuthentication() {
//                            return new PasswordAuthentication(username, password);
//                        }});
//            MimeMessage mimeMessage = new MimeMessage(session); // email message
//            mimeMessage.setFrom(new InternetAddress(username)); // setting header fields
//            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("stas.oger.99@mail.ru"));
//            mimeMessage.setSubject("Test Mail from Java Program"); // subject line
//            mimeMessage.setText("228");
//            // Send message
//            Transport.send(mimeMessage);
//            System.out.println("Email Sent successfully....");
//        } catch (MessagingException mex){
//            mex.printStackTrace();
//        }

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
            }
}
