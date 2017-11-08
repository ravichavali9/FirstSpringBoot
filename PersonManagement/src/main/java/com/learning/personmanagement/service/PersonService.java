package com.learning.personmanagement.service;

import java.util.Map;

import com.learning.personmanagement.model.Person;

public interface PersonService {
	
	public Map<Long,Person> getAllPersons();
	
	public Person addPerson(Person person);
	
	public Person updatePerson(Person person) throws Throwable;
}