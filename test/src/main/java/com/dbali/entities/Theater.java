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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "THEATER")
@XmlRootElement
  @NamedQueries({
  @NamedQuery(name = "Theater.findAll", query = "SELECT t FROM Theater t"),
  @NamedQuery(name = "Theater.findById", query ="SELECT t FROM Theater t WHERE t.theaterId = :theaterId"),
  @NamedQuery(name = "Theater.findByName", query ="SELECT t FROM Theater t WHERE t.name = :name"),
  @NamedQuery(name = "Theater.findByTotalTheaterHalls", query ="SELECT t FROM Theater t WHERE t.totalTheaterHalls = :totalTheaterHalls"),})

public class Theater implements Serializable {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "THEAERID")
	    private Integer theaterId;
	    
	    @Basic(optional = false)
	    @Column(name = "NAME")
	    private String name;
	    
	    @Basic(optional = false)
	    @Column(name = "TOTALTHEATERHALLS")
	    private Integer totalTheaterHalls;
	    
	    @OneToMany(mappedBy = "theater")
	    private List<Hall> halls;
	    
	    

		public Theater() {
			
		}

		public Theater(Integer theaterId, String name, Integer totalTheaterHalls) {
			super();
			this.theaterId = theaterId;
			this.name = name;
			this.totalTheaterHalls = totalTheaterHalls;
		}

		public Integer getTheaterId() {
			return theaterId;
		}

		public void setTheaterId(Integer theaterId) {
			this.theaterId = theaterId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getTotalTheaterHalls() {
			return totalTheaterHalls;
		}

		public void setTotalTheaterHalls(Integer totalTheaterHalls) {
			this.totalTheaterHalls = totalTheaterHalls;
		}

		

		public List<Hall> getHalls() {
			return halls;
		}

		public void setHalls(List<Hall> halls) {
			this.halls = halls;
		}

		@Override
		public int hashCode() {
			 int hash = 0;
		        hash += (theaterId != null ? theaterId.hashCode() : 0);
		        return hash;
		}

		@Override
		public boolean equals(Object object) {
		    // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Theater)) {
	            return false;
	        }
	        Theater other = (Theater) object;
	        if ((this.theaterId == null && other.theaterId != null) || (this.theaterId != null && !this.theaterId.equals(other.theaterId))) {
	            return false;
	        }
	        return true;
		}

		@Override
		public String toString() {
			return "al.edu.unyt.advjava.webapps.thrater.entities.Theater[ theaterId=" + theaterId + " ]";
		}
	    
	    
	    
	    
}
