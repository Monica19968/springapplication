package com.osi.ftpapplication.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JobHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	Integer schedulerId;
	LocalDateTime datetime;
	boolean status;
	String description;

	public JobHistory() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSchedulerId() {
		return schedulerId;
	}

	public void setSchedulerId(Integer schedulerId) {
		this.schedulerId = schedulerId;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "JobHistory [id=" + id + ", schedulerId=" + schedulerId + ", datetime=" + datetime + ", status=" + status
				+ ", description=" + description + "]";
	}

}
