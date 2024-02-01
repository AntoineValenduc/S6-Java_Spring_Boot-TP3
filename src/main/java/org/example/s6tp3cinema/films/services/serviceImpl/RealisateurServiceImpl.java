package org.example.s6tp3cinema.films.services.serviceImpl;

import org.example.s6tp3cinema.films.dto.films.FilmOnlyTitreAndDateSortieAndDureeDto;
import org.example.s6tp3cinema.films.dto.realisateur.RealisateurDto;
import org.example.s6tp3cinema.films.dto.realisateur.RealisateurDtoWithoutFilm;
import org.example.s6tp3cinema.films.exceptions.RealisateurCantBeNullException;
import org.example.s6tp3cinema.films.exceptions.RealisateurNotFoundException;
import org.example.s6tp3cinema.films.mapper.RealisateurMapStruct;
import org.example.s6tp3cinema.films.repositories.RealisateurRepository;
import org.example.s6tp3cinema.films.services.RealisateurService;
import org.example.s6tp3cinema.films.utils.SearchNullPropertiesName;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RealisateurServiceImpl implements RealisateurService {

    private final RealisateurRepository repository;

    private final SearchNullPropertiesName utils;

    public RealisateurServiceImpl(RealisateurRepository repository, SearchNullPropertiesName utils) {
        this.repository = repository;
        this.utils = utils;
    }

    @Override
    public List<RealisateurDtoWithoutFilm> getAllRealisateur() {
        return repository.findAll()
                .stream()
                .map(RealisateurMapStruct.INSTANCE::toDtoReduit)
                .toList();
    }

    @Override
    public Optional<RealisateurDto> getById(Integer id) {
        return repository.findById(id)
                .map(RealisateurMapStruct.INSTANCE::toDtoComplet)
                .map(Optional::of)
                .orElseThrow (
                        () -> new RealisateurNotFoundException(id));
    }

    @Override
    public Optional<List<FilmOnlyTitreAndDateSortieAndDureeDto>> getFilmsOfRealisateurById(Integer id) {
        return repository.findById(id)
                .map(realisateur -> RealisateurMapStruct.INSTANCE.toDtoListFilm(realisateur.getFilms()))
                .map(Optional::of)
                .orElseThrow (
                        () -> new RealisateurNotFoundException(id));
    }

    @Override
    public void createRealisateur(RealisateurDto dto) {
        // Vérifier si le DTO est nul
        if (dto == null) {
            throw new RealisateurCantBeNullException();
        } else {
            verifyDtoData(dto);
            // Création du film
            repository.saveAndFlush(RealisateurMapStruct.INSTANCE.toEntityComplet(dto));
        }

    }

    /**
     * Vérifie les données de l'objet RealisateurDto
     * @param dto
     */
    private static void verifyDtoData(RealisateurDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto.getNom() == null){
            errors.add("nom");
        }
        if(dto.getPrenom() == null){
            errors.add("prenom");
        }
        if(!errors.isEmpty()){
            throw new RealisateurCantBeNullException(errors);
        }
    }

    @Override
    public void updateRealisateur(RealisateurDto dto) {
        if (dto.getId() == null) {
            // Exception si envoie d'un Réalisateur null
            throw new RealisateurCantBeNullException();
        } else {
            // Recherche du Réalisateur existant dans la bdd, convertit en DTO
            RealisateurDto dtoExist = RealisateurMapStruct.INSTANCE.toDtoComplet(repository.findById(dto.getId()).orElse(null));
            if (dtoExist != null) {
                // Copie des propriétés non nulles du RealisateurDto vers dtoExist
                BeanUtils.copyProperties(dto, dtoExist, utils.getNullPropertyNames(dto));

                // Enregistrement de l'acteur mis à jour
                repository.saveAndFlush(RealisateurMapStruct.INSTANCE.toEntityComplet(dtoExist));
            } else {
                // Exception si le Réalisateur n'existe pas en bdd
                throw new RealisateurNotFoundException(dtoExist.getId());
            }
        }
    }

    @Override
    public void deleteById(Integer id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        } else {
            throw new RealisateurNotFoundException(id);
        }

    }

}
