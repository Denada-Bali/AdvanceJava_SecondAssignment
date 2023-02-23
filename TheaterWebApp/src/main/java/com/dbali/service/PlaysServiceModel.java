package com.dbali.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.dbali.entity.Play;
import com.dbali.entity.Show;



public class PlaysServiceModel {


    private List<Play> play;
    

    private List<Show> show;
	
	/*
	 * public void getAllPlays() { EntityManagerFactory emf =
	 * Persistence.createEntityManagerFactory("TheaterPU"); EntityManager em =
	 * emf.createEntityManager(); plays =
	 * em.createNamedQuery("Show.findAll").getResultList(); }
	 */
	 
    public List<Play> getAllPlay() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheaterPU");
        EntityManager em = null;
        List<Play> list = new ArrayList<Play>();
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            TypedQuery<Play> query = em.createQuery("Show.findAll", Play.class);
            list = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return list;
    }

    public Play getPlayById(long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheaterPU");
        EntityManager em = null;
        Play play = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            play = em.find(Play.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return play;
    }

	
}
