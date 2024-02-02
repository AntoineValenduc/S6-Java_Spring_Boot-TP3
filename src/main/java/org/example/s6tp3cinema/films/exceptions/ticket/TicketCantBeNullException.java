package org.example.s6tp3cinema.films.exceptions.ticket;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TicketCantBeNullException extends IllegalArgumentException {

    public TicketCantBeNullException(){
        super("Le Ticket ne peut pas être null");
    }

    public TicketCantBeNullException(List<String> properties){
        super("Les propriétés ne peuvent pas être null : " + properties);
    }
}
