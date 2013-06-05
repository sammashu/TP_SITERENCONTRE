package model.entities;

public class NiveauMembres {
	private int niveauMembreId;
	private String description;
	private int nbPhotosMax;
	private int nbFavorisMax;
	private int droitEnvoyerMsg;
	
	public int getNiveauMembreId() {
		return niveauMembreId;
	}
	public void setNiveauMembreId(int niveauMembreId) {
		this.niveauMembreId = niveauMembreId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNbPhotosMax() {
		return nbPhotosMax;
	}
	public void setNbPhotosMax(int nbPhotosMax) {
		this.nbPhotosMax = nbPhotosMax;
	}
	public int getNbFavorisMax() {
		return nbFavorisMax;
	}
	public void setNbFavorisMax(int nbFavorisMax) {
		this.nbFavorisMax = nbFavorisMax;
	}
	public int getDroitEnvoyerMsg() {
		return droitEnvoyerMsg;
	}
	public void setDroitEnvoyerMsg(int droitEnvoyerMsg) {
		this.droitEnvoyerMsg = droitEnvoyerMsg;
	}
	
	
}
