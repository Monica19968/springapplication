package com.osi.ftpapplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;



@Entity
@Configuration
@ConfigurationProperties(prefix = "ftp")
public class FTPLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	Integer id;
	@NotBlank(message="name should not be empty")
	String locationName;
	@NotBlank(message="url should not be empty")
	String locationUrl;
	String Server;
	@NotBlank(message="username should not be empty")
	@Size(max=6, message="username must have atleast 8 characters")
	String userName;
	@NotBlank(message="password should not be empty")
	@Size(max=8, message="password must have atleast 6 characters")
	String password;
	int port;
	public FTPLocation() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getLocationUrl() {
		return locationUrl;
	}
	public void setLocationUrl(String locationUrl) {
		this.locationUrl = locationUrl;
	}
	public String getServer() {
		return Server;
	}
	public void setServer(String server) {
		Server = server;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	@Override
	public String toString() {
		return "FTPLocation [id=" + id + ", locationName=" + locationName + ", locationUrl=" + locationUrl + ", Server="
				+ Server + ", userName=" + userName + ", password=" + password + ", port=" + port + "]";
	}

	
}
