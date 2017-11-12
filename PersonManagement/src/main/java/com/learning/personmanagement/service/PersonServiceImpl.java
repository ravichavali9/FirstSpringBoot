package com.learning.personmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.personmanagement.dao.PersonRepository;
import com.learning.personmanagement.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;
	
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	public Person addPerson(Person person) {
		return personRepository.save(person);
	}

	public Person updatePerson(Person person) throws Throwable {
		return null;
	}
}