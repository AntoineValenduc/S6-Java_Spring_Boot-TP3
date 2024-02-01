package org.example.s6tp3cinema.films.dto.films;

import lombok.Data;
import org.example.s6tp3cinema.films.dto.realisateur.RealisateurDtoWithoutFilm;

import java.time.LocalDate;

@Data
public class FilmWithoutActeursDto {

    private Integer id;
    private String titre;
    private LocalDate dateSortie;
    private int duree;
    private String synopsis;
    private RealisateurDtoWithoutFilm realisateur;
}
