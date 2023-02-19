package com.dbali.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
*
* @author Denalda Bali
*/

@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
  @NamedQueries({
  @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
  @NamedQuery(name = "Customer.findById", query ="SELECT c FROM Customer c WHERE c.customerId = :customerId"),
  @NamedQuery(name = "Customer.findByFirstName", query ="SELECT c FROM Customer c WHERE c.firstName = :firstName"),
  @NamedQuery(name = "Customer.findBySecondName", query ="SELECT c FROM Customer c WHERE c.secondName = :secondName"),
  @NamedQuery(name = "Customer.findByDateOfBirth", query ="SELECT c FROM Customer c WHERE c.dateOfBirth = :dateOfBirth"),
  @NamedQuery(name = "Customer.findByGender", query ="SELECT c FROM Customer c WHERE c.gender = :gender"),
  @NamedQuery(name = "Customer.findByEmail", query ="SELECT c FROM Customer c WHERE c.email = :email"),})
 
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CUSTOMERID")
    private Integer customerId;
    
    @Basic(optional = false)
    @Column(name = "FIRSTNAME")
    private String firstName;
    
    @Basic(optional = false)
    @Column(name = "SECONDNAME")
    private String secondName;
    
    @Basic(optional = false)
    @Column(name = "DATEOFBIRTH")
    private String dateOfBirth;
    
    @Basic(optional = false)
    @Column(name = "GENDER")
    private String gender;
    
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Account account;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Ticket> tickets;
    
	public Customer() {
	}
	
	public Customer(Integer customerId, String firstName, String secondName, String dateOfBirth, String gender,
			String email) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.secondName = secondName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	   public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (customerId != null ? customerId.hashCode() : 0);
	        return hash;
	    }
	   
	   @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Customer)) {
	            return false;
	        }
	        Customer other = (Customer) object;
	        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
	            return false;
	        }
	        return true;
	    }
  
	   @Override
	    public String toString() {
	        return "al.edu.unyt.advjava.webapps.thrater.entities.Customer[ customerId=" + customerId + " ]";
	       
	    }
    
}
