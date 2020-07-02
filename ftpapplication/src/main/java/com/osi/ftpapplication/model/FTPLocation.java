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
	
	Integer ID;
	@NotBlank(message="name should not be empty")
	String name;
	@NotBlank(message="url should not be empty")
	String url;
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
	
	public String getServer() {
		return Server;
	}


	public void setServer(String server) {
		Server = server;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}

	
	public Integer getID() {
		return ID;
	}


	public void setID(Integer ID) {
		this.ID = ID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String url() {
		return url;
	}


	public void seturl(String url) {
		this.url = url;
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


	@Override
	public String toString() {
		return "FTPLocation [ftpID=" + ID + ", ftpurl=" + url + ", userName=" + userName + ", password="
				+ password + "]";
	}

}
