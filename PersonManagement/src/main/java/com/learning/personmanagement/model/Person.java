package com.learning.personmanagement.model;

import java.time.LocalDate;

public class Person {
	
	private String name;
	
	private long id;
	
	private String address;
	
	private LocalDate DOB;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	
	public Person(){
	}
	
	public Person(String name, long id, String address){
		this.name = name;
		this.id = id;
		this.address = address;
	}	
	
}