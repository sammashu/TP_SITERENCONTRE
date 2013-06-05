package model.entities;

import java.util.Date;

/*
Field             Type        Collation  Null    Key     Default  Extra           Privileges                       Comment                                   
----------------  ----------  ---------  ------  ------  -------  --------------  -------------------------------  ------------------------------------------
favorisID         bigint(20)  (NULL)     NO      PRI     (NULL)   auto_increment  select,insert,update,references                                            
dateAjout         datetime    (NULL)     YES             (NULL)                   select,insert,update,references                                            
membreFavorisant  bigint(20)  (NULL)     NO              (NULL)                   select,insert,update,references  le propriétaire de ce favori             
membreFavorise    bigint(20)  (NULL)     NO              (NULL)                   select,insert,update,references  le membre ayant été ajouté comme favori
*/
public class Favoris {

	private int favorisID;
	private Date dateAjout;
	private int membreFavorisant;
	private int membreFavorise;
	
	
	public Favoris(){}
	
	public Favoris(Date dateAjout, int membreFavorisant, int membreFavorise){
		this.dateAjout = dateAjout;
		this.membreFavorisant = membreFavorisant;
		this.membreFavorise = membreFavorise;
	}
	
	public int getFavorisID() {
		return favorisID;
	}
	public void setFavorisID(int favorisID) {
		this.favorisID = favorisID;
	}
	public Date getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}
	public int getMembreFavorisant() {
		return membreFavorisant;
	}
	public void setMembreFavorisant(int membreFavorisant) {
		this.membreFavorisant = membreFavorisant;
	}
	public int getMembreFavorise() {
		return membreFavorise;
	}
	public void setMembreFavorise(int membreFavorise) {
		this.membreFavorise = membreFavorise;
	}
	
	
}
