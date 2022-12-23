package com.hyrathon.sm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity           
//From the java class it will mapped to the Database table. @Entity it will go and interact with database table.  
//From the java class it will mapped to the Database table.
//@Entity it will go and interact with database table.
public class User {

	
	private int id;
	private String email;
	private String firstname;
	private String lastname;
	private String password;
	private int phone;
	
	//right click=>Source=>Generate Constructors from Superclass.
	public User() {
		super();
		
		//right click=>Source=>Generate Constructors using Fields.	
	}

	public User(int id, String email, String firstname, String lastname, String password, int phone) {
		super();
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.phone = phone;
	}
	
	
@Id       //Primary Key


//right click=>Source=>Generate Getters and Setters.
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	
	//right click=>Source=>Generate toString()
	@Override
	public String toString() {
		return "UserService [id=" + id + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", password=" + password + ", phone=" + phone + "]";
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
