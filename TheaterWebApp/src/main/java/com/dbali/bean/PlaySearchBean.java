package com.dbali.bean;



import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.eclipse.persistence.config.TargetServer;

import com.dbali.entity.Play;
import com.dbali.entity.Show;
import com.dbali.service.PlaysServiceModel;
import com.dbali.service.ShowServiceModel;

import model.ShowMOD;

@ManagedBean(name="playSearchBean")
@ViewScoped
public class PlaySearchBean implements Serializable {
    
  //  @PersistenceContext(unitName = "TheaterPU")
  //  private EntityManager entityManager;
    
    private String title;
    private String writer;
    private String director;
    private String actors;
    
    private String searchQuery;
    
    private PlaysServiceModel playService = new PlaysServiceModel();
	private ShowServiceModel showService = new ShowServiceModel();
	
    private List<Play> play;
    private List<ShowMOD> show;
	private String date;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/*
	 * public String search() { String query = "%" + searchQuery + "%"; List<Plays>
	 * matchingPlays = entityManager.createQuery( "SELECT p FROM Play p WHERE " +
	 * "LOWER(CONCAT(p.title, ' ', p.writer, ' ', p.director, ' ', p.actors)) LIKE LOWER(:query)"
	 * , Plays.class) .setParameter("query", query) .getResultList();
	 * setPlays(matchingPlays); return "playSearch.xhtml"; }
	 */

    public void search() {
    	    	
		/*
		 * EntityManagerFactory emf =
		 * Persistence.createEntityManagerFactory("TheaterPU"); EntityManager em =
		 * emf.createEntityManager(); play =
		 * em.createNamedQuery("Plays.findAll").getResultList();
		 */   

    	    try {
    	        long playId = 0;
    	        FacesContext context = FacesContext.getCurrentInstance();
    	        ExternalContext externalContext = context.getExternalContext();
    	        Map<String, Object> sessionMap = externalContext.getSessionMap();

    	        playId = (long) sessionMap.get("playIdforShow");
    	        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("showDate", this.date);

    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	
    }
    
    
	public List<ShowMOD> getShows() throws ParseException {
		long playId = 0;
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();

		playId = (long) sessionMap.get("playIdforShow");
		String showDate = (String) sessionMap.get("showDate");
		
		if(playId > 0 && showDate != null && !showDate.equals("")) {
			String searchDateStr = (String) sessionMap.get("showDate"); // get the date string from the session
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        	Date searchDate = format.parse(searchDateStr); // convert the string to a Date object

			this.show = showService.getShowDataByPlayAndDate(playId,searchDate,playService);
		}else {
			this.show = showService.getShowData(playId, playService);
		}
		return show;
	}
   
    public String getSearchQuery() {
		return searchQuery;
	}
    
    public void setSearchQuery(String searchQuery) {
		 this.searchQuery = searchQuery;
	}
    
    
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getWriter() {
		return writer;
	}




	public void setWriter(String writer) {
		this.writer = writer;
	}




	public String getDirector() {
		return director;
	}




	public void setDirector(String director) {
		this.director = director;
	}




	public String getActors() {
		return actors;
	}




	public void setActors(String actors) {
		this.actors = actors;
	}




	public List<Play> getPlay() {
		return play;
	}

	public void setPlays(List<Play> play) {
		this.play = play;
	}

    
}
