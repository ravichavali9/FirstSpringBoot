package com.learning.personmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.personmanagement.PersonManagementApplication;
import com.learning.personmanagement.model.Person;
import com.learning.personmanagement.service.PersonService;


@RestController
@RequestMapping(value="/person")
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

	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public Person updatePerson(@RequestBody Person person) throws Throwable {
		/*if(PersonManagementApplication.personRecord.containsKey(new Long(person.getId()))){
			PersonManagementApplication.personRecord.put(new Long(person.getId()), person);
		} else {
			throw new Exception("Person "+person.getId()+" doesn't exist");
		}*/
		return person;
	}
}