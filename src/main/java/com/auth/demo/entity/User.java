package com.auth.demo.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;


@Entity
@Table(name="users")
@NamedQueries({
@NamedQuery(name="User.fetchUserByUserNameOrEmail",query="Select u from User u where u.userName=?1 or u.email=?2"),
@NamedQuery(name="User.fetchUserById",query="Select u from User u where u.id=?1")})
public class User {
	
	@Id
	@Column(name="userid",nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="username",nullable=false)
	private String userName;
	@Column(name="name",nullable=false,length=150)
	private String name;
	@Column(name="password",nullable=false)
	private String password;
	@Email
	@Column(name="email",nullable=false)
	private String email;
	@Column(name="mobile",nullable=false,length=10)
	private String mobile;
	
	@Column(name="roles",nullable=false)
	private String roles;
	
	@Column(name="status",nullable=false)
	private int status;
	
	@Column(name="createddate")
	private Timestamp createdDate;
	@Column(name="updateddate")
	private Timestamp updatedDate;
	
	/*public List<Roles> roles = new ArrayList<Roles>();
	
	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		Roles r = new Roles();
		r.setName("ADMIN");
		this.roles = roles;
		roles.add(r);
	}*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = new Timestamp(System.currentTimeMillis());
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	
	
	

}
