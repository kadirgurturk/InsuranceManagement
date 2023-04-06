package org.csystem.app.Exceptions;

public class InvalidAuthenticationException extends RuntimeException{

    public InvalidAuthenticationException(String message) {
        super(message);
    }
}
