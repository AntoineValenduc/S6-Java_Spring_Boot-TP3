package org.example.s6tp3cinema.films.services;

import org.example.s6tp3cinema.films.dto.acteurs.ActeurWithoutFilmsDto;
import org.example.s6tp3cinema.films.dto.films.FilmDto;
import org.example.s6tp3cinema.films.dto.realisateur.RealisateurDtoWithoutFilm;

import java.util.List;
import java.util.Optional;

public interface FilmService {

    /**
     * Retourne la liste de tous les Films Complet
     * @return Liste de FilmDto
     */
    public List<FilmDto> getAllFilms();

    /**
     * Retourne un Film Complet, à partir de son ID
     * @param id Integer
     * @return FilmDto
     */
    public Optional<FilmDto> getFilmById(Integer id);

    /**
     * Retourne un Film, à partir de son titre
     * @param title String
     * @return FilmDto
     */
    public Optional<FilmDto> getFilmByTitle(String title);

    /**
     * Retourne la liste des acteurs, à partir de l'ID du Film
     * @param id Integer
     * @return Liste ActeurWithoutFilmsDto
     */
    public List<ActeurWithoutFilmsDto> getActeursOfFilmById(Integer id);

    /**
     * Retourne le réalisateur, à partir de l'ID du Film
     * @param id
     * @return
     */
    public RealisateurDtoWithoutFilm getRealisateurOfFilmById(Integer id);

    /**
     * Enregistre une
     * @param id Integer
     * @param dto ActeurWithoutFilmsDto
     * @return FilmDto
     */
    public FilmDto addActeurToFilm(Integer id, ActeurWithoutFilmsDto dto);

    /**
     * Créer un nouveau Film
     * @param dto FilmDto
     */
    public void createFilm(FilmDto dto);

    /**
     * Modifie un Film déjà existant
     * @param dto FilmDto
     */
    public void updateFilm(FilmDto dto);

    /**
     * Supprime un Film existant, à partir de son ID
     * @param id Integer
     */
    public void deleteById(Integer id);
}
