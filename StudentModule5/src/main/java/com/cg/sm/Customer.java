package com.cg.sm;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity    //From the java class it will mapped to the Database table. 
//@Entity it will go and interact with database table.
public class Customer {
	
	private int id;
	private String name;
	private int order_details;
	private String email;
	
	public Customer() {              // constructor
		super();
    }
	
	public Customer(int id, String name, int order_details, String email) {
		super();
		this.id = id;
		this.name = name;
		this.order_details = order_details;
		this.email = email;
	}
	
    @Id                       //Primary Key
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrder_details() {
		return order_details;
	}
	public void setOrder_details(int order_details) {
		this.order_details = order_details;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", order_details=" + order_details + ", email=" + email + "]";
	}
	

}
