package org.example.s6tp3cinema.films.controllers;

import org.example.s6tp3cinema.films.dtos.salle.SalleDto;
import org.example.s6tp3cinema.films.dtos.salle.SalleReduitDto;
import org.example.s6tp3cinema.films.services.SalleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salles")
public class SalleController {

    private final SalleService service;

    public SalleController(SalleService service) {
        this.service = service;
    }

    /**
     * Retourne la liste des Salles Reduit
     * @return Liste SalleDtoReduit
     */
    @GetMapping()
    public List<SalleReduitDto> getAllSalle(){
        return service.getAllSalle();
    }

    /**
     * Retourne une Salle Complet, à partir de son ID
     * @param id Integer
     * @return SalleDto
     */
    @GetMapping("/{id}")
    public Optional<SalleDto> getById(@PathVariable Integer id){
        return service.getById(id);
    }

    /**
     * Crée une nouvelle Salle Complet
     * @param dto SalleDto
     */
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSalle(@RequestBody SalleDto dto){
        service.createSalle(dto);
    }

    /**
     * Modifie une Salle déjà existant<br>
     * Nécessite l'ID de la Salle<br>
     * Ne nécessite pas de renseigner toutes les informations du Salle<br>
     * Renseigner uniquement les informations que vous souhaiter modifier<br>
     * Trust me I'm an engineer
     * @param dto SalleDto
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateSalle(@RequestBody SalleDto dto){
        service.updateSalle(dto);
    }

    /**
     * Supprime la Salle à partir de son ID
     * @param id Integer
     */
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }

}
