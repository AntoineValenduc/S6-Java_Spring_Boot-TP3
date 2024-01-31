package org.example.s6tp3cinema.films.controllers;

import org.example.s6tp3cinema.films.dto.RealisateurDto;
import org.example.s6tp3cinema.films.services.RealisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {

    private final RealisateurService service;

    public RealisateurController(RealisateurService service) {
        this.service = service;
    }

    @GetMapping
    public List<RealisateurDto> getAllRealisateurs(){
        return service.getAllRealisateur();
    }

    @GetMapping("/{id}")
    public Optional<RealisateurDto> getRealisateurById(@PathVariable Integer id){
        return service.getById(id);
    }

    @PostMapping("/create")
    public void createRealisateur(@RequestBody RealisateurDto dto){
        service.createRealisateur(dto);
    }

    @PutMapping("/update")
    public void updateRealisateur(@RequestBody RealisateurDto dto){
        service.updateRealisateur(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
