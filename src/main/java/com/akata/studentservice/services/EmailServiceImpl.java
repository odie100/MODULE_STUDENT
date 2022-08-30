package com.akata.studentservice.services;

import com.akata.studentservice.model.EmailModel;
import com.akata.studentservice.services.interfaces.EmailService;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public boolean send(EmailModel emailModel) {
       /* String username = "andriampeno.odilon@gmail.com";
        String password = "kicktqhgqelnnnir";

        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(emailModel.getFrom()));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailModel.getTo()));
            msg.setSubject(emailModel.getSubject());
            msg.setContent(emailModel.getText() , "text/html");
            msg.setSentDate(new Date());

            Transport.send(msg);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }*/
        return true;
    }
}
