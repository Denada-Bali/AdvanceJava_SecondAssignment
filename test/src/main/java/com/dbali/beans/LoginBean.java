package com.dbali.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.dbali.entities.Account;
import com.dbali.utils.Session_Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.List;

@ManagedBean
@RequestScoped
public class LoginBean implements Serializable {

    private String username;
    private String password;
    private String userType;

    @PersistenceContext(unitName = "TheaterPU")
    private EntityManager entityManager;

    public String login() {
    	
    	  if (username == null || username.isEmpty() ||
    	            password == null || password.isEmpty() ||
    	            userType == null || userType.isEmpty()) {
    	        // At least one field is empty, return null to stay on login page and display error message
    	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
    	            "Please enter a value for all fields", null));
    	        return null;
    	    }
    	
        List<Account> accounts = entityManager.createQuery(
                "SELECT a FROM Account a WHERE a.username = :username AND a.password = :password AND a.userType = :userType",
                Account.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .setParameter("userType", userType)
                .getResultList();
        if (accounts.isEmpty()) {
            // authentication failed
            return "login.xhtml?error=true";
        } else {
            // authentication succeeded, store account in session
            Account account = accounts.get(0);
       //     Session_Utils.setAccountInSession(account);
            return "playsSearch.xhtml";
        }
    }
    
    // getters and setters

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
