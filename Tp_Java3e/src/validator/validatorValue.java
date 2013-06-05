package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import model.actions.MembreAction;

public class validatorValue implements Validator{

	private Pattern pattern;
	private Matcher matcher;
 
	private static final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@Override
	public void validate(FacesContext fc, UIComponent c, Object v)
			throws ValidatorException {
		String id = c.getClientId().substring(c.getClientId().indexOf(':')+1); //get id attribut only by removing the ClientId from jsf component
		switch(id){
			case "sign_age": //represent the id attribut in component
				String age = (String) v;
				if(Integer.parseInt(age) < 18){
					fc.addMessage(c.getClientId(), new FacesMessage("You must have over 18."));
					fc.renderResponse();
				}else if(age.equals("")){
					fc.addMessage(c.getClientId(), new FacesMessage("Required"));
					fc.renderResponse();		
				}
				break;
			case "sign_username":
				String username = (String) v;
				if(username.length() < 5){
					fc.addMessage(c.getClientId(), new FacesMessage("You must have at least 5 characters."));
					fc.renderResponse();
				}
				break;			
			case "sign_password":
				String password = (String) v;
				if(password.length() < 5){
					fc.addMessage(c.getClientId(), new FacesMessage("You must have at least 6 characters."));
					fc.renderResponse();
				}
				break;
			case "sign_retype_password":
				UIInput passwordComponent = (UIInput) c.getAttributes().get("passwordComponent");
			    String pass = (String) passwordComponent.getValue();
			    String confirmPass = (String) v;
			    if(!pass.equals(confirmPass)){
			    	System.out.print(pass + " " + confirmPass);
					fc.addMessage(c.getClientId(), new FacesMessage("Your password is not identical"));
					fc.renderResponse();	    	
			    }
				break;
			case "sign_email":
				String email = (String) v;
				MembreAction ma = new MembreAction();
				if(ma.getMembreByEmail(email) != null){
					fc.addMessage(c.getClientId(), new FacesMessage("Member already exist"));
					fc.renderResponse();
				}else{
					pattern = Pattern.compile(EMAIL_PATTERN);
					matcher = pattern.matcher(email);
					if(matcher.matches() == false){
						fc.addMessage(c.getClientId(), new FacesMessage("Invalid email"));
						fc.renderResponse();	
					}
				}
				break;
		}
		
	}

}
