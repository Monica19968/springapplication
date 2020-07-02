package com.osi.ftpapplication.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JobScheduler {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	Integer id;
	String schedulerName;
	
    String sourceLocation;
	
    String destinationLocation;
    String frequency;
    LocalDateTime datetime;
	public JobScheduler() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSchedulerName() {
		return schedulerName;
	}
	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}
	public String getSourceLocation() {
		return sourceLocation;
	}
	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}
	
	public String getDestinationLocation() {
		return destinationLocation;
	}
	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "JobScheduler [id=" + id + ", schedulerName=" + schedulerName + ", sourceLocation=" + sourceLocation
				+ ", destinationLocation=" + destinationLocation + ", frequency=" + frequency + ", datetime=" + datetime
				+ "]";
	}
    
    

}
