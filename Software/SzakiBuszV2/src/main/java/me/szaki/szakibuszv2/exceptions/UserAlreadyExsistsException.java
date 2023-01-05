package me.szaki.szakibuszv2.exceptions;

public class UserAlreadyExsistsException extends RuntimeException {
    public UserAlreadyExsistsException(String message) {
        super(message);
    }
}
