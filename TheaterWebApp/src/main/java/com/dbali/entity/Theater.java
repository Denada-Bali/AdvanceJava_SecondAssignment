package com.dbali.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;


/**
 * The persistent class for the THEATER database table.
 * 
 */
@Entity
@Table(name = "THEATER")
@NamedQueries({ 
	@NamedQuery(name = "Theater.findAll", query = "SELECT t FROM Theater t"), 
	@NamedQuery(name = "Theater.findById", query = "SELECT t FROM Theater t WHERE t.theaterid = :theaterId"),
	@NamedQuery(name = "Theater.findByName", query = "SELECT t FROM Theater t WHERE t.name = :name"),
	@NamedQuery(name = "Theater.findByTotalTheaterHalls", query = "SELECT t FROM Theater t WHERE t.totaltheaterhalls = :totalTheaterHalls") 
})
public class Theater implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	private long theaterid;

	@Column(name = "NAME")
	@Basic(optional = false)
	private String name;

	//bi-directional many-to-one association to Hall
	@OneToMany(mappedBy="theater")
	private List<Hall> halls;

	//bi-directional many-to-one association to Hall
	@Column(name="TOTALTHEATERHALLS")
	@Basic(optional = false)
	private int totaltheaterhalls;

	public Theater() {
	}

	public long getTheaterid() {
		return this.theaterid;
	}

	public void setTheaterid(long theaterid) {
		this.theaterid = theaterid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Hall> getHalls() {
		return this.halls;
	}

	public void setHalls(List<Hall> halls) {
		this.halls = halls;
	}

	public Hall addHall(Hall hall) {
		getHalls().add(hall);
		hall.setTheater(this);

		return hall;
	}

	public Hall removeHall(Hall hall) {
		getHalls().remove(hall);
		hall.setTheater(null);

		return hall;
	}

	public int getTotaltheaterhalls() {
		return this.totaltheaterhalls;
	}

	public void setTotaltheaterhallsl(int totaltheaterhalls) {
		this.totaltheaterhalls = totaltheaterhalls;
	}

}