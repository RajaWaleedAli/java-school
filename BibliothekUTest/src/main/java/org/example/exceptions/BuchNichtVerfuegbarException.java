package org.example.exceptions;

public class BuchNichtVerfuegbarException extends Exception {
    public BuchNichtVerfuegbarException(String message) {
        super(message);
    }
}