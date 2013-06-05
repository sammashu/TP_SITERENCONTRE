package model.managerBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.actions.CategorieAction;

public class CategorieBeans implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<String> listCatdesc = new ArrayList<String>();
	
	public CategorieBeans(){
		
		CategorieAction ca = new CategorieAction();
		setListCatdesc(ca.getAllCatDesc());
	}

	public List<String> getListCatdesc() {
		return listCatdesc;
	}

	public void setListCatdesc(List<String> listCatdesc) {
		this.listCatdesc = listCatdesc;
	}
	

}
