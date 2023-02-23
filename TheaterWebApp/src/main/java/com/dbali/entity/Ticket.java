package com.dbali.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import static javax.persistence.GenerationType.IDENTITY;


/**
 * The persistent class for the TICKET database table.
 * 
 */
@Entity
@Table(name = "TICKET")
@NamedQueries({ 
	@NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"), 
	@NamedQuery(name = "Ticket.findById", query = "SELECT t FROM Ticket t WHERE t.tickedid = :ticketId") 
})
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long tickedid;

	
	@Basic(optional = false)
	@Column(name = "TICKETPRICE")
	private BigDecimal ticketprice;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUSTOMERID")
	private Customer customer;

	//bi-directional many-to-one association to Hall
	@ManyToOne
	@JoinColumn(name="THEATERHALLID")
	private Hall hall;

	//bi-directional many-to-one association to Play
	@ManyToOne
	@JoinColumn(name="MOVIEID")
	private Play play;

	public Ticket() {
	}

	public long getTickedid() {
		return this.tickedid;
	}

	public void setTickedid(long tickedid) {
		this.tickedid = tickedid;
	}

	public BigDecimal getTicketprice() {
		return this.ticketprice;
	}

	public void setTicketprice(BigDecimal ticketprice) {
		this.ticketprice = ticketprice;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Hall getHall() {
		return this.hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public Play getPlay() {
		return this.play;
	}

	public void setPlay(Play play) {
		this.play = play;
	}

}