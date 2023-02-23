package com.dbali.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@Table(name = "CUSTOMER")
@NamedQueries({ 
	@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"), 
	@NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.customerid = :customerId"),
	@NamedQuery(name = "Customer.findByFirstName", query = "SELECT c FROM Customer c WHERE c.firstname = :firstName"),
	@NamedQuery(name = "Customer.findBySecondName", query = "SELECT c FROM Customer c WHERE c.secondname = :secondName"),
	@NamedQuery(name = "Customer.findByDateOfBirth", query = "SELECT c FROM Customer c WHERE c.dateofbirth = :dateOfBirth"),
	@NamedQuery(name = "Customer.findByGender", query = "SELECT c FROM Customer c WHERE c.gender = :gender"),
	@NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email"),
	@NamedQuery(name = "Customer.findByUsername", query = "SELECT c FROM Customer c WHERE c.username = :username"),
	@NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password"),
	@NamedQuery(name = "Customer.findByUserType", query = "SELECT c FROM Customer c WHERE c.userType = :userType") 
})
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long customerid;
	
	@Column(name = "FIRSTNAME")
	@Basic(optional = false)
	private String firstname;

	
	@Column(name = "SECONDNAME")
	@Basic(optional = false)
	private String secondname;
	
	@Column(name = "DATEOFBIRTH")
	@Basic(optional = false)
	private String dateofbirth;

	@Column(name = "EMAIL")
	@Basic(optional = true)
	private String email;
	
	@Column(name = "GENDER")
	@Basic(optional = false)
	private String gender;

	@Column(name = "USERNAME")
	@Basic(optional = false)
	private String username;
	
	@Column(name = "PASSWORD")
	@Basic(optional = true)
	private String password;
	
	@Basic(optional = false)
	private int userType;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="customer")
	private List<Account> accounts;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="customer")
	private List<Ticket> tickets;

	public Customer() {
	}
	
	public Customer(String firstname, String secondname, String dateofbirth, String email,
			String gender, String username, String password, int userType) {
		super();
		this.customerid = customerid;
		this.firstname = firstname;
		this.secondname = secondname;
		this.dateofbirth = dateofbirth;
		this.email = email;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.accounts = accounts;
		this.tickets = tickets;
	}


	public long getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
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

	public String getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSecondname() {
		return this.secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setCustomer(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setCustomer(null);

		return account;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setCustomer(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setCustomer(null);

		return ticket;
	}

}