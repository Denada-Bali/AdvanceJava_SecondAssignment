package com.dbali.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.dbali.entity.Account;
import com.dbali.entity.Customer;


@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean
{
	   private String username;
	    private String password;

	    public String login() {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheaterPU");
	        EntityManager em = null;
	        try {
	            em = emf.createEntityManager();
	            Customer userAccount = em.createNamedQuery("Customer.findByUsername", Customer.class)
	                .setParameter("username", username)
	                .getSingleResult();
	            if (userAccount != null && userAccount.getPassword() != null && userAccount.getPassword().equals(password)) {
	                // Store the customer account in the session
	                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userAccount", userAccount);
	                return "welcome";
	            } else {
	                // Display an error message
	                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid username or password"));
	                return null;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Display an error message
	            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid username or password"));
	            return null;
	        } finally {
	            if (em != null) {
	                em.close();
	            }
	        }
	    }
	    

    public String getUsername ()
    {
        return username;
    }


    public void setUsername(final String username)
    {
        this.username = username;
    }


    public String getPassword ()
    {
        return password;
    }


    public void setPassword (final String password)
    {
        this.password = password;
    }
}