package com.learning.personmanagement.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.personmanagement.PersonManagementApplication;
import com.learning.personmanagement.model.Person;

@Service
@RestController
@RequestMapping(value="rest/person")
public class PersonServiceImpl implements PersonService {

	@RequestMapping(value="/",method = RequestMethod.GET)
	public Map<Long, Person> getAllPersons() {
		return PersonManagementApplication.personRecord;
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public Person addPerson(@RequestBody Person person) {
		if(person != null)
		{
			PersonManagementApplication.personRecord.put(new Long(person.getId()),person);
			return person;
		}
		return null;
	}

	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public Person updatePerson(@RequestBody Person person) throws Throwable {
		if(PersonManagementApplication.personRecord.containsKey(new Long(person.getId()))){
			PersonManagementApplication.personRecord.put(new Long(person.getId()), person);
		} else {
			throw new Exception("Person "+person.getId()+" doesn't exist");
		}
		return person;
	}
}
