package com.accenture.academico.exceptions;

public class InsufficientFundsException extends RuntimeException {

	private static final long serialVersionUID = -7593700804981460225L;
	
	public InsufficientFundsException(String message) {
		super(message);
	}

}
