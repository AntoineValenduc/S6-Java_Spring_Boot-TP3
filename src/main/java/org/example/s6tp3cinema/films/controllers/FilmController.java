package org.example.s6tp3cinema.films.controllers;

import org.example.s6tp3cinema.films.dto.acteurs.ActeurWithoutFilmsDto;
import org.example.s6tp3cinema.films.dto.realisateur.RealisateurDtoWithoutFilm;
import org.example.s6tp3cinema.films.services.FilmService;
import org.example.s6tp3cinema.films.dto.films.FilmDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService service;

    public FilmController(FilmService service) {
        this.service = service;
    }

    /**
     * Retourne la liste des Films Complet
     * @return Liste FilmDto
     */
    @GetMapping
    public List<FilmDto> getAllFilms(){
        return service.getAllFilms();
    }

    /**
     * Retourne un Film complet, à partir de son ID
     * @param id Integer
     * @return FilmDto
     */
    @GetMapping("/{id}")
    public Optional<FilmDto> getFilmById(@PathVariable Integer id){
        return service.getFilmById(id);
    }

    /**
     * Retourne un Film complet, à partir de son titre
     * @param titre String
     * @return FilmDto
     */
    @GetMapping("/searchByTitre")
    public Optional<FilmDto> getFilmByTitre(@RequestParam String titre){
        return service.getFilmByTitle(titre);
    }

    /**
     * Retourne la liste des Acteurs d'un Film, à partir de l'ID du Film
     * @param id Integer
     * @return Liste ActeurWithoutFilmsDto
     */
    @GetMapping("/{id}/acteurs")
    public List<ActeurWithoutFilmsDto> getActeurOfFilmById(@PathVariable Integer id){
        return service.getActeursOfFilmById(id);
    }

    /**
     * Retourne le Réalisateur d'un Film, à partir de l'ID du Film
     * @param id Integer
     * @return RealisateurDtoWithoutFilm
     */
    @GetMapping("/{id}/realisateur")
    public RealisateurDtoWithoutFilm getRealisateurOfFilmById(@PathVariable Integer id){
        return service.getRealisateurOfFilmById(id);
    }

    /**
     * Attribut un Acteur déjà existant, à un Film déjà existant à partir de son ID
     * @param id Integer
     * @param dto ActeurWithoutFilmsDto
     * @return FilmDto
     */
    @PostMapping("/{id}/acteurs")
    public FilmDto postActeursToFilm(@PathVariable Integer id, @RequestBody ActeurWithoutFilmsDto dto){
        return service.addActeurToFilm(id, dto);
    }

    /**
     * Créer un nouveau Film
     * @param dto
     */
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createFilm(@RequestBody FilmDto dto){
        service.createFilm(dto);
    }

    /**
     * Modifie un Film déjà existant
     * @param dto
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateFilm(@RequestBody FilmDto dto){
        service.updateFilm(dto);
    }

    /**
     * Supprime un Film déjà existant
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
