package org.example.s6tp3cinema.films.dtos.ticket;

import lombok.Data;
import org.example.s6tp3cinema.films.dtos.seance.SeanceReduitDto;

@Data
public class TicketDto {

    private Integer id;
    private SeanceReduitDto seance;
    private String nomClient;
    private int nbrPlaces;
}
