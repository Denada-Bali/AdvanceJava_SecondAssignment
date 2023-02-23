package com.dbali.entity;


import javax.persistence.*;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;


/**
 * The persistent class for the PLAYS database table.
 * 
 */
@Entity
@Table(name="PLAYS")
@NamedQueries({ 
	@NamedQuery(name = "Play.findAll", query = "SELECT p FROM Play p"), 
	@NamedQuery(name = "Plays.findById", query = "SELECT p FROM Play p WHERE p.movieid = :movieId"),
	@NamedQuery(name = "Plays.findByTitle", query = "SELECT p FROM Play p WHERE p.title = :title"),
	@NamedQuery(name = "Plays.findByWriter", query = "SELECT p FROM Play p WHERE p.writer = :writer"),
	@NamedQuery(name = "Plays.findByDirector", query = "SELECT p FROM Play p WHERE p.director = :director") 
})
public class Play  {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MOVIEID")
	@GeneratedValue(strategy = IDENTITY)
	private long movieid;
	
	@Column(name = "TITLE")
	@Basic(optional = false)
	private String title;

	@Column(name = "ACTORS")
	@Basic(optional = false)
	private String actors;

	@Column(name = "DIRECTOR")
	@Basic(optional = false)
	private String director;

	
	@Column(name = "WRITER")
	@Basic(optional = false)
	private String writer;

	//bi-directional many-to-one association to Show
	@OneToMany(mappedBy="play")
	private List<Show> shows;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="play")
	private List<Ticket> tickets;

	public Play() {
	}

	public long getMovieid() {
		return this.movieid;
	}

	public void setMovieid(long movieid) {
		this.movieid = movieid;
	}

	public String getActors() {
		return this.actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return this.writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public List<Show> getShows() {
		return this.shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	public Show addShow(Show show) {
		getShows().add(show);
		show.setPlay(this);

		return show;
	}

	public Show removeShow(Show show) {
		getShows().remove(show);
		show.setPlay(null);

		return show;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setPlay(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setPlay(null);

		return ticket;
	}

}