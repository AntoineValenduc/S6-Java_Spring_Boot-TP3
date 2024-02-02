package org.example.s6tp3cinema.films.controllers;

import org.example.s6tp3cinema.films.dtos.seance.SeanceDto;
import org.example.s6tp3cinema.films.dtos.seance.SeanceReduitDto;
import org.example.s6tp3cinema.films.dtos.ticket.TicketDto;
import org.example.s6tp3cinema.films.dtos.ticket.TicketReduitDto;
import org.example.s6tp3cinema.films.services.SeanceService;
import org.example.s6tp3cinema.films.services.SeanceServiceUpdatePlace;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seances")
public class SeanceController {

    private final SeanceService service;

    private final SeanceServiceUpdatePlace serviceUpdatePlace;

    public SeanceController(SeanceService service, SeanceServiceUpdatePlace serviceUpdatePlace) {
        this.service = service;
        this.serviceUpdatePlace = serviceUpdatePlace;
    }

    /**
     * Retourne la liste des Séances Reduit
     * @return Liste SeanceDtoReduit
     */
    @GetMapping()
    public List<SeanceReduitDto> getAllSeance(){
        return service.getAllSeance();
    }

    /**
     * Retourne la liste des Séances, à partir de la date
     * @param date LocalDate
     * @return Liste SeanceDto
     */
//    @GetMapping("/disponible")
//    public List<SeanceDto> getAllByDate(@RequestParam LocalDate date){
//        return service.getAllByDate(date);
//    }

    /**
     * Retourne une Seance Complet, à partir de son ID
     * @param id Integer
     * @return SeanceDto
     */
    @GetMapping("/{id}")
    public Optional<SeanceDto> getById(@PathVariable Integer id){
        return service.getById(id);
    }



    @GetMapping("/{id}/tickets")
    public List<TicketReduitDto> getListTicketsFromSeanceById(@PathVariable Integer id){
        return service.getListTicketsFromSeanceById(id);
    }

    /**
     * Crée une nouvelle Seance Complet
     * @param dto SeanceDto
     */
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSeance(@RequestBody SeanceDto dto){
        service.createSeance(dto);
    }

    /**
     * Crée un Ticket pour la Séance sélectionnée
     * @param id Integer
     * @param ticketDto TicketReduitDto
     * @return
     */
    @PostMapping("/{id}/reserver")
    @ResponseStatus(HttpStatus.OK)
    public TicketReduitDto reserverTicket(@PathVariable Integer id, @RequestBody TicketReduitDto ticketDto){
        return serviceUpdatePlace.reserverTicket(id, ticketDto);
    }

    /**
     * Modifie une Seance déjà existant<br>
     * Nécessite l'ID de la Seance<br>
     * Ne nécessite pas de renseigner toutes les informations du Seance<br>
     * Renseigner uniquement les informations que vous souhaiter modifier<br>
     * Trust me I'm an engineer
     * @param dto SeanceDto
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateSeance(@RequestBody SeanceDto dto){
        service.updateSeance(dto);
    }

    /**
     * Supprime la Seance à partir de son ID
     * @param id Integer
     */
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
