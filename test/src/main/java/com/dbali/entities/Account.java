package com.dbali.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "ACCOUNT")
@XmlRootElement
  @NamedQueries({
  @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
  @NamedQuery(name = "Account.findById", query ="SELECT a FROM Account a WHERE a.customerId = :accountId"),
  @NamedQuery(name = "Account.findByUsername", query ="SELECT a FROM Account a WHERE a.username = :username"),
  @NamedQuery(name = "Account.findByPassword", query ="SELECT a FROM Account a WHERE a.password = :password"),
  @NamedQuery(name = "Account.findByUserType", query ="SELECT a FROM Account a WHERE a.userType = :userType"),
  
  /* @NamedQuery(name = "Customer.findByCustomerID", query ="SELECT a FROM Account a WHERE a.customerID = :customerID"),*/})

public class Account implements Serializable {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "ACCOUNTID")
	    private Integer accountId;
	    
	    @Basic(optional = false)
	    @Column(name = "USERNAME")
	    private String username;
	    
	    @Basic(optional = false)
	    @Column(name = "PASSWORD")
	    private String password;
	    
	    @Basic(optional = false)
	    @Column(name = "USERTYPE")
	    private int usertype;
	    
	    @JoinColumn(name = "customerId",  referencedColumnName = "customerId")
	    @ManyToOne (optional = false)
	    private Customer customerId;
	       
		public Account() {
		}

		public Account(Integer accountId, String username, String password) {
			super();
			this.accountId = accountId;
			this.username = username;
			this.password = password;
		}

		public Integer getAccountId() {
			return accountId;
		}

		public void setAccountId(Integer accountId) {
			this.accountId = accountId;
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
		
		

		public int getUsertype() {
			return usertype;
		}



		public void setUsertype(int usertype) {
			this.usertype = usertype;
		}



		public Customer getCustomerId() {
			return customerId;
		}


		public void setCustomerId(Customer customerId) {
			this.customerId = customerId;
		}


		   @Override
		    public int hashCode() {
		        int hash = 0;
		        hash += (accountId != null ? accountId.hashCode() : 0);
		        return hash;
		    }

		    @Override
		    public boolean equals(Object object) {
		        // TODO: Warning - this method won't work in the case the id fields are not set
		        if (!(object instanceof Account)) {
		            return false;
		        }
		        Account other = (Account) object;
		        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
		            return false;
		        }
		        return true;
		    }


		    @Override
		    public String toString() {
		        return "al.edu.unyt.advjava.webapps.thrater.entities.Account[ accountId=" + accountId + " ]";
		       
		    }
	    
	    
	    
}
