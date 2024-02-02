package org.example.s6tp3cinema.films.controllers;

import org.example.s6tp3cinema.films.dtos.ticket.TicketDto;
import org.example.s6tp3cinema.films.dtos.ticket.TicketReduitDto;
import org.example.s6tp3cinema.films.services.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    /**
     * Retourne la liste des Tickets Reduit
     * @return Liste TicketDtoReduit
     */
    @GetMapping()
    public List<TicketReduitDto> getAllTicket(){
        return service.getAllTickets();
    }

    /**
     * Retourne un Ticket Complet, à partir de son ID
     * @param id Integer
     * @return TicketDto
     */
    @GetMapping("/{id}")
    public Optional<TicketDto> getById(@PathVariable Integer id){
        return service.getById(id);
    }

    /**
     * Crée un nouveau Ticket Complet
     * @param dto TicketDto
     */
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTicket(@RequestBody TicketDto dto){
        service.createTicket(dto);
    }

    /**
     * Modifie un Ticket déjà existant<br>
     * Nécessite l'ID du Ticket<br>
     * Ne nécessite pas de renseigner toutes les informations du Ticket<br>
     * Renseigner uniquement les informations que vous souhaiter modifier<br>
     * Trust me I'm an engineer
     * @param dto TicketDto
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateTicket(@RequestBody TicketDto dto){
        service.updateTicket(dto);
    }

    /**
     * Supprime le Ticket à partir de son ID
     * @param id Integer
     */
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }

}
