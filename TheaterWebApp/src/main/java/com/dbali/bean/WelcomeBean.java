package com.dbali.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.dbali.entity.Play;
import com.dbali.service.PlaysServiceModel;


@ManagedBean (name="welcomeBean")
@SessionScoped
public class WelcomeBean {
	
	private PlaysServiceModel playsServiceModel;
	private List<Play> play;
	
	
	
	public String showPlay(long id) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("playIdforShow", id);
		return "search";
	}
	
public List<Play> getPlay() {
		
		if(playsServiceModel  == null) {
			playsServiceModel = new PlaysServiceModel();
		}
		return playsServiceModel.getAllPlay();
	}

	public void setPlays(List<Play> play) {
		this.play = play;
	}
}
