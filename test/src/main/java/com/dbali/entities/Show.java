package com.dbali.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "SHOW")
@XmlRootElement
  @NamedQueries({
  @NamedQuery(name = "Show.findAll", query = "SELECT s FROM Show s"),
  @NamedQuery(name = "Show.findById", query ="SELECT s FROM Show s WHERE s.showId = :showId"),
  @NamedQuery(name = "Show.findByStartDate", query ="SELECT s FROM Show s WHERE s.startDate = :startDate"),
  @NamedQuery(name = "Show.findByStartTime", query ="SELECT s FROM Show s WHERE s.startTime = :startTime"),
  @NamedQuery(name = "Show.findByEndTime", query ="SELECT s FROM Show s WHERE s.endTime = :endTime"),})

public class Show implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "SHOWID")
	    private Integer showId;
	
	    @Basic(optional = false)
	    @Column(name = "STARTDATE")
	    private String startDate;
	    
	    @Basic(optional = false)
	    @Column(name = "STARTTIME")
	    private String startTime;
	    
	    
	    @Basic(optional = false)
	    @Column(name = "ENDTIME")
	    private String endTime;
	   
	    
	    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "showsId")
	    private List<Plays> plays;
	    
	

		public Show() {
	
		}

		public Show(Integer showId, String startDate, String startTime, String endTime) {
			super();
			this.showId = showId;
			this.startDate = startDate;
			this.startTime = startTime;
			this.endTime = endTime;
		}

	    
		public Integer getShowId() {
			return showId;
		}

		public void setShowId(Integer showId) {
			this.showId = showId;
		}

		public String getStartDate() {
			return startDate;
		}

		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}

		public String getStartTime() {
			return startTime;
		}

		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}

		public String getEndTime() {
			return endTime;
		}

		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		 @Override
		    public int hashCode() {
		        int hash = 0;
		        hash += (showId != null ? showId.hashCode() : 0);
		        return hash;
		    }
	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Show)) {
	            return false;
	        }
	        Show other = (Show) object;
	        if ((this.showId == null && other.showId != null) || (this.showId != null && !this.showId.equals(other.showId))) {
	            return false;
	        }
	        return true;
	    }

		 @Override
			public String toString() {
		        return "al.edu.unyt.advjava.webapps.thrater.entities.Show[ showId=" + showId + " ]";
			}   
	    
}
