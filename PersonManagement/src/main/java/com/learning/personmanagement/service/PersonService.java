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
	public Person addPerson(@RequestParam(value="name", defaultValue = "unknown") String name,@RequestParam(value="id", defaultValue = "unknown") long id,@RequestParam(value="address", defaultValue = "unknown") String address){
		Person fellow = new Person(name,id,address);
		PersonManagementApplication.personRecord.put(new Long(fellow.getId()),fellow);
		return fellow;
	}
	
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public Person updatePerson(@RequestBody Person fellow) throws Exception{
		
		if(PersonManagementApplication.personRecord.containsKey(new Long(fellow.getId()))){
			PersonManagementApplication.personRecord.put(new Long(fellow.getId()), fellow);
		} else {
			throw new Exception("Person "+fellow.getId()+" doesn't exist");
		}
		return fellow;
	}
}