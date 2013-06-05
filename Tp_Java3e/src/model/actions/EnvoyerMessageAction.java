package model.actions;

import model.entities.EmailToSend;
import model.services.MailSender;

public class EnvoyerMessageAction {

	public static void envoyerUnCourriel(String myEmail, String myName, String emailDestination, String sujet, String text){
		EmailToSend es = new EmailToSend();
		es.setM_source(myEmail);
		es.setM_sourceName(myName);
		es.setM_destination(emailDestination);
		es.setM_subject(sujet);
		es.setM_text(text);
		
		MailSender.envoyerEmail(es);
	}
	
	
}
