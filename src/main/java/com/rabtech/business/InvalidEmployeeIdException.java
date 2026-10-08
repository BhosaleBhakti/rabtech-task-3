package com.rabtech.business;

public class InvalidEmployeeIdException extends RuntimeException {

    public InvalidEmployeeIdException(String message) {
        super(message);
    }
}