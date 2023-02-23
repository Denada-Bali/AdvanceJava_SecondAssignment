package com.dbali.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import static javax.persistence.GenerationType.IDENTITY;


/**
 * The persistent class for the SHOW database table.
 * 
 */
@Entity
@Table(name = "SHOW")
@NamedQueries({ 
	@NamedQuery(name = "Show.findAll", query = "SELECT s FROM Show s"), 
	@NamedQuery(name = "Show.findById", query = "SELECT s FROM Show s WHERE s.showid = :showId"),
	@NamedQuery(name = "Show.findByStartDate", query = "SELECT s FROM Show s WHERE s.startdate = :startDate"),
	@NamedQuery(name = "Show.findByStartTime", query = "SELECT s FROM Show s WHERE s.starttime = :startTime"),
	@NamedQuery(name = "Show.findByEndTime", query = "SELECT s FROM Show s WHERE s.endtime = :endTime") 
})
public class Show implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long showid;

	
	@Column(name = "STARTDATE")
	@Basic(optional = false)
	private String startdate;

	@Column(name = "STARTTIME")
	@Basic(optional = false)
	private String starttime;
	
	@Basic(optional = false)
	@Column(name = "ENDTIME")
	private String endtime;

	
	@Column(name = "THEATERHALLID")
	@Basic(optional = false)
	private long theaterhallid;

	//bi-directional many-to-one association to Play
	@ManyToOne
	@JoinColumn(name="MOVIEID")
	private Play play;
	


	public Show() {
	}

	
	public long getShowid() {
		return this.showid;
	}

	public void setShowid(long showid) {
		this.showid = showid;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getStartdate() {
		return this.startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public long getTheaterhallid() {
		return this.theaterhallid;
	}

	public void setTheaterhallid(long theaterhallid) {
		this.theaterhallid = theaterhallid;
	}

	public Play getPlay() {
		return this.play;
	}

	public void setPlay(Play play) {
		this.play = play;
	}

}