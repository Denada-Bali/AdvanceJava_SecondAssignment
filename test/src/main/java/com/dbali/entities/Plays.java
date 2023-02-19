package com.dbali.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

public class Plays implements Serializable {

	 private static final long serialVersionUID = 1L;
	 
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "MOVIEID")
	    private Integer movieId;
	
	    @Basic(optional = false)
	    @Column(name = "TITLE")
	    private String title;
	    
	    @Basic(optional = false)
	    @Column(name = "WRITER")
	    private String writer;
	    
	    @Basic(optional = false)
	    @Column(name = "DIRECTOR")
	    private String director;
	    
	    @Basic(optional = false)
	    @Column(name = "ACTORS")
	    private String actors;
	    
	    
	    @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(name = "showId", joinColumns = @JoinColumn(name = "movieId"),
	        inverseJoinColumns = @JoinColumn(name = "theaterHallId"))
	    private List<Show> shows;
	    
	    
	    @OneToMany(mappedBy = "play")
	    private List<Ticket> tickets;
	   
  	    
		public Plays() {
			
		}
	
		public Plays(Integer movieId, String title, String writer, String director, String actors) {
			super();
			this.movieId = movieId;
			this.title = title;
			this.writer = writer;
			this.director = director;
			this.actors = actors;
		}

		public Integer getMovieId() {
			return movieId;
		}

		public void setMovieId(Integer movieId) {
			this.movieId = movieId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getWriter() {
			return writer;
		}

		public void setWriter(String writer) {
			this.writer = writer;
		}

		public String getDirector() {
			return director;
		}

		public void setDirector(String director) {
			this.director = director;
		}

		public String getActors() {
			return actors;
		}

		public void setActors(String actors) {
			this.actors = actors;
		}
		
		public List<Show> getShows() {
			return shows;
		}

		public void setShows(List<Show> shows) {
			this.shows = shows;
		}

		public List<Ticket> getTickets() {
			return tickets;
		}

		public void setTickets(List<Ticket> tickets) {
			this.tickets = tickets;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		 @Override
		    public int hashCode() {
		        int hash = 0;
		        hash += (movieId != null ? movieId.hashCode() : 0);
		        return hash;
		    }
	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Plays)) {
	            return false;
	        }
	        Plays other = (Plays) object;
	        if ((this.movieId == null && other.movieId != null) || (this.movieId != null && !this.movieId.equals(other.movieId))) {
	            return false;
	        }
	        return true;
	    }

		@Override
		public String toString() {
			 return "al.edu.unyt.advjava.webapps.thrater.entities.Plays[ showId=" + movieId + " ]";
		}
	    
	    
	    
	    
}
