package me.szaki.szakibuszv2.exceptions;

public class TicketNotFoundException extends RuntimeException
{
    public TicketNotFoundException(String message)
    {
        super(message);
    }
}
