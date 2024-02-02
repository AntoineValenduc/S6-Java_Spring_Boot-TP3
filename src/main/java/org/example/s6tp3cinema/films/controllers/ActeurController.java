package org.example.s6tp3cinema.films.controllers;

import org.example.s6tp3cinema.films.dtos.acteurs.ActeurDto;
import org.example.s6tp3cinema.films.dtos.acteurs.ActeurWithoutFilmsDto;
import org.example.s6tp3cinema.films.services.ActeurService;
import org.springframework.http.HttpStatus;
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

    /**
     * Retourne la liste des Acteurs, sans la liste de leurs Films
     * @return Liste ActeurWithoutFilmsDto
     */
    @GetMapping
    public List<ActeurWithoutFilmsDto> getAllActeurs(){
        return service.getAllActeur();
    }

    /**
     * Retourne un Acteur Complet, à partir de son ID
     * @param id Integer
     * @return ActeurDto
     */
    @GetMapping("/{id}")
    public Optional<ActeurDto> getActeurById(@PathVariable Integer id){
        return service.getById(id);
    }

    /**
     * Crée un nouvel Acteur complet
     * @param dto ActeurDto
     */
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createActeur(@RequestBody ActeurDto dto){
        service.createActeur(dto);
    }

    /**
     * Modifie un Acteur complet déjà existant<br>
     * Nécessite l'ID du Acteur<br>
     * Ne nécessite pas de renseigner toutes les informations du Acteur<br>
     * Renseigner uniquement les informations que vous souhaiter modifier<br>
     * Trust me I'm an engineer
     * @param dto ActeurDto
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateActeur(@RequestBody ActeurDto dto){
        service.updateActeur(dto);
    }

    /**
     * Supprime un Acteur déjà existant, à partir de son ID
     * @param id Integer
     */
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
