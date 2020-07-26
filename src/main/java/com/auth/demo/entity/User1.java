package com.auth.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class User1 {

	private Long id;
	private String username;
	private String name;
	private String password;
	private String email;
	private String mobile;

   public List<Roles> roles = new ArrayList<Roles>();
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		Roles r = new Roles();
		r.setName("ADMIN");
		this.roles = roles;
		roles.add(r);
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
    
    
    

}
