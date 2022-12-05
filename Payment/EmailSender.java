package Payment;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class EmailSender {
    private final String senderEmail = "TicketReservation480@outlook.com";
    private final String senderPassword = "FE-qQu-dqcbcPvi.3_gZ*ey";


    public boolean sendEmail(String targetEmail, String ticketInformation) {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "outlook.office365.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, senderPassword);
                    }
                });
        
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(targetEmail));
            message.setSubject("Your ticket information.");
            message.setText(ticketInformation);
            Transport.send(message);
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        EmailSender sender = new EmailSender();
        sender.sendEmail("akshiltawi@gmail.com", "Hi there :)");
    }

}
