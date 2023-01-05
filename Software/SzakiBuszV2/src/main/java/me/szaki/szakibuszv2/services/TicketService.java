package me.szaki.szakibuszv2.services;

import io.swagger.v3.oas.annotations.Parameter;
import me.szaki.szakibuszv2.exceptions.TicketAlreadyExistsException;
import me.szaki.szakibuszv2.exceptions.TicketNotFoundException;
import me.szaki.szakibuszv2.interfaces.ITicketService;
import me.szaki.szakibuszv2.models.TicketEntity;
import me.szaki.szakibuszv2.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    @Parameter(name = "ticketEntity", description = "The ticket to be created")
    @Description("Creates a ticket.")
    public TicketEntity registerTicket(TicketEntity ticketEntity) {
        // Check if the ticket with the same type already exists
        Optional<TicketEntity> ticket = ticketRepository.findByType(ticketEntity.getType());
        if(ticket.isPresent()) {
            throw new TicketAlreadyExistsException("Ticket already exists");
        }

        // If not, save the ticket
        return ticketRepository.save(ticketEntity);
    }

    @Override
    @Parameter(name = "id", description = "The ticket id")
    @Description("Deletes a ticket.")
    public TicketEntity deleteTicket(Integer id) {
        // Check if the ticket with the given id is present
        Optional<TicketEntity> ticket = ticketRepository.findById(id);
        if(!ticket.isPresent()) {
            throw new TicketNotFoundException("Ticket does not exist");
        }

        // If not, delete the ticket
        ticketRepository.delete(ticket.get());
        return ticket.get();
    }

    @Override
    @Parameter(name = "ticketEntity", description = "The ticket to be updated")
    @Description("Updates a ticket.")
    public TicketEntity updateTicket(TicketEntity ticketEntity) {
        // Check if the ticket with the given id is present
        Optional<TicketEntity> ticket = ticketRepository.findById(ticketEntity.getId());
        if(!ticket.isPresent()) {
            throw new TicketNotFoundException("Ticket does not exist");
        }

        // If exists, update the ticket
        TicketEntity updatedTicket = ticket.get();
        updatedTicket.setType(ticketEntity.getType());
        updatedTicket.setPrice(ticketEntity.getPrice());
        updatedTicket.setExpirationDate(ticketEntity.getExpirationDate());

        return ticketRepository.save(updatedTicket);
    }

    @Override
    @Parameter(name = "id", description = "The id of the ticket")
    @Description("Returns a ticket by its id.")
    public TicketEntity getTicketById(int id) {
        // Check if the ticket with the given id is present
        Optional<TicketEntity> ticket = ticketRepository.findById(id);
        if(!ticket.isPresent()) {
            throw new TicketNotFoundException("Ticket does not exist");
        }

        return ticket.get();
    }

    @Override
    @Description("Returns all tickets.")
    public Iterable<TicketEntity> getAllTickets() {
        // Check if there are any tickets in the database
        Iterable<TicketEntity> tickets = ticketRepository.findAll();
        if(!tickets.iterator().hasNext()) {
            throw new TicketNotFoundException("There are no tickets in the database");
        }

        return tickets;
    }
}
