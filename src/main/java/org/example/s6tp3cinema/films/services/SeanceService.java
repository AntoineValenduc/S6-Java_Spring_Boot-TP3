package org.example.s6tp3cinema.films.services;

import org.example.s6tp3cinema.films.dtos.seance.SeanceDto;
import org.example.s6tp3cinema.films.dtos.seance.SeanceReduitDto;
import org.example.s6tp3cinema.films.dtos.ticket.TicketDto;
import org.example.s6tp3cinema.films.dtos.ticket.TicketReduitDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SeanceService {

    /**
     * Retourne la liste des SeanceDto Reduites
     * @return Liste SeanceReduitDto
     */
    public List<SeanceReduitDto> getAllSeance();

    public List<SeanceDto> getListSeanceFromFilmId(Integer id, LocalDate date);

    /**
     * Retourne une SeanceDto Complète, à partir de son ID
     * @param id Integer
     * @return SeanceDto
     */
    public Optional<SeanceDto> getById(Integer id);

    /**
     * Retourne la liste des Tickets Réduits liés à une Séance, à partir de l'ID de la Seance
     * @param id
     * @return
     */
    public List<TicketReduitDto> getListTicketsFromSeanceById(Integer id);

    /**
     * Crée une nouvelle Seance Complète
     * @param dto SeanceDto
     */
    public void createSeance(SeanceDto dto);

    /**
     * Modifie une Seance déjà existante
     * @param dto SeanceDto
     */
    public void updateSeance(SeanceDto dto);

    /**
     * Supprime une Seance déjà existante, à partir de son ID
     * @param id Integer
     */
    public void deleteById(Integer id);



}
