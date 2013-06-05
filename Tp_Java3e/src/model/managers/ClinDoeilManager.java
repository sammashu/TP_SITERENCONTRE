package model.managers;

import java.sql.SQLException;
import java.util.ArrayList;

import model.entities.Clindoeil;
import model.services.IbatisService;

public class ClinDoeilManager {
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Clindoeil> getClinDoeilClient(int ID){
		ArrayList<Clindoeil> cDClients = new ArrayList<Clindoeil>();
		
		try {
			cDClients = (ArrayList<Clindoeil>) IbatisService.getM_sqlMap().queryForList("getClinDoeilClient", ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cDClients;
	}
	
	public static void insertWink(int idFrom, int idTo)
	{
		Clindoeil wink = new Clindoeil();
		wink.set_from(idFrom);
		wink.set_to(idTo);
		
		try {
			IbatisService.getM_sqlMap().insert("insertWink", wink);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
