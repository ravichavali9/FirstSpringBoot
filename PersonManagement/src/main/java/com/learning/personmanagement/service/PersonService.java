package com.learning.personmanagement.service;

import java.util.List;

import com.learning.personmanagement.exceptions.EntityNotFoundException;
import com.learning.personmanagement.model.Person;

public interface PersonService {
	
	public List<Person> getAllPersons();
	
	public Person addPerson(Person person);
	
	public Person updatePerson(Person person) throws EntityNotFoundException;
	
	public void deletePerson(long id);
}