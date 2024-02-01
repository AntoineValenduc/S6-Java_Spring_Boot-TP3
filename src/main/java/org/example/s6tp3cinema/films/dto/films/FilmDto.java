package org.example.s6tp3cinema.films.dto.films;

import lombok.Data;
import org.example.s6tp3cinema.films.dto.realisateur.RealisateurDtoWithoutFilm;
import org.example.s6tp3cinema.films.dto.acteurs.ActeurWithoutFilmsDto;

import java.time.LocalDate;
import java.util.List;

@Data
public class FilmDto {

    private Integer id;
    private String titre;
    private LocalDate dateSortie;
    private int duree;
    private String synopsis;
    private RealisateurDtoWithoutFilm realisateur;
    private List<ActeurWithoutFilmsDto> acteurs;
}
