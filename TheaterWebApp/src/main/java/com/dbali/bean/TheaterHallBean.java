package com.dbali.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dbali.entity.Hall;


@ManagedBean (name="theaterHallBean")
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

