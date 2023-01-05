package me.szaki.szakibuszv2.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {

        super(message);
    }
}
