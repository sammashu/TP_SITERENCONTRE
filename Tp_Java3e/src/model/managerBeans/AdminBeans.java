package model.managerBeans;

import java.io.Serializable;

import java.util.ArrayList;

import javax.faces.event.ValueChangeEvent;

import model.actions.EnvoyerMessageAction;
import model.actions.MembreAction;
import model.entities.Membre;
import model.managers.MembreManager;

public class AdminBeans implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Membre> _users;
	private ArrayList<String> _usernames;
	private MembreAction _membreAction;
	
	private String _selectedMembreName;
	private Membre _selectedMembre;
	
	private String _message;
	
	// Constructor
	public AdminBeans()
	{
		_message = "";
		_membreAction = new MembreAction();
		_users = new ArrayList<Membre>();
		_usernames = new ArrayList<String>();
		RefreshUserList();
		_selectedMembreName = _users.get(0).getEmail();
		SelectUser();
	}

 
	// -------------------------------------------------------------
	// Public Methods
	// -------------------------------------------------------------
    public void ChangeSelectedName (ValueChangeEvent event) 
    {
    	RefreshUserList();
    	_selectedMembreName = event.getNewValue().toString();
    	SelectUser();
    }

    public String GotoAdminPage()
    {
    	return "admin";
    }
    
    public String SendEmailAll()
    {
    	for(int i =0; i < _usernames.size(); i++)
    	{
    		EnvoyerMessageAction.envoyerUnCourriel("admin@site.com", "Admin", _usernames.get(i), "Admin Message", _message);
    	}
    	
    	_message = "";
    	
    	return "";
    }
    
    public String SendEmailUser()
    {
    	EnvoyerMessageAction.envoyerUnCourriel("admin@site.com", "Jeff", _selectedMembreName, "mmm", _message);
    	
    	_message = "";
    	
    	return "";
    }
    
    public String DeleteUser()
    {
    	MembreManager.DeleteMembre(_selectedMembre);
    	RefreshUserList();
		_selectedMembreName = _users.get(0).getEmail();
		SelectUser();
		return "";
    }

	// -------------------------------------------------------------
	// Private Methods
	// -------------------------------------------------------------
	private void RefreshUserList()
	{
		_usernames.clear();
		_users.clear();
		
		_users = _membreAction.getAllMembre();
	}
	
	private void SelectUser()
	{
		for(int i = 0; i < _users.size(); i++)
		{
			String email = _users.get(i).getEmail();
			_usernames.add(email);
			
			if(email.equals(_selectedMembreName))
			{
				_selectedMembre = _users.get(i);
			}
		}
	}
	
	// Getters - Setters
	public void set_users(ArrayList<Membre> _users) { this._users = _users; }
	public ArrayList<Membre> get_users() { return _users; }

	public ArrayList<String> get_usernames() { return _usernames; }
	public void set_usernames(ArrayList<String> _usernames) { this._usernames = _usernames; }
	
	public Membre get_selectedMembre() { return _selectedMembre; }
	public void set_selectedMembre(Membre _selectedMembre) { this._selectedMembre = _selectedMembre; }

	public String get_selectedMembreName() { return _selectedMembreName; }
	public void set_selectedMembreName(String _selectedMembreName) { this._selectedMembreName = _selectedMembreName; }
	
	public String get_message() { return _message; }
	public void set_message(String _message) { this._message = _message; }
}
