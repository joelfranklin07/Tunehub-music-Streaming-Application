package com.example.tunehub.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="users")
public class users 
{
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	int id;
	String username;
	String email;
	String password;
	String gender;
	String role;
	String address;
	
	boolean ispremium;
	String reset_password;
	public users() 
	{
		super();	
	}
	@Column(insertable=false, updatable=false)
	private String resetpassword;
	public users(int id, String username, String email, String password, String gender, String role, String address,
			String reset_password, boolean ispremium)
	{
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.role = role;
		this.address = address;
		this.reset_password = reset_password;
		this.ispremium = ispremium;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getReset_password() {
		return reset_password;
	}
	public void setReset_password(String reset_password) {
		this.reset_password = reset_password;
	}
	public boolean isIspremium() {
		return ispremium;
	}
	public void setIspremium(boolean ispremium) {
		this.ispremium = ispremium;
	}
	@Override
	public String toString() {
		return "users [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", role=" + role + ", address=" + address + ", reset_password="
				+ reset_password + ", ispremium=" + ispremium + "]";
	}
	public void setResetPasswordToken(String token) {
		// TODO Auto-generated method stub
		
	}
	

	
}
