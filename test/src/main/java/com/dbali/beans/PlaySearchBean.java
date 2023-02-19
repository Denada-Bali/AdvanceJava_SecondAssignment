package com.dbali.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.dbali.entities.Plays;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;


@ManagedBean(name="PlaySearchBean")
@SessionScoped
public class PlaySearchBean implements Serializable {
    
  //  @PersistenceContext(unitName = "TheaterPU")
  //  private EntityManager entityManager;
    
    private String title;
    private String writer;
    private String director;
    private String actors;
    
    private String searchQuery;
    
    private List<Plays> plays;
    
	/*
	 * public String search() { String query = "%" + searchQuery + "%"; List<Plays>
	 * matchingPlays = entityManager.createQuery( "SELECT p FROM Play p WHERE " +
	 * "LOWER(CONCAT(p.title, ' ', p.writer, ' ', p.director, ' ', p.actors)) LIKE LOWER(:query)"
	 * , Plays.class) .setParameter("query", query) .getResultList();
	 * setPlays(matchingPlays); return "playSearch.xhtml"; }
	 */

    public void search() {
    	
    	 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");
         EntityManager entityManager = entityManagerFactory.createEntityManager();
         entityManager.getTransaction().begin();
         
    	
    	
    	
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheaterPU");
        EntityManager em = emf.createEntityManager();
        plays = em.createNamedQuery("Plays.findAll").getResultList();        
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




	public List<Plays> getPlays() {
		return plays;
	}

	public void setPlays(List<Plays> plays) {
		this.plays = plays;
	}

    
}
