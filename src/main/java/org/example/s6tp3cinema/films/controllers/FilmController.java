package org.example.s6tp3cinema.films.controllers;

import org.example.s6tp3cinema.films.services.FilmService;
import org.example.s6tp3cinema.films.dto.FilmDto;
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

    @GetMapping
    public List<FilmDto> getAllFilms(){
        return service.getAllFilms();
    }

    @GetMapping("/{id}")
    public Optional<FilmDto> getFilmById(@PathVariable Integer id){
        return service.getFilmById(id);
    }

    @GetMapping("/searchByTitre")
    public Optional<FilmDto> getFilmByTitre(@RequestParam String titre){
        return service.getFilmByTitle(titre);
    }

    @PostMapping("/create")
    public void createFilm(@RequestBody FilmDto dto){
        service.createFilm(dto);
    }

    @PutMapping("/update")
    public void updateFilm(@RequestBody FilmDto dto){
        service.updateFilm(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
