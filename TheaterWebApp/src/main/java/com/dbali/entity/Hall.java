package com.dbali.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;


/**
 * The persistent class for the HALL database table.
 * 
 */
@Entity
@Table(name = "HALL")
@NamedQueries({ 
	@NamedQuery(name = "Hall.findAll", query = "SELECT h FROM Hall h"),
	@NamedQuery(name = "Hall.findById", query = "SELECT h FROM Hall h WHERE h.theaterhallid = :hallId"),
	@NamedQuery(name = "Hall.findByNameOfHall", query = "SELECT h FROM Hall h WHERE h.nameofhall = :nameOfHall"),
	@NamedQuery(name = "Hall.findBySeatsPlanRow", query = "SELECT h FROM Hall h WHERE h.seatsplanrows = :seatsPlanRow"),
	@NamedQuery(name = "Hall.findBySeatsPlanColumns", query = "SELECT h FROM Hall h WHERE h.seatsplancolumns = :seatsPlanColumns"),
	@NamedQuery(name = "Hall.findByTotalSeats", query = "SELECT h FROM Hall h WHERE h.totalseats = :totalSeats"), 
})
public class Hall implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long theaterhallid;

	@Column(name = "NAMEOFHALL")
	@Basic(optional = true)
	private String nameofhall;

	@Column(name = "SEATSPLANCOLUMNS")
	@Basic(optional = false)
	private BigDecimal seatsplancolumns;

	@Column(name = "SEATSPLANROWS")
	@Basic(optional = false)
	private BigDecimal seatsplanrows;
	
	@Column(name = "TOTALSEATS")
	@Basic(optional = false)
	private BigDecimal totalseats;

	//bi-directional many-to-one association to Theater
	@ManyToOne
	@JoinColumn(name="THEATERID")
	private Theater theater;

	//bi-directional many-to-one association to Theater
//	@OneToMany(mappedBy="hall")
//	private List<Theater> theaters;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="hall")
	private List<Ticket> tickets;

	public Hall() {
	}

	public long getTheaterhallid() {
		return this.theaterhallid;
	}

	public void setTheaterhallid(long theaterhallid) {
		this.theaterhallid = theaterhallid;
	}

	public String getNameofhall() {
		return this.nameofhall;
	}

	public void setNameofhall(String nameofhall) {
		this.nameofhall = nameofhall;
	}

	public BigDecimal getSeatsplancolumns() {
		return this.seatsplancolumns;
	}

	public void setSeatsplancolumns(BigDecimal seatsplancolumns) {
		this.seatsplancolumns = seatsplancolumns;
	}

	public BigDecimal getSeatsplanrows() {
		return this.seatsplanrows;
	}

	public void setSeatsplanrows(BigDecimal seatsplanrows) {
		this.seatsplanrows = seatsplanrows;
	}

	public BigDecimal getTotalseats() {
		return this.totalseats;
	}

	public void setTotalseats(BigDecimal totalseats) {
		this.totalseats = totalseats;
	}

	public Theater getTheater() {
		return this.theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	/*
	 * public List<Theater> getTheaters() { return this.theaters; }
	 * 
	 * public void setTheaters(List<Theater> theaters) { this.theaters = theaters; }
	 */
	/*
	 * public Theater addTheater(Theater theater) { getTheaters().add(theater);
	 * theater.setHall(this);
	 * 
	 * return theater; }
	 */

	/*
	 * public Theater removeTheater(Theater theater) {
	 * getTheaters().remove(theater); theater.setHall(null);
	 * 
	 * return theater; }
	 */
	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setHall(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setHall(null);

		return ticket;
	}

}