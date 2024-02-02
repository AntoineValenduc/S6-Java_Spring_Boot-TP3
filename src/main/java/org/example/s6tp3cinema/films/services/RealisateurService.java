package org.example.s6tp3cinema.films.services;

import org.example.s6tp3cinema.films.dtos.films.FilmOnlyTitreAndDateSortieAndDureeDto;
import org.example.s6tp3cinema.films.dtos.realisateur.RealisateurDto;
import org.example.s6tp3cinema.films.dtos.realisateur.RealisateurDtoWithoutFilm;

import java.util.List;
import java.util.Optional;

public interface RealisateurService {

    /**
     * Retourne une liste de Réalisateur DTO
     * @return Liste RealisateurDto
     */
    public List<RealisateurDtoWithoutFilm> getAllRealisateur();

    /**
     * Retourne un Réalisateur Dto, à partir de son ID
     * @param id Integer
     * @return RealisateurDto
     */
    public Optional<RealisateurDto> getById(Integer id);

    /**
     * Retourne la liste des Films d'un Realisateur, à partir de l'ID du Realisateur
     *
     * @param id Integer
     * @return FilmOnlyTitreAndDateSortieAndDureeDto
     */
    public Optional<List<FilmOnlyTitreAndDateSortieAndDureeDto>> getFilmsOfRealisateurById(Integer id);

    /**
     * Créer un nouveau Réalisateur
     * @param dto RealisateurDto
     */
    public void createRealisateur(RealisateurDto dto);

    /**
     * Modifie un Réalisateur déjà existant
     * @param dto RealisateurDto
     */
    public void updateRealisateur(RealisateurDto dto);

    /**
     * Supprime un Réalisateur déjà existant, à partir de son ID
     * @param id Integer
     */
    public void deleteById(Integer id);
}
