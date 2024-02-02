package org.example.s6tp3cinema.films.dtos.seance;

import lombok.Data;
import org.example.s6tp3cinema.films.dtos.salle.SalleReduitDto;
import org.example.s6tp3cinema.films.dtos.ticket.TicketDto;
import org.example.s6tp3cinema.films.dtos.films.FilmDto;
import org.example.s6tp3cinema.films.dtos.salle.SalleDto;
import org.example.s6tp3cinema.films.dtos.ticket.TicketReduitDto;

import java.time.LocalDate;
import java.util.List;

@Data
public class SeanceDto {

    private Integer id;
    private FilmDto film;
    private SalleReduitDto salle;
    private LocalDate date;
    private int placeDisponibles;
    private float prix;
    private List<TicketReduitDto> tickets;
}
