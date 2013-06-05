package model.managerBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.FacesContext;



import model.actions.FavorisAction;
import model.actions.MembreAction;
import model.entities.Favoris;
import model.entities.Membre;
public class SearchingBeans implements Serializable{
	private static final long serialVersionUID = 1L;
	private String searchWords;
	public List<Membre> mem = new ArrayList<Membre>();
	private Map<String, String> myMap = new HashMap<String, String>();
	public List<Membre> list = new ArrayList<Membre>();
	private HtmlInputHidden hiddenId = new HtmlInputHidden();
	
	public SearchingBeans(){
		
			setMem();
			
			list = getMem();
	}

	public String getSearchWords() {
		return searchWords;
	}

	public void setSearchWords(String searchWords) {
		this.searchWords = searchWords;
	}
	
	public String startSearch(){
		return null;
	}
	public List<Membre> getMem() {
		return mem;
	}
	
	public void setMem() {
		MembreAction ma = new MembreAction();
		String emailSession = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("email");
		int noCat = ma.getNoCatbyEmail(emailSession);
		
		this.mem = ma.getMembreByCategorie(noCat);
	}
	
	
	public String insertFavorite(){
		FavorisAction fm = new FavorisAction();
		MembreAction ma = new MembreAction();
		int idFavorisant = ma.getMembreIdByEmail((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("email"));
		System.out.println(getHiddenId().getValue() + " " + idFavorisant);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("membreFavorisant", idFavorisant);
		map.put("membreFavorise", getHiddenId().getValue());
		if(fm.getFavoritByFF(map) != null){
			System.out.println("Deja favorite");
		}else{
			Favoris favoris = new Favoris(new Date(), idFavorisant, (int)getHiddenId().getValue());
			fm.insertFavorite(favoris);
		}
		
		
		return null;
	}

	public Map<String, String> getMyMap() {
		return myMap;
	}

	public void setMyMap(Map<String, String> myMap) {
		this.myMap = myMap;
	}

	public List<Membre> getList() {
		return list;
	}

	public void setList(List<Membre> list) {
		this.list = list;
	}

	public HtmlInputHidden getHiddenId() {
		return hiddenId;
	}

	public void setHiddenId(HtmlInputHidden hiddenId) {
		this.hiddenId = hiddenId;
	}
	
	




}
