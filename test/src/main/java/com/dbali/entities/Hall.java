package com.dbali.entities;

import java.io.Serializable;
import java.util.List;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;


/**
*
* @author Denalda Bali
*/

@Entity
@Table(name = "HALL")
@XmlRootElement
  @NamedQueries({
  @NamedQuery(name = "Hall.findAll", query = "SELECT h FROM Hall h"),
  @NamedQuery(name = "Hall.findById", query ="SELECT h FROM Hall h WHERE h.showId = :showId"),
  @NamedQuery(name = "Hall.findByNameOfHall", query ="SELECT h FROM Hall h WHERE h.nameOfHall = :nameOfHall"),
  @NamedQuery(name = "Hall.findBySeatsPlanRow", query ="SELECT h FROM Hall h WHERE h.seatsPlanRow = :seatsPlanRow"),
  @NamedQuery(name = "Hall.findBySeatsPlanColumns", query ="SELECT h FROM Hall h WHERE h.seatsPlanColumns = :seatsPlanColumns"),
  @NamedQuery(name = "Hall.findByTotalSeats", query ="SELECT h FROM Hall h WHERE h.totalSeats = :totalSeats"),})

public class Hall implements Serializable {
	
	  private static final long serialVersionUID = 1L;
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "THEATERHALLID")
	    private Integer theateHallId;
	
	    @Basic(optional = false)
	    @Column(name = "NAMEOFHALL")
	    private String nameOfHall;
	    
	    
	    @Basic(optional = false)
	    @Column(name = "SEATSPLANROWS")
	    private Integer seatsPlanRow;
	    
	    
	    @Basic(optional = false)
	    @Column(name = "SEATSPLANCOLUMNS")
	    private Integer seatsPlanColumns;
	    
	    @Basic(optional = false)
	    @Column(name = "TOTALSEATS")
	    private Integer totalSeats;
	    
	    
	    @OneToMany(mappedBy = "hall")
	    private List<Ticket> tickets;
	    
	 
	    @OneToMany(mappedBy = "hall")
	    private List<Show> shows;
	    
	    @ManyToOne
	    @JoinColumn(name = "theaterId", referencedColumnName = "theaterId")
	    private Theater theater;
	    
	   
	    
		public Hall() {
			
		}

		public Hall(Integer theateHallId, String nameOfHall, Integer seatsPlanRow, Integer seatsPlanColumns,
				Integer totalSeats) {
			super();
			this.theateHallId = theateHallId;
			this.nameOfHall = nameOfHall;
			this.seatsPlanRow = seatsPlanRow;
			this.seatsPlanColumns = seatsPlanColumns;
			this.totalSeats = totalSeats;
		}

		public Integer getTheateHallId() {
			return theateHallId;
		}

		public void setTheateHallId(Integer theateHallId) {
			this.theateHallId = theateHallId;
		}

		public String getNameOfHall() {
			return nameOfHall;
		}

		public void setNameOfHall(String nameOfHall) {
			this.nameOfHall = nameOfHall;
		}

		public Integer getSeatsPlanRow() {
			return seatsPlanRow;
		}

		public void setSeatsPlanRow(Integer seatsPlanRow) {
			this.seatsPlanRow = seatsPlanRow;
		}

		public Integer getSeatsPlanColumns() {
			return seatsPlanColumns;
		}

		public void setSeatsPlanColumns(Integer seatsPlanColumns) {
			this.seatsPlanColumns = seatsPlanColumns;
		}

		public Integer getTotalSeats() {
			return totalSeats;
		}

		public void setTotalSeats(Integer totalSeats) {
			this.totalSeats = totalSeats;
		}

		public List<Ticket> getTickets() {
			return tickets;
		}

		public void setTickets(List<Ticket> tickets) {
			this.tickets = tickets;
		}
		
		public List<Show> getShows() {
			return shows;
		}

		public void setShows(List<Show> shows) {
			this.shows = shows;
		}
		
		

		public Theater getTheater() {
			return theater;
		}

		public void setTheater(Theater theater) {
			this.theater = theater;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		 @Override
		    public int hashCode() {
		        int hash = 0;
		        hash += (theateHallId != null ? theateHallId.hashCode() : 0);
		        return hash;
		    }
	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Show)) {
	            return false;
	        }
	        Hall other = (Hall) object;
	        if ((this.theateHallId == null && other.theateHallId != null) || (this.theateHallId != null && !this.theateHallId.equals(other.theateHallId))) {
	            return false;
	        }
	        return true;
	    }

		 @Override
			public String toString() {
		        return "al.edu.unyt.advjava.webapps.thrater.entities.Hall[ theateHallId=" + theateHallId + " ]";
			}   
	    
	    
}
