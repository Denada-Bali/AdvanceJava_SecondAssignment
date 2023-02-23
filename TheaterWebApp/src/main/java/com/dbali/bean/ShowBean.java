package com.dbali.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.dbali.entity.Show;



@ManagedBean (name="showBean")
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