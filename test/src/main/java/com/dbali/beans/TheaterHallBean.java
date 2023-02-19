package com.dbali.beans;


import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.dbali.entities.Hall;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class TheaterHallBean implements Serializable {

    @PersistenceContext(unitName = "TheaterPU")
    private EntityManager em;

    private List<Hall> theaterHalls;

    @PostConstruct
    public void init() {
        // Load theater halls from the database
        theaterHalls = em.createQuery("SELECT th FROM TheaterHall th", Hall.class).getResultList();
    }

    public List<Hall> getTheaterHalls() {
        return theaterHalls;
    }

    public void setTheaterHalls(List<Hall> theaterHalls) {
        this.theaterHalls = theaterHalls;
    }

    public void saveTheaterHall(Hall theaterHall) {
        em.persist(theaterHall);
    }

    public void deleteTheaterHall(Hall theaterHall) {
        em.remove(em.merge(theaterHall));
        theaterHalls.remove(theaterHall);
    }
}
