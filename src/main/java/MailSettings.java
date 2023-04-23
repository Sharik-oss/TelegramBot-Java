import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class MailSettings {
    public static void main(String to, String text, String subject){//String to, String text, String subject
        String from = "itsupport@crocobet.com";//change accordingly

        String signature = text + "<br><br>" + "<table data-ogsb=\"rgb(255, 255, 255)\" style=\"font-size:medium; font-family:calibri; height:189px\"><tbody><tr><td><img data-imagetype=\"External\" src=\"https://promotions.crocobet.com/outlooksignature/logo.png\" style=\"margin:0px; width:8rem; height:8rem\"></td><td style=\"margin-left:10px\"><p data-ogsc=\"rgb(21, 175, 68)\" style=\"margin:0px; color:rgb(86,220,109)!important; font-weight:bolder\">Service Monitoring Team</p><p data-ogsc=\"rgb(128, 128, 128)\" style=\"margin:0px 0px 20px; color:rgb(180,180,180)!important; font-weight:bolder\">Operation</p><div style=\"margin:15px 0px 0px; font-size:11pt; display:flex\"><p data-ogsc=\"rgb(128, 128, 128)\" style=\"margin:0px; color:rgb(180,180,180)!important; font-weight:100\">+995 577 68 65 19&nbsp;</p><p data-ogsc=\"rgb(128, 128, 128)\" style=\"margin:0px; color:rgb(180,180,180)!important; font-weight:100\">itsupport@crocobet.com</p></div></td><td><img data-imagetype=\"External\" src=\"https://promotions.crocobet.com/outlooksignature/pattern.png\" style=\"margin:0px\"></td></tr><tr><td><a href=\"https://www.crocobet.com/\" target=\"_blank\" rel=\"noopener noreferrer\" data-auth=\"NotApplicable\" data-safelink=\"true\" data-linkindex=\"0\" style=\"margin:0px; font-weight:bolder; font-size:11pt; color:rgb(32,190,68)\">www.crocobet.com</a></td><td><p data-ogsc=\"rgb(128, 128, 128)\" style=\"margin:auto 0px 0px; color:rgb(180,180,180)!important; font-weight:100; font-size:8pt\"><span style=\"margin:0px\"><img data-imagetype=\"External\" src=\"https://promotions.crocobet.com/outlooksignature/dot.png\" style=\"margin:0px 0px 2px; height:5px; width:5px\"><span style=\"margin:0px\">&nbsp;</span></span>support@crocobet.com<span style=\"margin:0px\">&nbsp;</span><img data-imagetype=\"External\" src=\"https://promotions.crocobet.com/outlooksignature/dot.png\" style=\"margin:0px 0px 2px; padding:0px 0px 0px 5px; height:5px; width:5px\"><span style=\"margin:0px\">&nbsp;</span>(032) 259 77 77</p></td><td style=\"padding-left:30px\"><p data-ogsc=\"rgb(128, 128, 128)\" style=\"margin:0px; color:rgb(180,180,180)!important; font-weight:100\"><a href=\"https://www.instagram.com/crocobet_com/\" target=\"_blank\" rel=\"noopener noreferrer\" data-auth=\"NotApplicable\" data-safelink=\"true\" data-ogsc=\"\" data-linkindex=\"1\" style=\"margin:0px; color:rgb(228,159,255)!important\"><img data-imagetype=\"External\" src=\"https://promotions.crocobet.com/outlooksignature/insta-icon.png\" style=\"margin:0px\"></a><span style=\"margin:0px\">&nbsp;</span>&nbsp;<span style=\"margin:0px\">&nbsp;</span><a href=\"https://www.linkedin.com/company/crocobet/mycompany/?viewAsMember=true\" target=\"_blank\" rel=\"noopener noreferrer\" data-auth=\"NotApplicable\" data-safelink=\"true\" data-ogsc=\"\" data-linkindex=\"2\" style=\"margin:0px; color:rgb(228,159,255)!important\"><img data-imagetype=\"External\" src=\"https://promotions.crocobet.com/outlooksignature/linkedin-icon.png\" style=\"margin:0px\"></a><span style=\"margin:0px\">&nbsp;</span>&nbsp;<span style=\"margin:0px\">&nbsp;</span><a href=\"https://www.facebook.com/crocobet\" target=\"_blank\" rel=\"noopener noreferrer\" data-auth=\"NotApplicable\" data-safelink=\"true\" data-ogsc=\"\" data-linkindex=\"3\" style=\"margin:0px; color:rgb(228,159,255)!important\"><img data-imagetype=\"External\" src=\"https://promotions.crocobet.com/outlooksignature/FB-icon.png\" style=\"margin:0px\"></a></p></td></tr></tbody></table>";

        //Get the session object
        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", "smtp.office365.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        final Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("itsupport@crocobet.com", "Orakaia@2021");
            }
        });

        //compose the message
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, to);
//            message.setRecipients(Message.RecipientType.CC, "aphutkaradze@crocobet.com");
            message.setSubject(subject, "utf-8");

            message.setContent(signature, "text/html; charset=utf-8");

            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");

        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
