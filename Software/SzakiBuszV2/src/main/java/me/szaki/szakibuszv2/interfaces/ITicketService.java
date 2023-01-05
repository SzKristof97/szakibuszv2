package me.szaki.szakibuszv2.interfaces;

import me.szaki.szakibuszv2.models.TicketEntity;

/**
* Interface for the ticket service
*/
public interface ITicketService {
    /**
     * Creates a new ticket and returns it if the creation was successful
     * @param ticketEntity the ticket to create
     * @return the created ticket if the creation was successful or null if it wasn't
     */
    TicketEntity registerTicket(TicketEntity ticketEntity);

    /**
     * Deletes the ticket and returns it if the deletion was successful
     * @param id the ticket to delete
     * @return the deleted ticket if the deletion was successful or null if it wasn't
     */
    TicketEntity deleteTicket(Integer id);

    /**
     * Updates the ticket and returns it if the update was successful
     * @param ticketEntity the ticket to update
     * @return the updated ticket if the update was successful or null if it wasn't
     */
    TicketEntity updateTicket(TicketEntity ticketEntity);

    /**
     * Gets the ticket by its id
     * @param id the id of the ticket
     * @return the ticket if it was found or null if it wasn't
     */
    TicketEntity getTicketById(int id);

    /**
     * Gets all the tickets
     * @return the tickets
     */
    Iterable<TicketEntity> getAllTickets();
}
