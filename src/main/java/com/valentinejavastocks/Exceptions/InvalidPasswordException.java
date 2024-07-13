package com.valentinejavastocks.Exceptions;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException () {
        super("Invalid Password!");
    }
}
