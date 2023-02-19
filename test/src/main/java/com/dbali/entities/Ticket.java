package com.dbali.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "TICKET")
@XmlRootElement
  @NamedQueries({
  @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
  @NamedQuery(name = "Ticket.findById", query ="SELECT t FROM Ticket t WHERE t.ticketId = :ticketId"),})
  
public class Ticket implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "TICKETID")
	    private Integer ticketId;
	    
	  @ManyToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "customerId")
	  private Customer customer;

	  @ManyToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "movieId")
	  private Plays play;

	  @ManyToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "theaterHallId")
	  private Hall hall;
	    
	    @Basic(optional = false)
	    @Column(name = "TICKETPRICE")
	    private Integer ticketPrice;
	    
		public Ticket() {
			
		}

		public Ticket(Integer ticketId,	Integer ticketPrice) {
			super();
			this.ticketId = ticketId;
			this.ticketPrice = ticketPrice;
		}

		public Integer getTicketId() {
			return ticketId;
		}

		public void setTicketId(Integer ticketId) {
			this.ticketId = ticketId;
		}
		
		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Plays getPlay() {
			return play;
		}

		public void setPlay(Plays play) {
			this.play = play;
		}

		public Hall getHall() {
			return hall;
		}

		public void setHall(Hall hall) {
			this.hall = hall;
		}

		public Integer getTicketPrice() {
			return ticketPrice;
		}

		public void setTicketPrice(Integer ticketPrice) {
			this.ticketPrice = ticketPrice;
		}

		@Override
		public int hashCode() {
			 int hash = 0;
		        hash += (ticketId != null ? ticketId.hashCode() : 0);
		        return hash;
		}

		@Override
		public boolean equals(Object object) {
		    // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Ticket)) {
	            return false;
	        }
	        Ticket other = (Ticket) object;
	        if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
	            return false;
	        }
	        return true;
		}

		@Override
		public String toString() {
			return "al.edu.unyt.advjava.webapps.thrater.entities.Ticket[ ticketId=" + ticketId + " ]";
		}
	    
	    
}
