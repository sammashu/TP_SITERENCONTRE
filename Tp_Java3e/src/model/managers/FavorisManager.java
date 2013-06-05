package model.managers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import model.entities.Favoris;
import model.services.IbatisService;

public class FavorisManager {

	public FavorisManager() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Integer> getIDmembreFavoriseByIDFavorisant(int ID){
		ArrayList<Integer> idMembres = new ArrayList<Integer>();
		
		try {
			idMembres = (ArrayList<Integer>) IbatisService.getM_sqlMap().queryForList("getIDmembreFavoriseByIDFavorisant", ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return idMembres;
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Favoris> getAllFavoritebyIDFavorisant(int ID){
		ArrayList<Favoris> favoris = new ArrayList<Favoris>();
		try {
			favoris = (ArrayList<Favoris>) IbatisService.getM_sqlMap().queryForList("getAllFavoritebyIDFavorisant", ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return favoris;
	}
	
	public void deletefavorisById(int IDFavori ){
		try {
			IbatisService.getM_sqlMap().delete("deletefavorisById", IDFavori);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteAllfavorisById(int IDmembre ){
		try {
			IbatisService.getM_sqlMap().delete("deleteALLfavorisById", IDmembre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertFavorite(Favoris favoris){
		try {
			IbatisService.getM_sqlMap().insert("insertFavorite", favoris);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getFavoritByFF(Map<String,Object> map){
		String idFavoris = null;
		try {
			idFavoris = (String) IbatisService.getM_sqlMap().queryForObject("getFavoritByFF",map);
			System.out.println("favoris manager");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idFavoris;
	}
}
