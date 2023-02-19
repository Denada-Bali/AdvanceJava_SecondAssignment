package com.dbali.beans;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import com.dbali.entities.Customer;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class RegisterBean {

    
    private EntityManagerFactory emf;
    
    private Integer customerId;
    private String firstName;
    private String secondName;
    private String dateOfBirth;
    private String gender;
    private String email;
    
    @PersistenceContext(unitName = "TheaterPU")
    private EntityManager entityManager;
    
  public RegisterBean() {
        
    }
    
  public String register() {
	  
	  if (firstName == null || firstName.isEmpty() ||
			  secondName == null || secondName.isEmpty() ||
					  dateOfBirth == null || dateOfBirth.isEmpty() ||
							  gender == null || gender.isEmpty() ||
									  email == null || email.isEmpty()) {
	        // At least one field is empty, return null to stay on login page and display error message
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
	            "Please enter a value for all fields", null));
	        return null;
	    }
	  
      Customer customer = new Customer();
      customer.setCustomerId(customerId);
      customer.setFirstName(firstName);
      customer.setSecondName(secondName);
      customer.setDateOfBirth(dateOfBirth);
      customer.setGender(gender);
      customer.setEmail(email);

      entityManager.persist(customer);
      return "playSearch.xhtml";
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

    
}
