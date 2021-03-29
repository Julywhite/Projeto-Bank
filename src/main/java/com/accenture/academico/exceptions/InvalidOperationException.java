package com.accenture.academico.exceptions;

public class InvalidOperationException extends RuntimeException{

	private static final long serialVersionUID = 1339407377889786332L;

		public InvalidOperationException(String message) {
			super(message);
		}
}
