package org.example.s6tp3cinema.films.dto.films;

import lombok.Data;

import java.time.LocalDate;

/**
 * Film DTO Réduit<br>
 * Contient uniquement les propriétés :<br>
 * @prop 'titre'
 * @prop 'dateSortie'
 */
@Data
public class FilmOnlyTitreAndDateSortieDto {

    private String titre;
    private LocalDate dateSortie;
}
