package com.accenture.academico.exceptions;

public class InvalidAccountException extends RuntimeException {

	private static final long serialVersionUID = 1339407377889786332L;

	public InvalidAccountException(String message) {
		super(message);
	}
}
