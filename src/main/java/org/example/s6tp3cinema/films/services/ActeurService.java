package org.example.s6tp3cinema.films.services;

import org.example.s6tp3cinema.films.dto.acteurs.ActeurDto;
import org.example.s6tp3cinema.films.dto.acteurs.ActeurWithoutFilmsDto;

import java.util.List;
import java.util.Optional;

public interface ActeurService {

    /**
     * Retourne la liste des Acteurs DTO, sans leur liste de Film
     * @return Liste ActeurDtoWithoutFilm
     */
    public List<ActeurWithoutFilmsDto> getAllActeur();

    /**
     * Retourne un Acteur DTO Complet, à partir de son ID
     * @param id Integer
     * @return ActeurDto
     */
    public Optional<ActeurDto> getById(Integer id);

    /**
     * Retourne un Acteur DTO Reduit, à partie de son ID
     * @param id Integer
     * @return ActeurWithoutFilmsDto
     */
    public Optional<ActeurWithoutFilmsDto> getByIdWithoutFilm(Integer id);

    /**
     * Créer un nouvel Acteur, sans sa liste de film
     * @param dto ActeurDtoWithoutFilm
     */
    public void createActeur(ActeurDto dto);

    /**
     * Modifie un Acteur déjà existant, sans sa liste de film
     * @param dto ActeurDtoWithoutFilm
     */
    public void updateActeur(ActeurDto dto);

    /**
     * Supprime un Acteur déjà existant, à partir de son ID
     * @param id Integer
     */
    public void deleteById(Integer id);
}
