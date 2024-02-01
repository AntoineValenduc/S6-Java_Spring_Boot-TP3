package org.example.s6tp3cinema.films.dto.acteurs;

import lombok.Data;

/**
 * Acteur DTO, avec les propriétés 'id', 'prenom', 'nom'<br>
 * Ne contient pas la liste des Films<br>
 * Utilisé pour l'affichage de la liste des Acteurs
 */
@Data
public class ActeurWithoutFilmsDto {

    private Integer id;
    private String prenom;
    private String nom;
}
