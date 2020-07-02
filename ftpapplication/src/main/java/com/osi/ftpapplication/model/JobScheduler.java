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
	String name;
	
    Long sourceLocationId;
	
    Long destinationLocationId;
    String schedule;
    LocalDateTime datetime;
    
    
	public JobScheduler() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSourceLocationId() {
		return sourceLocationId;
	}
	public void setSourceLocationId(Long sourceLocationId) {
		this.sourceLocationId = sourceLocationId;
	}
	public Long getDestinationLocationId() {
		return destinationLocationId;
	}
	public void setDestinationLocationId(Long destinationLocationId) {
		this.destinationLocationId = destinationLocationId;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "JobScheduler [id=" + id + ", name=" + name + ", sourceLocationId=" + sourceLocationId
				+ ", destinationLocationId=" + destinationLocationId + ", schedule=" + schedule + ", datetime="
				+ datetime + "]";
	}

   
}
