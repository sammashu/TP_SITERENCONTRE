package model.managers;

import java.sql.SQLException;
import java.util.Map;

import model.services.IbatisService;

public class PhotoManager {
	
	public PhotoManager(){
		
	}
	
	public String getCheminById(int membreId){
		
		String chemin = null;
		try {
			chemin = (String) IbatisService.getM_sqlMap().queryForObject("getCheminById",membreId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chemin;
		
	}
	
	public void updateChemin(Map<String, Object> map){
		try {
			IbatisService.getM_sqlMap().update("updateChemin",map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
