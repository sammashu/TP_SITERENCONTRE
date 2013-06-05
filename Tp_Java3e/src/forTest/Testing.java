package forTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.entities.Favoris;
import model.entities.Membre;
import model.managers.FavorisManager;
import model.managers.MembreManager;

public class Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MembreManager mm = new MembreManager();
		//Map<String, Object> map = new HashMap<String, Object>();
		Membre membreOnline = mm.getMembreByEmail("7");
		for(int i = 0;i<mm.getAllMembre().size();i++){
			if(mm.getAllMembre().get(i).getEmail().equals(membreOnline.getEmail())){
				mm.updateOffline(membreOnline.getEmail());
				break;
			}
		}
	
		
		

	}

}
