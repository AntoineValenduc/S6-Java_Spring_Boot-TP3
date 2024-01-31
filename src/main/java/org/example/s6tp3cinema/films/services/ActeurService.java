package org.example.s6tp3cinema.films.services;

import org.example.s6tp3cinema.films.dto.ActeurDtoWithoutFilm;

import java.util.List;
import java.util.Optional;

public interface ActeurService {

    /**
     * Retourne la liste des Acteurs DTO sans leur liste de Film
     * @return List<ActeurDtoWithoutFilm>
     */
    public List<ActeurDtoWithoutFilm> getAllActeur();

    /**
     * Retourne un Acteur DTO sans sa liste de Film, à partir de son ID
     * @param id Integer
     * @return FilmDto
     */
    public Optional<ActeurDtoWithoutFilm> getById(Integer id);

    /**
     * Créer un nouvel Acteur sans sa liste de film
     * @param dto ActeurDtoWithoutFilm
     */
    public void createActeur(ActeurDtoWithoutFilm dto);

    /**
     * Modifie un Acteur déjà existant sans sa liste de film
     * @param dto ActeurDtoWithoutFilm
     */
    public void updateActeur(ActeurDtoWithoutFilm dto);

    /**
     * Supprime un Acteur déjà existant, à partir de son ID
     * @param id Integer
     */
    public void deleteById(Integer id);
}
