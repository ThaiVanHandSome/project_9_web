//package Utils;
//
//import java.net.Authenticator;
//import java.net.PasswordAuthentication;
//import java.util.Properties;
//
//import javax.mail.Session;
//
//import org.hibernate.validator.constraints.Email;
//
//import antlr.debug.MessageAdapter;
//
//public class EmailUtils {
//	public static void sendEmail(Email email) throws Exception{
//		Properties properties = new Properties();
//		properties.put("mail.smtp.host", "smtp.gmail.com");
//		properties.put("mail.smtp.port", "587");
//		properties.put("mail.smtp.auth", "true");
//		properties.put("mail.smtp.starttls.enable", "true");
//		Session session = Session.getInstance(properties, new Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(email.getForm(), email.getFormPassword());
//			}
//		});
//		try {
//			Message message = new MineMessage(session);
//			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
//			message.setFrom(new InternetAddress(mail.getForm()));
//			message.setRecipients(MessageAdapter.RecipientType.TO, InternerAddress.parse(email.getTo()));
//			message.setSubject(email.getSubject());
//			message.setContent(email.getContent(), "text/html; char-set=UTF-8");
//			Transport.send(message);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//	}
//}
