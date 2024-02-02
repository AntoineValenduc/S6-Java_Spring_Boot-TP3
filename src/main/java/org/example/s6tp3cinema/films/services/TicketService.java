package org.example.s6tp3cinema.films.services;

import org.example.s6tp3cinema.films.dtos.ticket.TicketDto;
import org.example.s6tp3cinema.films.dtos.ticket.TicketReduitDto;

import java.util.List;
import java.util.Optional;

public interface TicketService {

    /**
     * Retourne la liste des Tickets Complet
     * @return Liste TicketDto
     */
    public List<TicketReduitDto> getAllTickets();

    /**
     * Retourne un Ticket Complet, à partir de son ID
     * @param id Integer
     * @return TicketDto
     */
    public Optional<TicketDto> getById(Integer id);

    /**
     * Crée un nouveau Ticket
     * @param dto TicketDto
     */
    public void createTicket(TicketDto dto);

    /**
     * Crée un nouveau Ticket depuis la Séance
     * @param dto TicketReduitDto
     */
    public void createTicket(Integer id, TicketReduitDto dto);

    /**
     * Modifie un Ticket déjà existant
     * @param dto TicketDto
     */
    public void updateTicket(TicketDto dto);

    /**
     * Supprime un Ticket déjà existant
     * @param id Integer
     */
    public void deleteById(Integer id);

}