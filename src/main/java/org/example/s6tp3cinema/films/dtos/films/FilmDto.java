package org.example.s6tp3cinema.films.dtos.films;

import lombok.Data;
import org.example.s6tp3cinema.films.dtos.realisateur.RealisateurDtoWithoutFilm;
import org.example.s6tp3cinema.films.dtos.acteurs.ActeurWithoutFilmsDto;
import org.example.s6tp3cinema.films.dtos.seance.SeanceReduitDto;
import org.example.s6tp3cinema.films.dtos.seance.SeanceReduitFromFilmDto;

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
    private List<SeanceReduitFromFilmDto> seances;
}
