import javax.mail.*;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import javax.mail.Authenticator;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by Вадим on 10.04.2016.
 */
public class SendMail {
        static final String ENCODING = "UTF-8";

    static void Send(ArrayList<DAO> list) throws MessagingException, UnsupportedEncodingException {
        DAO dao;
        for(DAO alist : list){
            dao = alist;
            String subject = jFrame.getThemeText();
            String content = "Привет, " + dao.getName() + "\n" + jFrame.getMessageText();
            String smtpHost = Settings.getSmtpHost();
            String addressFrom = Settings.getAddressFrom();
            String addressTo = dao.getMail();
            String login = Settings.getLogin();
            String password = Settings.getPassword();
            String smtpPort = Settings.getSmtpPort();
            //System.out.println(login+ " "+password +" "+ addressFrom+" " + addressTo+" " + content+" " + subject+" " + smtpPort+ " "+smtpHost);
            sendMessage(login, password, addressFrom, addressTo, content, subject, smtpPort, smtpHost);
        }
    }

    public static void sendMessage(String login, String password, String from, String to, String content, String subject, String smtpPort, String smtpHost)
            throws MessagingException, UnsupportedEncodingException {
        Authenticator auth = new MyAuthenticator(login, password);

        Properties props = System.getProperties();
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.auth", "true");
        props.put("mail.mime.charset", ENCODING);
        Session session = Session.getDefaultInstance(props,auth);

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(from));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        msg.setSubject(subject);
        msg.setText(content);
        Transport.send(msg);
    }
}

class MyAuthenticator extends Authenticator {
    private String user;
    private String password;

    MyAuthenticator(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public PasswordAuthentication getPasswordAuthentication() {
        String user = this.user;
        String password = this.password;
        return new PasswordAuthentication(user, password);
    }
}
