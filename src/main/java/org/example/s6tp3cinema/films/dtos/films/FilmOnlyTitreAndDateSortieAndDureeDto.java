package org.example.s6tp3cinema.films.dtos.films;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmOnlyTitreAndDateSortieAndDureeDto {

    private String titre;
    private LocalDate dateSortie;
    private int duree;
}
