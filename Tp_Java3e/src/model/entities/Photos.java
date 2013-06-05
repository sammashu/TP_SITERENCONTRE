package model.entities;

/*
Field     Type          Collation          Null    Key     Default  Extra           Privileges                       Comment
--------  ------------  -----------------  ------  ------  -------  --------------  -------------------------------  -------
photoid   bigint(11)    (NULL)             NO      PRI     (NULL)   auto_increment  select,insert,update,references         
membreId  bigint(20)    (NULL)             NO      MUL     (NULL)                   select,insert,update,references         
chemin    varchar(255)  latin1_swedish_ci  NO              (NULL)                   select,insert,update,references         
isprofil  tinyint(1)    (NULL)             YES             0                        select,insert,update,references         
*/

public class Photos {

	private int photoId;
	private int membreId;
	private String chemin;
	private int isprofil;
	
	public Photos(){}
	
		
	public Photos(int membreId, String chemin) {
		super();
		this.membreId = membreId;
		this.chemin = chemin;
	}



	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public int getMembreId() {
		return membreId;
	}

	public void setMembreId(int membreId) {
		this.membreId = membreId;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public int getIsprofil() {
		return isprofil;
	}

	public void setIsprofil(int isprofil) {
		this.isprofil = isprofil;
	}
	
	
	
	
}
