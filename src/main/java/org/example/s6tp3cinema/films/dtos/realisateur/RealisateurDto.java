package org.example.s6tp3cinema.films.dtos.realisateur;

import lombok.Data;
import org.example.s6tp3cinema.films.dtos.films.FilmOnlyTitreAndDateSortieDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Réalisateur DTO Complet
 */
@Data
public class RealisateurDto {

    private Integer id;
    private String prenom;
    private String nom;
    private List<FilmOnlyTitreAndDateSortieDto> films = new ArrayList<>();
}
