package model.managers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.entities.Membre;
import model.entities.Photos;
import model.services.IbatisService;


public class MembreManager{
	
	public MembreManager(){
		
	}
	

	
	@SuppressWarnings("unchecked")
	public ArrayList<Membre> getAllMembre(){
		
		ArrayList<Membre> membre = new ArrayList<Membre>();
	
		try {
			membre = (ArrayList<Membre>) IbatisService.getM_sqlMap().queryForList("getAllMembre");
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return membre;
	}
	
	//looking member in database that log in
	public Membre getMembreByNamePass(String email, String password){
		Membre membre = new Membre();
		Map<String, String> map = new HashMap<String,String>();
		map.put("email", email);
		map.put("password",password);
		try {
			membre = (Membre) IbatisService.getM_sqlMap().queryForObject("getMembreByNamePass",map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return membre;
	}
	
	public Membre getMembreByEmail(String email){
		Membre membre = new Membre();
		
		try {
			membre = (Membre) IbatisService.getM_sqlMap().queryForObject("getMembreByEmail",email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return membre;
	}
	
	@SuppressWarnings("unchecked")
	public List<Membre> getMembreByCategorie(int categorieId){
		List<Membre> membre = new ArrayList<Membre>();
		try {
			membre = (ArrayList<Membre>)IbatisService.getM_sqlMap().queryForList("getMembreByCategorie",categorieId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return membre;
	}
	

	public int getCountIsOnline(){
		
		//rayList<Membre> membre = new ArrayList<Membre>();
		int nombre = 0;
		try {
			nombre =  (int) IbatisService.getM_sqlMap().queryForObject("getCountIsOnline");
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return nombre;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Membre> getMembreOnLine(){
		ArrayList<Membre> membre = new ArrayList<Membre>();
		try {
			membre = (ArrayList<Membre>)IbatisService.getM_sqlMap().queryForList("getMembreOnLine");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return membre;
	}
	
	public int insertMembre(Membre membre){
		int id = 0;
		
		try {
			id = (int) IbatisService.getM_sqlMap().insert("insertMembre",membre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}



	public void updateMembre(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		try {
			IbatisService.getM_sqlMap().update("modifierMembre", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateOnline(String email){
		try {
			IbatisService.getM_sqlMap().update("updateOnline", email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateOffline(String email){
		try {
			IbatisService.getM_sqlMap().update("updateOffline", email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertPhoto(Photos photoInfo){
		
		try {
			IbatisService.getM_sqlMap().insert("insertPhoto", photoInfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getMembreIdByEmail(String email){
		int id = 0;
		try {
			id = (int) IbatisService.getM_sqlMap().queryForObject("getMembreIdByEmail",email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;

	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Membre> getMembreByID(int ID){
		
		ArrayList<Membre> membre = new ArrayList<Membre>();
	
		try {
			membre = (ArrayList<Membre>) IbatisService.getM_sqlMap().queryForList("getMembreByID", ID);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return membre;
	}
	
	public int getNoCatbyEmail(String email){
		int noCat = 0;
		try {
			noCat = (int) IbatisService.getM_sqlMap().queryForObject("getNoCatbyEmail",email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return noCat;
	}
	
	public static void DeleteMembre(Membre membre)
	{
		try {
			IbatisService.getM_sqlMap().delete("deleteAllPhotos", membre);
			IbatisService.getM_sqlMap().delete("deleteMembre",membre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}