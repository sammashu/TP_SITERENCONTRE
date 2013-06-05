package model.managerBeans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.FacesContext;

import model.actions.FavorisAction;
import model.actions.MembreAction;
import model.entities.Favoris;
import model.entities.Membre;

public class FavoriteBeans implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int membreFavorisantID;
	private ArrayList<Membre> membres;
	private ArrayList<Integer> favoriteMemberID;
	private String email;
	private int membreSelectionne;
	private boolean toRenderTableFavorite = false;
	private boolean toRenderLabelNoFav = false;
	private HtmlInputHidden hiddenID;
	private static final String DELETESUCCESS = "delsuccess";
	private int compteur;

	MembreAction ma = new MembreAction();
	FavorisAction fa = new FavorisAction();

	public FavoriteBeans() {
		email = (String) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("email");

		populateFavorites();

	}

	public void populateFavorites() {
		FavorisAction fa = new FavorisAction();
		favoriteMemberID = new ArrayList<Integer>();
		membres = new ArrayList<Membre>();

		// set le id du membre qui favorise par rapport au email
		setMembreFavorisantID(ma.getMembreIdByEmail(getEmail()));
		// populer le array des id des membres favorise en fonction du id du
		// membre logge
		favoriteMemberID.addAll(fa
				.getIDmembreFavoriseByIDFavorisant(getMembreFavorisantID()));

		if (favoriteMemberID.size() > 0) {
			// boucler sur le array des membres et recuperer les infos des
			// membres en fonction des id contenus dans le array
			setToRenderTableFavorite(true);
			setToRenderLabelNoFav(false);

			for (int i = 0; i < favoriteMemberID.size(); i++) {
				membres.addAll(ma.getMembreByID(favoriteMemberID.get(i)));

			}
		} else {
			setToRenderTableFavorite(false);
			setToRenderLabelNoFav(true);
		}
	}

	public String deleteFavorite() {

		ArrayList<Favoris> arrayFavoris = new ArrayList<Favoris>();
		arrayFavoris.addAll(fa
				.getAllFavoritebyIDFavorisant(getMembreFavorisantID()));

		for (int i = 0; i < arrayFavoris.size(); i++) {
			if (arrayFavoris.get(i).getMembreFavorise() == (int) getHiddenID()
					.getValue()) {
				System.out.println(arrayFavoris.get(i).getMembreFavorise());
				fa.deletefavorisById((int) getHiddenID().getValue());
				break;
			}
		}
		populateFavorites();
		return DELETESUCCESS;
	}

	public String deleteAllFavorite() {
		System.out.println("Delete all favorites");
		ArrayList<Favoris> arrayFavoris = new ArrayList<Favoris>();
		arrayFavoris.addAll(fa
				.getAllFavoritebyIDFavorisant(getMembreFavorisantID()));

		for (int i = 0; i < arrayFavoris.size(); i++) {
			System.out.println("Delete : "
					+ arrayFavoris.get(i).getMembreFavorise());
			fa.deleteAllFavorisbyID(getMembreFavorisantID());

		}
		populateFavorites();
		return DELETESUCCESS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMembreFavorisantID() {
		return membreFavorisantID;
	}

	public void setMembreFavorisantID(int membreFavorisantID) {
		this.membreFavorisantID = membreFavorisantID;
	}

	public ArrayList<Membre> getMembres() {
		return membres;
	}

	public void setMembres(ArrayList<Membre> membres) {
		this.membres = membres;
	}

	public ArrayList<Integer> getFavoriteMemberID() {
		return favoriteMemberID;
	}

	public void setFavoriteMemberID(ArrayList<Integer> favoriteMemberID) {
		this.favoriteMemberID = favoriteMemberID;
	}

	public int getMembreSelectionne() {
		return membreSelectionne;
	}

	public void setMembreSelectionne(int membreSelectionne) {
		this.membreSelectionne = membreSelectionne;
	}

	public boolean isToRenderTableFavorite() {
		return toRenderTableFavorite;
	}

	public void setToRenderTableFavorite(boolean toRenderTableFavorite) {
		this.toRenderTableFavorite = toRenderTableFavorite;
	}

	public boolean isToRenderLabelNoFav() {
		return toRenderLabelNoFav;
	}

	public void setToRenderLabelNoFav(boolean toRenderLabelNoFav) {
		this.toRenderLabelNoFav = toRenderLabelNoFav;
	}

	public HtmlInputHidden getHiddenID() {
		return hiddenID;
	}

	public void setHiddenID(HtmlInputHidden hiddenID) {
		this.hiddenID = hiddenID;
	}

	public static String getDeletesuccess() {
		return DELETESUCCESS;
	}

	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

}
