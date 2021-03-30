package com.accenture.academico.exceptions;

public class InvalidCpfException extends RuntimeException{

    private static final long serialVersionUID = -7593700804981460225L;

    public InvalidCpfException(String message) {
        super(message);
    }

}
