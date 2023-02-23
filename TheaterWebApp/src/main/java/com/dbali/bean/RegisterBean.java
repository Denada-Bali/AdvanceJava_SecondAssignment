package com.dbali.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.dbali.dboperation.DatabaseOperations;
import com.dbali.entity.Customer;
import com.dbali.service.UserAccountServiceModel;

@ManagedBean(name = "registerBean")
@RequestScoped
public class RegisterBean {

	private Integer customerId;
	private String firstName;
	private String secondName;
	private String dateOfBirth;
	private String gender;
	private String email;
	private String username;
	private String password;
	private int userType;

	public RegisterBean() {

	}
	
	   private UserAccountServiceModel userAccountService = new UserAccountServiceModel();
	    

	public String register() {
	    
		 DatabaseOperations db = new DatabaseOperations();
	    try {
	        // Check if the username already exists
	    	boolean exist = db.ExistUsername(username);
	        
	        if(exist==true)
	        {
	        	 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username already taken"));
	  	       
	        	
	        }else
	        {
	        	/* Customer newUserAccount = new Customer(firstName, secondName, dateOfBirth, gender, email, username, password, userType);
	 	        // Save the new customer account using the entity manager
	 	        em = emf.createEntityManager();
	 	        em.getTransaction().begin();
	 	        em.persist(newUserAccount);
	 	        em.getTransaction().commit();
	 	        // Store the customer account in the session
	 	        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("customer", newUserAccount);
	 	        
	 	       */
	 	        boolean iscreated =  db.createNewConsumer(firstName, secondName, dateOfBirth, email, gender, username, password,userType);
	 	        
	 	        
	 	        
	        }
	        
	        
	        
	        return "playSearch.xhtml";
	    } catch (NoResultException e) {
	        // Create a new customer account with the provided information
	    	 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erorr: "+e.getLocalizedMessage()));
	  	       
	    	  return "playSearch";
	    }
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

}
