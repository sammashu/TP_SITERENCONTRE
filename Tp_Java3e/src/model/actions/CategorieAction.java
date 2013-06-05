package model.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.managers.CategorieManager;

public class CategorieAction {
	
	public CategorieAction(){
		
	}
	
	// get everything form categorie with id(value) and description(key) in Map
	public Map<String,Integer> getAllCat(){
		
		Map<String, Integer> allCat = new HashMap<String, Integer>();
		CategorieManager cM = new CategorieManager();
		for(int i=0;i<cM.getAllCat().size();i++){
			allCat.put(cM.getAllCat().get(i).getDescription(), cM.getAllCat().get(i).getCategorieId());
		}
		return allCat;
	}
	
	//get all description from categorie in list
	public List<String> getAllCatDesc(){
		List<String> listCatDesc = new ArrayList<String>();
		CategorieManager cM = new CategorieManager();
		for(int i = 0;i < cM.getAllCat().size();i++ ){
			listCatDesc.add(cM.getAllCat().get(i).getDescription());
		}
		return listCatDesc;
	}

	
	public int getNoCatByCategory(String CategoryDescription){		
		CategorieManager cm = new CategorieManager();
		return cm.getNoCatByCategory(CategoryDescription);

	}
}
