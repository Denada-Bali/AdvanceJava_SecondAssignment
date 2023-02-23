package com.dbali.entity;

import java.io.Serializable;
import javax.persistence.*;


import java.math.BigDecimal;
import static javax.persistence.GenerationType.IDENTITY;


/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@Table(name = "ACCOUNT")
@NamedQueries({
		
	@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
		
	@NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.accountid = :accountId") 
})
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ACCOUNTID")
	@GeneratedValue(strategy = IDENTITY)
	private long accountid;
     
	
	private String password;

	private String username;

	private BigDecimal usertype;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUSTOMERID")
	private Customer customer;

	public Account() {
	}

	public long getAccountid() {
		return this.accountid;
	}

	public void setAccountid(long accountid) {
		this.accountid = accountid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public BigDecimal getUsertype() {
		return this.usertype;
	}

	public void setUsertype(BigDecimal usertype) {
		this.usertype = usertype;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}