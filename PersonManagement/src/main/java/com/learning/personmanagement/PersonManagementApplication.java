package com.learning.personmanagement;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.personmanagement.model.Person;

@SpringBootApplication
public class PersonManagementApplication {

	public static Map<Long,Person> personRecord;
	
	public static void main(String[] args) {
		Person fellowOne = new Person("Gill", 111l,"123 Helm St");
		Person fellowTwo = new Person("Smith", 222l,"7655 jenry Rd");
		Person fellowThree = new Person("Paul", 333l,"104 king tn");
		
		personRecord = new HashMap<Long,Person>();
		
		personRecord.put(fellowOne.getId(),fellowOne);
		personRecord.put(fellowTwo.getId(),fellowTwo);
		personRecord.put(fellowThree.getId(),fellowThree);
		
		SpringApplication.run(PersonManagementApplication.class, args);
	}
}
