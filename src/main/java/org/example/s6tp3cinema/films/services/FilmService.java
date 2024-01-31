package org.example.s6tp3cinema.films.services;

import org.example.s6tp3cinema.films.dto.FilmDto;

import java.util.List;
import java.util.Optional;

public interface FilmService {

    /**
     * Retourne la liste de tous les films
     * @return Liste de FilmDto
     */
    public List<FilmDto> getAllFilms();

    /**
     * Retourne un film à partir de son ID
     * @param id Integer
     * @return FilmDto
     */
    public Optional<FilmDto> getFilmById(Integer id);

    public Optional<FilmDto> getFilmByTitle(String title);

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
     * Supprime un Film existant à partir de son ID
     * @param id Integer
     */
    public void deleteById(Integer id);
}
