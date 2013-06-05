package model.managerBeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;

import model.actions.CategorieAction;
import model.actions.MembreAction;
import model.actions.NiveauMembresAction;
import model.entities.Membre;

public class UpdateUserInfos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String destination = "C:/uploadImg/";

	private String nom;
	private String prenom;
	private String age;
	private String description;
	private String categorieId;
	private String niveauMembreId;
	private String email;
	private String password;
	private String confPassword;
	private String pseudo;

	private Map<String, Object> map = new HashMap<String, Object>();
	private Membre membre = new Membre();

	public UpdateUserInfos() {
		setEmail((String) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("email"));

		MembreAction ma = new MembreAction();
		membre = ma.getMembreByEmail(email);

		map.put("nom", membre.getNom());
		map.put("prenom", membre.getPrenom());
		map.put("age", membre.getAge());
		map.put("description", membre.getDescription());
		map.put("categorieId", membre.getCategorieId());
		map.put("niveauMembreId", membre.getNiveauMembreId());
		map.put("email", membre.getEmail());
		map.put("password", membre.getPassword());
		map.put("pseudo", membre.getPseudo());

	}

	public String updateInfos() {

		if (getPassword().equals(getConfPassword())) {

			MembreAction ma = new MembreAction();
			membre = ma.getMembreByEmail(email);

			if (getNom() != "") {
				map.put("nom", getNom());
			}

			if (getPrenom() != "") {
				map.put("prenom", getPrenom());
			}

			if (getAge() != "") {
				int a = Integer.parseInt(age);
				map.put("age", a);
			}

			if (getDescription() != "") {
				map.put("description", getDescription());
			}

			CategorieAction ca = new CategorieAction();
			if (ca.getNoCatByCategory(getCategorieId()) != membre
					.getCategorieId()) {

				map.put("categorieId", ca.getNoCatByCategory(getCategorieId()));
			}

			NiveauMembresAction nMa = new NiveauMembresAction();
			if (nMa.getNiveauMembreIdbydescription(getNiveauMembreId()) != membre
					.getNiveauMembreId()) {
				map.put("niveauMembreId",
						nMa.getNiveauMembreIdbydescription(getNiveauMembreId()));
			}

			if (getEmail() != "") {
				map.put("email", getEmail());
			}

			if (getPassword() != "") {
				map.put("password", getPassword());
			}
			if (getPseudo() != "") {
				map.put("pseudo", getPseudo());
			}

			System.out.println(map.get("categorieId"));
			ma.updateMembre(map);
		} else {
			System.out.println("les password ne concordent pas");
		}
		return null;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDestination() {
		return destination;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
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

	public String getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(String categorieId) {
		this.categorieId = categorieId;
	}

	public String getNiveauMembreId() {
		return niveauMembreId;
	}

	public void setNiveauMembreId(String niveauMembreId) {
		this.niveauMembreId = niveauMembreId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfPassword() {
		return confPassword;
	}

	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
