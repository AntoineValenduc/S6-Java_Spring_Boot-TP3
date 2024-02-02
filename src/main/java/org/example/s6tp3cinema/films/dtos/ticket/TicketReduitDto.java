package org.example.s6tp3cinema.films.dtos.ticket;

import lombok.Data;

@Data
public class TicketReduitDto {

    private Integer id;
    private String nomClient;
    private int nbrPlaces;
}
