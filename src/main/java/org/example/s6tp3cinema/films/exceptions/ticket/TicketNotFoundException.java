package org.example.s6tp3cinema.films.exceptions.ticket;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TicketNotFoundException extends NullPointerException {

    public TicketNotFoundException(Integer id){
        super("Le Ticket n'existe pas en bdd pour l'id : " + id);
    }
}
