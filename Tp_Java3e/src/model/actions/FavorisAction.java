package model.actions;

import java.util.ArrayList;
import java.util.Map;

import model.entities.Favoris;
import model.managers.FavorisManager;

public class FavorisAction {

	public FavorisAction() {
		// TODO Auto-generated constructor stub
	}
	
	FavorisManager fm = new FavorisManager();
		
	public ArrayList<Integer> getIDmembreFavoriseByIDFavorisant(int ID){
		
		ArrayList<Integer> idMembres = new ArrayList<Integer>();
		idMembres = fm.getIDmembreFavoriseByIDFavorisant(ID);
		
		return idMembres;
		
	}
	
	public ArrayList<Favoris> getAllFavoritebyIDFavorisant(int ID){
		ArrayList<Favoris> favoris = new ArrayList<Favoris>();
		favoris = fm.getAllFavoritebyIDFavorisant(ID);
		return favoris;
	}
	
	public String deletefavorisById(int ID){
		fm.deletefavorisById(ID);
		return null;
	}
	
	public String deleteAllFavorisbyID(int ID){
		fm.deleteAllfavorisById(ID);
		return null;
	}

	public String getFavoritByFF(Map<String, Object> map){
		System.out.println("action favoris");
		return fm.getFavoritByFF(map);
		
	}
	public void insertFavorite(Favoris favoris){
		fm.insertFavorite(favoris);
	}

}
 