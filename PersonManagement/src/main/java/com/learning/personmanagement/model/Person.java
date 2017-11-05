package com.learning.personmanagement.model;

import java.time.LocalDate;

public class Person {
	
	private String personName;
	
	private long personId;
	
	private String personAddress;
	
	private LocalDate personDOB;
	
	public Person(){
	}
	
	public Person(String personName, long personId, String personAddress){
		this.personName = personName;
		this.personId = personId;
		this.personAddress = personAddress;
	}
	
	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getPersonAddress() {
		return personAddress;
	}

	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}

	/*public LocalDate getPersonDOB() {
		return personDOB;
	}*/

	public void setPersonDOB(LocalDate personDOB) {
		this.personDOB = personDOB;
	}	
	
}