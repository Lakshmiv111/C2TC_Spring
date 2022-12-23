package com.hyrathon.sm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

//From the java class it will mapped to the Database table.
//@Entity it will go and interact with database table. 
//if you want to create table in MySql database for given variable then u can go for @Entity.
public class User {

	private int id;
	private String email;
	private int phone;
	private String firstname;
	private String lastname;
	private String password;
	
//right click=>Source=>Generate Constructors from Superclass.	
	public User() {
		
		super();  // constructors
		
	}


//right click=>Source=>Generate Constructors using Fields.
	public User(int id, String email, int phone, String firstname, String lastname, String password) {
		super();
		this.id = id;
		this.email = email;
		this.phone = phone;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}
//right click=>Source=>Generate Getters and Setters.
	
@Id     //Primary Key
 
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
// If you want to print the given variables then go for toString method
	//right click=>Source=>Generate toString().
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", phone=" + phone + ", firstname=" + firstname + ", lastname="
				+ lastname + ", password=" + password + "]";
	}
	
		
		
}
