package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class Membre implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int membreId;
	private String nom;
	private String prenom;
	private int age;
	private String description;
	private int categorieId;
	private int isOnline;
	private int niveauMembreId;
	private Date lastVisit;
	private String email;
	private String password;
	private String pseudo;
	private List<Photos> photos;
	
	public Membre(){
		
	}
	

	public Membre(int membreId, String nom, String prenom, int age,
			String description, int categorieId, int isOnline,
			int niveauMembreId, Date lastVisit, String email, String password,
			String pseudo) {
		this.membreId = membreId;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.description = description;
		this.categorieId = categorieId;
		this.isOnline = isOnline;
		this.niveauMembreId = niveauMembreId;
		this.lastVisit = lastVisit;
		this.email = email;
		this.password = password;
		this.pseudo = pseudo;
	}
	
	public Membre(String nom, String prenom, int age,
			String description, int categorieId, int isOnline,
			int niveauMembreId, Date lastVisit, String email, String password,
			String pseudo) {

		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.description = description;
		this.categorieId = categorieId;
		this.isOnline = isOnline;
		this.niveauMembreId = niveauMembreId;
		this.lastVisit = lastVisit;
		this.email = email;
		this.password = password;
		this.pseudo = pseudo;
	}
	
	public Membre(String nom, String prenom, int age,
			int categorieId,int niveauMembreId, 
			String email, String password,
			String pseudo) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.categorieId = categorieId;
		this.niveauMembreId = niveauMembreId;
		this.email = email;
		this.password = password;
		this.pseudo = pseudo;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(int isOnline) {
		this.isOnline = isOnline;
	}

	public int getNiveauMembreId() {
		return niveauMembreId;
	}

	public void setNiveauMembreId(int niveauMembreId) {
		this.niveauMembreId = niveauMembreId;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
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

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getMembreId() {
		return membreId;
	}
	

	public void setMembreId(int membreId) {
		this.membreId = membreId;
	}

	public int getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(int categorieId) {
		this.categorieId = categorieId;
	}


	public List<Photos> getPhotos() {
		return photos;
	}


	public void setPhotos(List<Photos> photos) {
		this.photos = photos;
	}


	
	
}
