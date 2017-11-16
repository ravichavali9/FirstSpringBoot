package com.learning.personmanagement.exceptions;

public class EntityNotFoundException extends Exception {
	public EntityNotFoundException(long id) {
		super("Entity with ID = " +id+ " Not Found");
	}
}
