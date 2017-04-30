package util;

import com.sun.mail.smtp.SMTPTransport;
import java.security.Security;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * ref: http://stackoverflow.com/questions/3649014/send-email-using-java
 * @author NathanKun
 *
 */
public class SendMail {
	private SendMail() {
	}

	/**
	 * Send email using SMTP server.
	 *
	 * @param username
	 *            GMail username
	 * @param password
	 *            GMail password
	 * @param recipientEmail
	 *            TO recipient
	 * @param title
	 *            title of the message
	 * @param message
	 *            message to be sent
	 * @throws AddressException
	 *             if the email address parse failed
	 * @throws MessagingException
	 *             if the connection is dead or not in the connected state or if
	 *             the message is not a MimeMessage
	 */
	private static void Send(final String username, final String password, String recipientEmail, String title,
			String message) throws AddressException, MessagingException {
		SendMail.Send(username, password, recipientEmail, "", title, message);
	}

	/**
	 * Send email using SMTP server.
	 *
	 * @param username
	 *            GMail username
	 * @param password
	 *            GMail password
	 * @param recipientEmail
	 *            TO recipient
	 * @param ccEmail
	 *            CC recipient. Can be empty if there is no CC recipient
	 * @param title
	 *            title of the message
	 * @param message
	 *            message to be sent
	 * @throws AddressException
	 *             if the email address parse failed
	 * @throws MessagingException
	 *             if the connection is dead or not in the connected state or if
	 *             the message is not a MimeMessage
	 */
	private static void Send(final String username, final String password, String recipientEmail, String ccEmail,
			String title, String message) throws AddressException, MessagingException {
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

		// Get a Properties object
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.auth", "true");  // need to authenticate
		// SSL
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		
		props.setProperty("mail.smtps.host", "mail.catprogrammer.com");
		props.setProperty("mail.smtp.port", "465");

		/*
		 * If set to false, the QUIT command is sent and the connection is
		 * immediately closed. If set to true (the default), causes the
		 * transport to wait for the response to the QUIT command.
		 * 
		 * ref :
		 * http://java.sun.com/products/javamail/javadocs/com/sun/mail/smtp/
		 * package-summary.html
		 * http://forum.java.sun.com/thread.jspa?threadID=5205249 smtpsend.java
		 * - demo program from javamail
		 */
		props.put("mail.smtps.quitwait", "true");

		Session session = Session.getInstance(props, null);

		// -- Create a new message --
		final MimeMessage msg = new MimeMessage(session);

		// -- Set the FROM and TO fields --
		msg.setFrom(new InternetAddress(username + "@catprogrammer.com"));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail, false));

		if (ccEmail.length() > 0) {
			msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail, false));
		}

		msg.setSubject(title);
		msg.setText(message, "utf-8");
		msg.setSentDate(new Date());

		SMTPTransport t = (SMTPTransport) session.getTransport("smtps");

		t.connect("mail.catprogrammer.com", username, password);
		t.sendMessage(msg, msg.getAllRecipients());
		t.close();
	}
	
	/**
	 * Send a verification code to an email address
	 * @param 	code	a verification code
	 * @param 	email	email address to send the code
	 * @return	is sending success
	 */
	public static boolean sendVerificationCode(String code, String email) {
		try {
			Send("BankRading", "bankrading", email, "BankRading inscription",
					"Votre code de vérification : " + code);
			System.out.println("Email sent, code = " + code);
			return true;
		} catch (AddressException e) {
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
}
