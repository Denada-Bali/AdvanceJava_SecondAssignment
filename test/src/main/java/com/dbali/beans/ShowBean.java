package com.dbali.beans;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.dbali.entities.Show;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class ShowBean implements Serializable {

    @PersistenceContext(unitName = "TheaterPU")
    private EntityManager entityManager;

    private List<Show> shows;

    public List<Show> getShows() {
        if (shows == null) {
            TypedQuery<Show> query = entityManager.createQuery("SELECT s FROM Show s", Show.class);
            shows = query.getResultList();
        }
        return shows;
    }
}
