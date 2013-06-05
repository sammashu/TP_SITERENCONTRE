package model.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.managers.NiveauMembresManager;

public class NiveauMembresAction {
	
	public NiveauMembresAction(){
		
	}
	
	public Map<String, Integer> getAllNiveau(){
		
		Map<String, Integer> allNiveau = new HashMap<String, Integer>();
		NiveauMembresManager nMm = new NiveauMembresManager();
		for(int i=0;i<nMm.getAllNiveau().size();i++){
			allNiveau.put(nMm.getAllNiveau().get(i).getDescription(), nMm.getAllNiveau().get(i).getNiveauMembreId());
		}
		return allNiveau;
		
	}
	
	public List<String> getAllDesc(){
		
		List<String> allDesc = new ArrayList<String>();
		NiveauMembresManager nMm = new NiveauMembresManager();
		
		for(int i=0;i<nMm.getAllNiveau().size();i++){
			allDesc.add(nMm.getAllNiveau().get(i).getDescription());
		}
		return allDesc;
	}

	public int getNiveauMembreIdbydescription(String NMdescription){
		NiveauMembresManager nMm = new NiveauMembresManager();

		return nMm.getNiveauMembreIdbydescription(NMdescription);
		
	}
}
