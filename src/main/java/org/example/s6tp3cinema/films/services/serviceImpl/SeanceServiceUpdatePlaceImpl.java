package org.example.s6tp3cinema.films.services.serviceImpl;

import org.example.s6tp3cinema.films.dtos.ticket.TicketDto;
import org.example.s6tp3cinema.films.dtos.ticket.TicketReduitDto;
import org.example.s6tp3cinema.films.services.SeanceServiceUpdatePlace;
import org.example.s6tp3cinema.films.services.TicketService;
import org.springframework.stereotype.Service;

@Service
public class SeanceServiceUpdatePlaceImpl implements SeanceServiceUpdatePlace {

    private final TicketService ticketService;

    public SeanceServiceUpdatePlaceImpl(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public TicketReduitDto reserverTicket(Integer id, TicketReduitDto dto) {
        ticketService.createTicket(id, dto);
        return dto;
    }
}
