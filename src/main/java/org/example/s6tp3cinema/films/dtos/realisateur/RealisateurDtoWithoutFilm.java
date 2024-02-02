package org.example.s6tp3cinema.films.dtos.realisateur;

import lombok.Data;

/**
 * Réalisateur DTO avec les propriétés 'id', 'prenom', 'nom'<br>
 * Ne contient pas la liste des films<br>
 * Utilisé pour l'affichage de la liste des Réalisateurs
 *
 */
@Data
public class RealisateurDtoWithoutFilm {

    private Integer id;
    private String prenom;
    private String nom;
}
