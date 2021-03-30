package com.accenture.academico.exceptions;

public class InvalidDepositeValueException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidDepositeValueException(String message) {
		super(message);
	}

}
