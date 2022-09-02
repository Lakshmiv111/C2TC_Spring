package com.cg.sm;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity                    //From the java class it will mapped to the Database table. @Entity it will go and interact with database table.  
public class Admin {

	private int id;
	private String name;
	private String password;
	private int phone;
	
	public Admin()          // constructor
	{
		super();
	}

	public Admin(int id, String name, String password, int phone) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}
	@Id                            //Primary Key
	public int getId() {
		return id;
	}

	
	public void setId(int id) {                      
		this.id = id;
	}

	public String getName() {                                
		return name;
	}

	public void setName(String name) {                          //setters method  
		this.name = name;
	}

	public String getPassword() {                        //getters method means collecting, get Balanced method
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

	@Override
	public String toString() {             //override toString Method belongs to object class
		return "MallAdmin [id=" + id + ", name=" + name + ", password=" + password + ", phone=" + phone + "]";
	}
}