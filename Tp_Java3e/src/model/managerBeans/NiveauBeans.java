package model.managerBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.actions.NiveauMembresAction;

public class NiveauBeans implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<String> listDesc = new ArrayList<String>();
	
	public NiveauBeans(){
		NiveauMembresAction nMa = new NiveauMembresAction();
		setListDesc(nMa.getAllDesc());
	}

	public List<String> getListDesc() {
		return listDesc;
	}

	public void setListDesc(List<String> listDesc) {
		this.listDesc = listDesc;
	}

}
