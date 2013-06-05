package model.managers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entities.NiveauMembres;
import model.services.IbatisService;

public class NiveauMembresManager {
	
	public NiveauMembresManager(){
		
	}
	
	@SuppressWarnings("unchecked")
	public List<NiveauMembres> getAllNiveau(){
		
		List<NiveauMembres> listNiveau = new ArrayList<NiveauMembres>();
		
		try {
			listNiveau = IbatisService.getM_sqlMap().queryForList("getAllNiveau");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listNiveau;
		
	}

	
	public int getNiveauMembreIdbydescription(String NMdescription){
		int niveauMembreId = 0;
		
		try {
			niveauMembreId = (int) IbatisService.getM_sqlMap().queryForObject("getNiveauMembreIdbydescription", NMdescription);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return niveauMembreId;
		
	}
}
