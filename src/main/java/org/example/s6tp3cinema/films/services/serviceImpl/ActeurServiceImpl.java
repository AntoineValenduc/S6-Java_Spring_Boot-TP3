package org.example.s6tp3cinema.films.services.serviceImpl;

import org.example.s6tp3cinema.films.dtos.acteurs.ActeurDto;
import org.example.s6tp3cinema.films.dtos.acteurs.ActeurWithoutFilmsDto;
import org.example.s6tp3cinema.films.exceptions.acteur.ActeurCantBeNullException;
import org.example.s6tp3cinema.films.exceptions.acteur.ActeurNotFoundException;
import org.example.s6tp3cinema.films.mappers.ActeurMapStruct;
import org.example.s6tp3cinema.films.repositories.ActeurRepository;
import org.example.s6tp3cinema.films.services.ActeurService;
import org.example.s6tp3cinema.films.utils.SearchNullPropertiesName;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActeurServiceImpl implements ActeurService {

    private final ActeurRepository repository;

    private final SearchNullPropertiesName utils;

    public ActeurServiceImpl(ActeurRepository repository, SearchNullPropertiesName utils) {
        this.repository = repository;
        this.utils = utils;
    }

    @Override
    public List<ActeurWithoutFilmsDto> getAllActeur() {
        return repository.findAll()
                .stream()
                .map(ActeurMapStruct.INSTANCE::toDtoReduit)
                .toList();
    }

    @Override
    public Optional<ActeurDto> getById(Integer id) {
        return Optional.ofNullable(ActeurMapStruct.INSTANCE.toDtoComplet(repository.findById(id).orElseThrow(
                () -> new ActeurNotFoundException(id))));
    }

    @Override
    public Optional<ActeurWithoutFilmsDto> getByIdWithoutFilm(Integer id) {
        return Optional.ofNullable(ActeurMapStruct.INSTANCE.toDtoReduit(repository.findById(id).orElseThrow(
                () -> new ActeurNotFoundException(id))));
    }

    @Override
    public void createActeur(ActeurDto dto) {
        // Vérifier si le DTO est nul
        if(dto == null){
            throw new ActeurCantBeNullException();
        } else {
            verifyDataFromRequest(dto);

            //Enregistrement de l'Acteur
            repository.saveAndFlush(ActeurMapStruct.INSTANCE.toEntityComplet(dto));
        }
    }

    /**
     * Vérifie les données de l'objet Acteur
     * @param dto ActeurDto
     */
    private static void verifyDataFromRequest(ActeurDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto.getNom() == null){
            errors.add("nom");
        }
        if (dto.getPrenom() == null){
            errors.add("prenom");
        }
        if (!errors.isEmpty()){
            throw new ActeurCantBeNullException(errors);
        }
    }

    @Override
    public void updateActeur(ActeurDto dto) {
        //Vérifie si le dto envoi un Salle null
        if (dto.getId() == null) {
            // Exception si envoie d'un Acteur null
            throw new ActeurCantBeNullException();
        } else {
            verifyDtoData(dto);
        }
    }

    /**
     * Vérifie l'existence de l'Acteur dans la bdd<br>
     * @param dto
     */
    private void verifyDtoData(ActeurDto dto) {
        // Recherche de l'Acteur existant dans la bdd, convertit en DTO
        ActeurDto dtoExist = ActeurMapStruct.INSTANCE.toDtoComplet(repository.findById(dto.getId())
                .orElseThrow(()-> new ActeurNotFoundException(dto.getId())));
        saveActeur(dto, dtoExist);
    }

    /**
     * Enregistre l'Acteur
     * @param dto ActeurDto request
     * @param dtoExist ActeurDto bdd
     */
    private void saveActeur(ActeurDto dto, ActeurDto dtoExist) {
        if (dtoExist != null) {
            // Copie des propriétés non nulles de ActeurDto vers dtoExist
            BeanUtils.copyProperties(dto, dtoExist, utils.getNullPropertyNames(dto));

            // Enregistrement de l'Acteur mis à jour
            repository.saveAndFlush(ActeurMapStruct.INSTANCE.toEntityComplet(dtoExist));
        } else {
            // Exception si l'Acteur n'existe pas en bdd
            throw new ActeurNotFoundException(dto.getId());
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ActeurNotFoundException(id);
        }
    }
}
