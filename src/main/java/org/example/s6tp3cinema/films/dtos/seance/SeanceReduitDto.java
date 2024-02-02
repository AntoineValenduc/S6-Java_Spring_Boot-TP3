package org.example.s6tp3cinema.films.dtos.seance;

import lombok.Data;
import org.example.s6tp3cinema.films.dtos.films.FilmDto;
import org.example.s6tp3cinema.films.dtos.salle.SalleReduitDto;

import java.time.LocalDate;

@Data
public class SeanceReduitDto {

    private Integer id;
    private FilmDto film;
    private SalleReduitDto salle;
    private LocalDate date;
    private int placeDisponibles;
    private float prix;
}
