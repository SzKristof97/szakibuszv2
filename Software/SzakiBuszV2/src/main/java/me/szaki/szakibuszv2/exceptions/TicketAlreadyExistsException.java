package me.szaki.szakibuszv2.exceptions;

public class TicketAlreadyExistsException extends RuntimeException
{
    public TicketAlreadyExistsException(String message)
    {
        super(message);
    }
}
