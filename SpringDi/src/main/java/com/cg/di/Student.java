package com.cg.di;

public class Student {

	private String  name;
	private int id;
	

	public Student(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}


	void display()
	{
		System.out.println(" The student Id:"+ id); 
		System.out.println(" The student name:"+ name); 
	}
}
