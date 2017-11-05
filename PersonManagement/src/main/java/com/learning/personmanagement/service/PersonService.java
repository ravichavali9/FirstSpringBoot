package com.learning.personmanagement.service;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.personmanagement.PersonManagementApplication;
import com.learning.personmanagement.model.Person;

@RestController
@RequestMapping(value="/rest/person")
public class PersonService {
	@RequestMapping(value="/",method = RequestMethod.GET)
	public Map<Long,Person> getAllPersons(){
		return PersonManagementApplication.personRecord;
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public Person addPerson(@RequestParam(value="personName", defaultValue = "unknown") String personName,@RequestParam(value="personId", defaultValue = "unknown") long personId,@RequestParam(value="personAddress", defaultValue = "unknown") String personAddress){
		Person fellow = new Person(personName,personId,personAddress);
		PersonManagementApplication.personRecord.put(new Long(fellow.getPersonId()),fellow);
		return fellow;
	}
	
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public Person updatePerson(@RequestBody Person fellow) throws Exception{
		
		if(PersonManagementApplication.personRecord.containsKey(new Long(fellow.getPersonId()))){
			PersonManagementApplication.personRecord.put(new Long(fellow.getPersonId()), fellow);
		} else {
			throw new Exception("Person "+fellow.getPersonId()+" doesn't exist");
		}
		return fellow;
	}
}