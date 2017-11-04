package com.learning.personmanagement.service;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.personmanagement.PersonManagementApplication;
import com.learning.personmanagement.model.Person;

@RestController
@RequestMapping(value="/rest/person")
public class PersonService {
	@RequestMapping(value="/",method= RequestMethod.GET)
	public Map<Long,Person> getAllPersons(){
		return PersonManagementApplication.personRecord;
	}
}
