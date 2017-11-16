package com.learning.personmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.personmanagement.dao.PersonRepository;
import com.learning.personmanagement.exceptions.EntityNotFoundException;
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

	public Person updatePerson(Person person) throws EntityNotFoundException {
		Person p = findCheckedPerson(person.getId());
		p.copy(person);
		return personRepository.save(p);
	}

	public void deletePerson(long id) {
		personRepository.delete(id);
	}
	
	public Person findCheckedPerson(long id) throws EntityNotFoundException {
		Person p = personRepository.findOne(id);
		if(null == p) {
			throw new EntityNotFoundException(id);
		}
		return p;
	}
}