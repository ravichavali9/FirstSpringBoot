package com.learning.personmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.personmanagement.model.Person;

public interface PersonRepository extends JpaRepository<Person,Long>{
	
}