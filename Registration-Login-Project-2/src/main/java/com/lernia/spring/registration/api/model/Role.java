package com.lernia.spring.registration.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Role {
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role=" + role + "]";
	}
	@Id
	private int role_id;
	private String role;
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Role() {
		
	}
	
	public Role(int role_id, String role) {
		this.role_id = role_id;
		this.role = role;
	}
	

}
