package com.dbali.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dbali.entity.Customer;

public class UserAccountServiceModel {

	public Customer getUserAccountByUsername(String username) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheaterPU");
	    EntityManager em = null;
	    Customer userAccount = null;
	    try {
	        em = emf.createEntityManager();
	        em.getTransaction().begin();
	        String jpql = "Customer.findByUsername";
	        Query query = em.createQuery(jpql);
	        query.setParameter("username", username);
	        List<Customer> list = query.getResultList();
	        if(list != null && !list.isEmpty()) {
	        	userAccount = list.get(0);
	        }
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
	    return userAccount;
	}
	
	public void createUserAccount(Customer newUserAccount) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheaterPU");
	    EntityManager em = null;
	    try {
	        em = emf.createEntityManager();
	        em.getTransaction().begin();
	        em.persist(newUserAccount);
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
	}
	
}