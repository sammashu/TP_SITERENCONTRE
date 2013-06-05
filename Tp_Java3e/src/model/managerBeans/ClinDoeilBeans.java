package model.managerBeans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.actions.MembreAction;
import model.entities.Clindoeil;
import model.entities.Membre;
import model.managers.ClinDoeilManager;

public class ClinDoeilBeans implements Serializable {

	private static final long serialVersionUID = 1L;
		
	private ArrayList<Clindoeil> _clinsD;
	private ArrayList<String> _clinsNom;

	public ClinDoeilBeans() { 
		_clinsD = new ArrayList<Clindoeil>();
		_clinsNom = new ArrayList<String>();
		
		MembreAction ma = new MembreAction();
		Membre m = ma.getMembreByEmail((String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(MembreLogin.KEY_AUTH));
		
		if(m != null)
		{
			_clinsD =  ClinDoeilManager.getClinDoeilClient(m.getMembreId());
			
			for(int i = 0; i < _clinsD.size(); i++)
			{
				ArrayList<Membre> mal = ma.getMembreByID(_clinsD.get(i).get_from());
				if(mal != null && mal.size() > 0)
				{
					_clinsNom.add(mal.get(0).getEmail());
				}
				else
				{
					_clinsNom.add("Utilisateur inconnu");
				}
			}
			
		}
	}
	
	public void Wink(ActionEvent evt)
	{
		MembreAction ma = new MembreAction();
		Membre m = ma.getMembreByEmail((String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(MembreLogin.KEY_AUTH));
		
		int winkToId = (int)evt.getComponent().getAttributes().get("winkID");
		
		ClinDoeilManager.insertWink(m.getMembreId(), winkToId);
	}
	
	public String GetClins()
	{
		MembreAction ma = new MembreAction();
		Membre m = ma.getMembreByEmail((String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(MembreLogin.KEY_AUTH));
		
		if(m != null)
		{
			_clinsD =  ClinDoeilManager.getClinDoeilClient(m.getMembreId());
		}
		
		return "";
	}
	
	public void set_clinsD(ArrayList<Clindoeil> _clinsD) { this._clinsD = _clinsD; }
	public ArrayList<Clindoeil> get_clinsD() { return _clinsD; }

	public ArrayList<String> get_clinsNom() { return _clinsNom; }
	public void set_clinsNom(ArrayList<String> _clinsNom) { this._clinsNom = _clinsNom; }
	
	
	
}
