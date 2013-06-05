package model.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.entities.Membre;
import model.entities.Photos;
import model.managers.MembreManager;

public class MembreAction {
	
	public MembreAction(){
		
	}

	MembreManager managerMembre = new MembreManager();
	
	
	public ArrayList<Membre> getAllMembre(){
		return managerMembre.getAllMembre();
	}
	
	public Membre getMembreByNamePass(String email, String password){
		return managerMembre.getMembreByNamePass(email, password);
	}
	
	public Membre getMembreByEmail(String email){
		
		return managerMembre.getMembreByEmail(email);
	}
	
	public int insertMembre(Membre membre){
		return managerMembre.insertMembre(membre);
	}
	
	public void updateMembre(Map<String, Object> map){
		managerMembre.updateMembre(map);
	}
	
	public void insertPhoto(Photos photoInfo){
		managerMembre.insertPhoto(photoInfo);
	}
	
	public int getMembreIdByEmail(String email){
		return managerMembre.getMembreIdByEmail(email);
	}
	
	
	public ArrayList<Membre> getMembreByID(int ID){
		return managerMembre.getMembreByID(ID);
	}
	
	public int getNoCatbyEmail(String email){
		
		int noCat = 0;
		noCat = managerMembre.getNoCatbyEmail(email);
		return noCat;
	}
	public List<Membre> getMembreByCategorie(int noCat){
		
		List<Membre> listMembre = new ArrayList<Membre>();
		listMembre = managerMembre.getMembreByCategorie(noCat);
		return listMembre;
		
	}
	public int getCountIsOnline(){
		int nombre = 0;
		nombre = managerMembre.getCountIsOnline();
		return nombre;
	}
	public ArrayList<Membre> getMembreOnLine(){
		return managerMembre.getMembreOnLine();
	}
	
	public String updateOnline(String email){
		managerMembre.updateOnline(email);
		return null;
	}
	
	public String updateOffline(String email){
		managerMembre.updateOffline(email);
		return null;
	}
	
}
