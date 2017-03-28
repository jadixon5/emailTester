package emailTest;

import javax.mail.*;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.*;
import java.util.*;

public class emailtester {

	public static void main(String[] args)
	{
		String sms;
		String username = "j7encrypted@gmail.com";
		String password = "XXXXXXXXXXXXX";
		Properties props;// = new Properties();
		Session session;// = Session.getDefaultInstance(props, null);
		String address = "j7encrypted@gmail.com";;
		
		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		session = Session.getInstance(props, new javax.mail.Authenticator() 
		{
				protected PasswordAuthentication getPasswordAuthentication() 
				{
					return new PasswordAuthentication(username, password);
				}
		});
	
		try
		{
			sms = "TEST MESSAGE";
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("j7encrypted@gmail.com", "Craigslist-Free Bot"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(address, "smsLine"));
			msg.setSubject("Craigslist Free Bot found a new post!");
			msg.setText(sms);
			Transport.send(msg);
			System.out.println();;
			//System.out.println("Wrote '" + hashVal + "' to file...\n");
		}
		catch(Exception emailErr )
		{
			System.out.println("error sending email...\n");
			emailErr.printStackTrace(System.out);
		}

	}

}
