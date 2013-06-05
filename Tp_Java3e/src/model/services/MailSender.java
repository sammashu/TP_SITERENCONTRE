package model.services;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.entities.EmailToSend;


public class MailSender{
	
	private String _serveurSMTP;
	private static String 	MON_SMTP = "uhura";	
	public MailSender(String serveurSMTP){
		_serveurSMTP=serveurSMTP;	
	}
	
	public boolean sendMail(String source,String sourceName,String destination,String subject,String text){
		
		try{
			java.util.Properties properties = System.getProperties();
			properties.put("mail.smtp.host", _serveurSMTP);
			Session session = Session.getInstance(properties, null);
			
			// Construire le message
			MimeMessage message = new MimeMessage(session);
			
			try{
				message.setFrom(new InternetAddress(source,sourceName));
			}
			catch(UnsupportedEncodingException eu){
				System.out.println(eu.getMessage());
			}
			
			message.addRecipient(MimeMessage.RecipientType.TO,new InternetAddress(destination));
			message.setSubject(subject);
			message.setText(text);			
			message.setHeader("Content-Type", "text/html");
			message.setSentDate(new Date());	
		
			//Envoi du courrier
			Transport.send(message);
		}
		catch(MessagingException ex){
			System.out.println (ex.getMessage());
			return false;
		}
		return true;
	}
	public static void envoyerEmail(EmailToSend es)
	{
		(new MailSender(MON_SMTP)).sendMail(es.getM_source(), es.getM_sourceName(), es.getM_destination(), es.getM_subject(),es.getM_text());
	}
}
