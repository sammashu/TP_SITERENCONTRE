package model.managerBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlInputHidden;

import model.actions.MembreAction;
import model.entities.Membre;

public class DetailBeans {
	
	private HtmlInputHidden hiddenId = new HtmlInputHidden();
	private List<Membre> member = new ArrayList<Membre>();
	
	public DetailBeans(){
		
	}
	
	public String checkDetail(){
		
		MembreAction ma = new MembreAction();
		
		member = ma.getMembreByID((int) getHiddenId().getValue());
		
		return "detail";
	}

	public HtmlInputHidden getHiddenId() {
		return hiddenId;
	}

	public void setHiddenId(HtmlInputHidden hiddenId) {
		this.hiddenId = hiddenId;
	}

	public List<Membre> getMember() {
		return member;
	}

	public void setMember(List<Membre> member) {
		this.member = member;
	}

}
