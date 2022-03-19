package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@Column(name = "administrator_id")
	private int administratorId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private String role;
	
	public User() {
		super();
	}

	public User(int administratorId, String username, String password, String role) {
		super();
		this.administratorId = administratorId;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getAdministratorId() {
		return administratorId;
	}

	public void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
