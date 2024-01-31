package org.example.s6tp3cinema.films.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class FilmDto {

    private Integer id;
    private String titre;
    private LocalDate dateSortie;
    private int duree;
    private String synopsis;
    private RealisateurDto realisateur;
    private List<ActeurDtoWithoutFilm> acteurs = new ArrayList<>();
}
