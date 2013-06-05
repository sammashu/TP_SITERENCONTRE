package model.managerBeans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;

import model.actions.CategorieAction;
import model.actions.MembreAction;
import model.actions.NiveauMembresAction;
import model.entities.Membre;

public class MembreLogin implements Serializable {

	private static final String ADMIN_NAME = "bob@gmail.com";
	private static final long serialVersionUID = 1L;
	public static final String KEY_AUTH = "email";
	public static final String LOG_MSG = "access";
	public static final String LOG_MSG_ERR = "deny";
	public static final String LOG_MSG_OUT = "out";

	private String email;
	private String password;
	private HtmlOutputLabel WelcomeLabel;

	private HtmlOutputText countOnline = new HtmlOutputText();
	private String sessionName;
	private boolean toRendered = true;
	private boolean toRenderedLogOut = false;
	private boolean isAdmin = false;
	private boolean toRenderMessOnline = true;
	private boolean toRenderTabOnline = false;

	private String nom;
	private String prenom;
	private String age;
	private String selectRelation;
	private String selectTypeMember;
	private String signemail;
	private String signpassword;
	private String username;
	private String errorMsg;
	private String count;

	MembreAction Ma = new MembreAction();
	private ArrayList<Membre> userOnline = new ArrayList<Membre>();

	Membre membreOnline = new Membre();

	public MembreLogin() {
		
		userOnline = Ma.getMembreOnLine();

	}

	public boolean isLog() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(KEY_AUTH) != null;
	}

	public String logIN() {

		Membre membre = Ma.getMembreByNamePass(getEmail(), getPassword());
		if (membre != null) {
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put(KEY_AUTH, getEmail());

			if (membre.getEmail().equals(ADMIN_NAME)) {
				isAdmin = true;
			}

			setToRendered(false);
			setToRenderedLogOut(true);
			setSessionName((String) FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap().get(KEY_AUTH));
			getWelcomeLabel().setValue("Welcome : " + getSessionName());

			count = Integer.toString(Ma.getCountIsOnline());
			getCountOnline().setValue("Other users online : " + getCount());

			updateOnline(getSessionName());

			return LOG_MSG;
		} else {
			isAdmin = false;
			setToRendered(true);
			setToRenderedLogOut(false);
			getWelcomeLabel().setValue("Something when wrong retry!");
			return LOG_MSG_ERR;
		}

	}

	// log in de l<inscription
	public String logIN(String email, String password) {

		MembreAction Ma = new MembreAction();
		Membre membre = Ma.getMembreByNamePass(email, password);
		if (membre != null) {
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put(KEY_AUTH, email);
			setToRendered(false);
			setToRenderedLogOut(true);
			setSessionName((String) FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap().get(KEY_AUTH));
			System.out.println(email);
			getWelcomeLabel().setValue("Welcome : " + email);
			updateOnline(getSessionName());

			return LOG_MSG;
		} else {
			setToRendered(true);
			setToRenderedLogOut(false);
			getWelcomeLabel().setValue("Something when wrong retry!");
			return LOG_MSG_ERR;
		}

	}

	public String inscriptionUser() {

		MembreAction mA = new MembreAction();
		CategorieAction cA = new CategorieAction();
		NiveauMembresAction nMa = new NiveauMembresAction();
		int relationType = cA.getAllCat().get(getSelectRelation());
		int membreType = nMa.getAllNiveau().get(getSelectTypeMember());

		if (getNom() == null || getPrenom() == null
				|| Integer.parseInt(getAge()) < 18 || getSignemail() == null
				|| getSignpassword() == null || getUsername() == null) {

		}

		Membre membre = new Membre(getNom(), getPrenom(),
				Integer.parseInt(getAge()), relationType, membreType,
				getSignemail(), getSignpassword(), getUsername());
		int v = mA.insertMembre(membre);
		if (v > 0) {
			System.out.println("un insert");
			logIN(getSignemail(), getSignpassword());
			return LOG_MSG;
		} else {
			return LOG_MSG_ERR;
		}

	}

	public String logOut() {

		System.out.println("logout");
		System.out.println(getSessionName());
		updateOffline(getSessionName());
		isAdmin = false;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.remove(KEY_AUTH);
		setToRendered(true);
		setToRenderedLogOut(false);
		getWelcomeLabel().setValue("");
		
		return LOG_MSG_OUT;
	}

	public String redirectOnline() {
		if(userOnline.size()>0){
			toRenderTabOnline=true;
			toRenderMessOnline =false;
		}
		else{
			toRenderTabOnline=false;
			toRenderMessOnline =true;
		}
		return "showOnline";
	}

	public void updateOnline(String mail) {

		membreOnline = Ma.getMembreByEmail(mail);

		for (int i = 0; i < Ma.getAllMembre().size(); i++) {
			if (Ma.getAllMembre().get(i).getEmail()
					.equals(membreOnline.getEmail())) {
				Ma.updateOnline(membreOnline.getEmail());
				break;
			}
		}

	}
	
	public void updateOffline(String mail) {

		membreOnline = Ma.getMembreByEmail(mail);
		
		System.out.println(membreOnline.getEmail() + " " + "dans updateoffline");

		for(int i = 0;i<Ma.getAllMembre().size();i++){
			if(Ma.getAllMembre().get(i).getEmail().equals(membreOnline.getEmail())){
				Ma.updateOffline(membreOnline.getEmail());
				break;
			}
		}

	}

	public HtmlOutputLabel getWelcomeLabel() {
		return WelcomeLabel;
	}

	public void setWelcomeLabel(HtmlOutputLabel welcomeLabel) {
		WelcomeLabel = welcomeLabel;
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public boolean isToRendered() {
		return toRendered;
	}

	public void setToRendered(boolean toRendered) {
		this.toRendered = toRendered;
	}

	public boolean isToRenderedLogOut() {
		return toRenderedLogOut;
	}

	public void setToRenderedLogOut(boolean toRenderedLogOut) {
		this.toRenderedLogOut = toRenderedLogOut;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSelectRelation() {
		return selectRelation;
	}

	public void setSelectRelation(String selectRelation) {
		this.selectRelation = selectRelation;
	}

	public String getSelectTypeMember() {
		return selectTypeMember;
	}

	public void setSelectTypeMember(String selectTypeMember) {
		this.selectTypeMember = selectTypeMember;
	}

	public String getSignemail() {
		return signemail;
	}

	public void setSignemail(String signemail) {
		this.signemail = signemail;
	}

	public String getSignpassword() {
		return signpassword;
	}

	public void setSignpassword(String signpassword) {
		this.signpassword = signpassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public HtmlOutputText getCountOnline() {
		return countOnline;
	}

	public void setCountOnline(HtmlOutputText countOnline) {
		this.countOnline = countOnline;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public ArrayList<Membre> getUserOnline() {
		return userOnline;
	}

	public void setUserOnline(ArrayList<Membre> userOnline) {
		this.userOnline = userOnline;
	}

	public boolean isToRenderMessOnline() {
		return toRenderMessOnline;
	}

	public void setToRenderMessOnline(boolean toRenderMessOnline) {
		this.toRenderMessOnline = toRenderMessOnline;
	}

	public boolean isToRenderTabOnline() {
		return toRenderTabOnline;
	}

	public void setToRenderTabOnline(boolean toRenderTabOnline) {
		this.toRenderTabOnline = toRenderTabOnline;
	}
}
