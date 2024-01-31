package org.example.s6tp3cinema.films.controllers;

import org.example.s6tp3cinema.films.dto.ActeurDtoWithoutFilm;
import org.example.s6tp3cinema.films.services.ActeurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acteurs")
public class ActeurController {
    private final ActeurService service;

    public ActeurController(ActeurService service) {
        this.service = service;
    }

    @GetMapping
    public List<ActeurDtoWithoutFilm> getAllActeurs(){
        return service.getAllActeur();
    }

    @GetMapping("/{id}")
    public Optional<ActeurDtoWithoutFilm> getActeurById(@PathVariable Integer id){
        return service.getById(id);
    }

    @PostMapping("/create")
    public void createActeur(@RequestBody ActeurDtoWithoutFilm dto){
        service.createActeur(dto);
    }

    @PutMapping("/update")
    public void updateActeur(@RequestBody ActeurDtoWithoutFilm dto){
        service.updateActeur(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
