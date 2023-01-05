package me.szaki.szakibuszv2.controllers;

import me.szaki.szakibuszv2.controllers.forms.RegisterTicketForm;
import me.szaki.szakibuszv2.exceptions.TicketAlreadyExistsException;
import me.szaki.szakibuszv2.exceptions.TicketNotFoundException;
import me.szaki.szakibuszv2.models.TicketEntity;
import me.szaki.szakibuszv2.services.TicketService;
import me.szaki.szakibuszv2.utilities.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/api", produces = "application/json")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    //<editor-fold default-state="collapsed" desc="GET mapping methods">

    @GetMapping("/ticket/all")
    public Iterable<TicketEntity> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/ticket/bid")
    public TicketEntity getTicketById(@RequestBody Integer id) {
        return ticketService.getTicketById(id);
    }
    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="POST mapping methods">
    @PostMapping("/ticket/register")
    public TicketEntity registerTicket(@RequestBody RegisterTicketForm ticketForm) {
        return ticketService.registerTicket(ticketForm.toTicketEntity());
    }

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="PUT mapping methods">
    @PutMapping("/ticket/update")
    public TicketEntity updateTicket(@RequestBody RegisterTicketForm ticketForm) {
        return ticketService.updateTicket(ticketForm.toTicketEntity());
    }

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="DELETE mapping methods">

    @DeleteMapping("/ticket/delete")
    public void deleteTicket(@RequestBody Integer id) {
        ticketService.deleteTicket(id);
    }

    //</editor-fold>


    //<editor-fold default-state="collapsed" desc="Exception Handling">
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception e) {
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ExceptionHandler(value = TicketAlreadyExistsException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorResponse handleTicketAlreadyExistsException(TicketAlreadyExistsException e) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage());
    }

    @ExceptionHandler(value = TicketNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handleTicketNotFoundException(TicketNotFoundException e) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
    //</editor-fold>
}
