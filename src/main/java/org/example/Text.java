package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Text {
    public static void main(String[] args) {
        System.out.println("preparing to send message.....");
        String message="Hello Dear, this is message for security";
        String subject="CoderArea:Confirmation";
        String to="2ke19cs104@kleit.ac.in";
        String from="mathadawar01@gmail.com";
        sendMail(message,subject,to,from);
    }
    static void sendMail(String message,String subject,String to,String from){
        String host="smtp.gmail.com";
        Properties properties=System.getProperties();
//        System.out.println("PROPERTIES "+ properties);
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("mathadawar01@gmail.com","*****");
            }
        });
        session.setDebug(true);
        MimeMessage m=new MimeMessage(session);
        try{
            m.setFrom(from);
            m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            m.setSubject(subject);
            m.setText(message);
            Transport.send(m);
            System.out.println("Sent success..............");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
