package com.dbali.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.dbali.bean.TheaterHallBean;
import com.dbali.entity.Hall;
import com.dbali.entity.Play;
import com.dbali.entity.Show;

import model.ShowMOD;
import model.TheaterHallMOD;

public class ShowServiceModel {

	public List<Show> ShowByPlayId(long playId){
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheaterPU");
	    EntityManager em = null;
	    List<Show> list = null;
	    try {
	        em = emf.createEntityManager();
	        em.getTransaction().begin();
	        String jpql = "Show.findById";
	        Query query = em.createQuery(jpql);
	        query.setParameter("playId", playId);
	        list = query.getResultList();
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	        if (em != null) {
	            em.getTransaction().rollback();
	        }
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
	    return list;
	}
	
	public List<Show> ShowByPlayIdAndDate(long playId, Date date) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheaterPU");
	    List<Show> list = new ArrayList<>();
	    EntityManager em = null;
	    try {
	        em = emf.createEntityManager();
	        CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Show> cq = cb.createQuery(Show.class);
	        Root<Show> root = cq.from(Show.class);
	        Predicate predicate = cb.and(
	            cb.equal(root.get("playId"), playId),
	            cb.greaterThanOrEqualTo(root.get("date"), date)
	        );
	        cq.select(root).where(predicate);
	        list = em.createQuery(cq).getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (em != null && em.isOpen()) {
	            em.close();
	        }
	    }
	    return list;
	}
	
	public Hall getTheaterHallById(long id) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheaterPU");
	    EntityManager em = null;
	    Hall hall = null;
	    try {
	        em = emf.createEntityManager();
	        hall = em.find(Hall.class, id);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (em != null && em.isOpen()) {
	            em.close();
	        }
	    }
	    return hall;
	}

	
	public List<ShowMOD> getShowDataByPlayAndDate(long playId,Date date,PlaysServiceModel playService){
		List<ShowMOD> showList = new ArrayList<ShowMOD>();
		try {
			
			List<Show> showsList = ShowByPlayIdAndDate(playId,date);
			
			for(Show show:showsList){
				ShowMOD showM = new ShowMOD();
				
				Play play = playService.getPlayById(show.getShowid());
				
				showM.setPlay(play);
				
				TheaterHallMOD theaterHall = new TheaterHallMOD();
				Hall hall = getTheaterHallById(show.getTheaterhallid());
				theaterHall.setName(hall.getNameofhall());
				
				showM.setId(show.getShowid());
				showM.setTheaterHall(theaterHall);
				showList.add(showM);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return showList;
	}
	
	public List<ShowMOD> getShowData(long playId,PlaysServiceModel playService){
		List<ShowMOD> showList = new ArrayList<ShowMOD>();
		try {
			
			List<Show> showsList = ShowByPlayId(playId);
			
			for(Show show:showsList){
				ShowMOD showdto = new ShowMOD();
				
				Play play = playService.getPlayById(show.getShowid());
				
				showdto.setPlay(play);
				
				TheaterHallMOD theaterHallDTO = new TheaterHallMOD();
				Hall hall = getTheaterHallById(show.getTheaterhallid());
				theaterHallDTO.setName(hall.getNameofhall());
				
				showdto.setId(show.getShowid());
				showdto.setTheaterHall(theaterHallDTO);
				showList.add(showdto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return showList;
	}
	
}
