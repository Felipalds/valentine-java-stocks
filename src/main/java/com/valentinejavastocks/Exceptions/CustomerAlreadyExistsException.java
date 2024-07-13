package com.valentinejavastocks.Exceptions;

public class CustomerAlreadyExistsException extends RuntimeException{
    public CustomerAlreadyExistsException () {
        super ("Customer Already Exists");
    }
}
