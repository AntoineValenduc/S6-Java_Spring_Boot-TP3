package org.example.s6tp3cinema.films.services;

import org.example.s6tp3cinema.films.dtos.ticket.TicketDto;
import org.example.s6tp3cinema.films.dtos.ticket.TicketReduitDto;

public interface SeanceServiceUpdatePlace {

    public TicketReduitDto reserverTicket(Integer id, TicketReduitDto dto);
}
