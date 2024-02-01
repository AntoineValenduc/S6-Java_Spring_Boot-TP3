package org.example.s6tp3cinema.films.controllers;

import org.example.s6tp3cinema.films.dto.films.FilmOnlyTitreAndDateSortieAndDureeDto;
import org.example.s6tp3cinema.films.dto.realisateur.RealisateurDto;
import org.example.s6tp3cinema.films.dto.realisateur.RealisateurDtoWithoutFilm;
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

    /**
     * Retourne la liste des Réalisateurs sans la liste de leurs Films
     * @return Liste des Réalisateurs dans leurs Films
     */
    @GetMapping
    public List<RealisateurDtoWithoutFilm> getAllRealisateurs(){
        return service.getAllRealisateur();
    }

    /**
     * Retourne un Réalisateur complet, à partir de son ID
     * @param id Integer
     * @return Réalisateur
     */
    @GetMapping("/{id}")
    public Optional<RealisateurDto> getRealisateurById(@PathVariable Integer id){
        return service.getById(id);
    }

    /**
     * Retourne la liste des Films (titre, duree, dateSortie) d'un Réalisateur, à partir de l'ID du Réalisateur
     * @param id Integer
     * @return List FilmOnlyTitreAndDateSortieAndDureeDto
     */
    @GetMapping("/{id}/films")
    public Optional<List<FilmOnlyTitreAndDateSortieAndDureeDto>>getFilmsOfRealisateurById(@PathVariable Integer id){
        return service.getFilmsOfRealisateurById(id);
    }

    /**
     * Crée un nouveau Realisateur
     * @param dto RealisateurDto
     */
    @PostMapping("/create")
    public void createRealisateur(@RequestBody RealisateurDto dto){
        service.createRealisateur(dto);
    }

    /**
     * Modifie un Realisateur déjà existant
     * @param dto RealisateurDto
     */
    @PutMapping("/update")
    public void updateRealisateur(@RequestBody RealisateurDto dto){
        service.updateRealisateur(dto);
    }

    /**
     * Supprime un Réalisateur déjà existant
     * @param id Integer
     */
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
