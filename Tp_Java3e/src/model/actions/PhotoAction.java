package model.actions;

import java.util.Map;

import model.managers.PhotoManager;

public class PhotoAction {
	
	PhotoManager pm = new PhotoManager();
	public PhotoAction(){
		
	}
	
	public String getCheminById(int membreId){
		
		return pm.getCheminById(membreId);
	}
	
	public void updateChemin(Map<String,Object> map){
		pm.updateChemin(map);
	}

}
