package org.example;

public class PassengerNotFoundException extends RuntimeException {
    public PassengerNotFoundException(String message) {
        super(message);
    }
}
