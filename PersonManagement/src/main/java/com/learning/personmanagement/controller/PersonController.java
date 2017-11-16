package com.learning.personmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.personmanagement.exceptions.EntityNotFoundException;
import com.learning.personmanagement.model.Person;
import com.learning.personmanagement.service.PersonService;


@RestController
//telling IOC that this class is a rest controller
@RequestMapping(value="/person")
//telling the IOC
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public @ResponseBody Person addPerson(@RequestBody(required = true) Person person) {
		return personService.addPerson(person);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public Person updatePerson(@RequestBody Person person) throws EntityNotFoundException {
		return personService.updatePerson(person);
	}
	
	@RequestMapping(value="/delete/{person_id}", method = RequestMethod.DELETE)
	public void deletePerson(@PathVariable("person_id") long id) {
		personService.deletePerson(id);
	}
}