package org.example.s6tp3cinema.films.services.serviceImpl;

import org.example.s6tp3cinema.films.dto.acteurs.ActeurWithoutFilmsDto;
import org.example.s6tp3cinema.films.dto.films.FilmDto;
import org.example.s6tp3cinema.films.dto.realisateur.RealisateurDtoWithoutFilm;
import org.example.s6tp3cinema.films.exceptions.ActeurAlreadyAttributException;
import org.example.s6tp3cinema.films.exceptions.FilmCantBeNullException;
import org.example.s6tp3cinema.films.exceptions.FilmNotFoundException;
import org.example.s6tp3cinema.films.mapper.FilmMapStruct;
import org.example.s6tp3cinema.films.repositories.FilmRepository;
import org.example.s6tp3cinema.films.services.ActeurService;
import org.example.s6tp3cinema.films.services.FilmService;
import org.example.s6tp3cinema.films.utils.SearchNullPropertiesName;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository repository;

    private final ActeurService acteurService;

    private final SearchNullPropertiesName utils;


    public FilmServiceImpl(FilmRepository repository, ActeurService acteurService, SearchNullPropertiesName utils) {
        this.repository = repository;
        this.acteurService = acteurService;
        this.utils = utils;
    }

    @Override
    public List<FilmDto> getAllFilms() {
        return repository.findAll()
                .stream()
                .map(FilmMapStruct.INSTANCE::toDto)
                .toList();
    }

    @Override
    public Optional<FilmDto> getFilmById(Integer id) {
        return repository.findById(id)
                .map(FilmMapStruct.INSTANCE::toDto)
                .map(Optional::of)
                .orElseThrow (
                        () -> new FilmNotFoundException(id));
    }

    @Override
    public Optional<FilmDto> getFilmByTitle(String titre) {
        return repository.findByTitre(titre)
                .map(FilmMapStruct.INSTANCE::toDto)
                .map(Optional::of)
                .orElseThrow (
                        () -> new FilmNotFoundException(titre));
    }

    @Override
    public List<ActeurWithoutFilmsDto> getActeursOfFilmById(Integer id) {
        return getFilmById(id).orElseThrow(
                () -> new FilmNotFoundException(id))
                .getActeurs();
    }

    @Override
    public RealisateurDtoWithoutFilm getRealisateurOfFilmById(Integer id) {
        return getFilmById(id).orElseThrow(
                        () -> new FilmNotFoundException(id))
                .getRealisateur();
    }

    @Override
    public FilmDto addActeurToFilm(Integer id, ActeurWithoutFilmsDto dto) {
        //Recherche de l'acteur dans la bdd
       Optional<ActeurWithoutFilmsDto> acteurDto = acteurService.getByIdWithoutFilm(dto.getId());

        if (dto.getId() == null) {
            // Exception si le Film est null
            throw new FilmCantBeNullException();
        } else {
            // Recherche du Film existant dans la bdd, convertit en DTO
            FilmDto dtoExist = FilmMapStruct.INSTANCE.toDto(repository.findById(id).orElseThrow(() -> new FilmNotFoundException(id)));
            FilmDto dtoUpdated = FilmMapStruct.INSTANCE.toDto(repository.findById(id).orElseThrow(() -> new FilmNotFoundException(id)));
            if (dtoExist != null) {
                for (ActeurWithoutFilmsDto acteurExist : dtoExist.getActeurs()) {
                    if (Objects.equals(acteurExist.getId(), dto.getId())){
                        throw new ActeurAlreadyAttributException(dto.getId());
                    }
                }
                List<ActeurWithoutFilmsDto> listActor = dtoExist.getActeurs();
                acteurDto.ifPresent(listActor::add);
                dtoUpdated.setActeurs(listActor);

                // Copie des propriétés non nulles du FilmDto vers dtoExist
                BeanUtils.copyProperties(dtoUpdated, dtoExist, utils.getNullPropertyNames(dto));
                // Enregistrement du Film mis à jour
                repository.saveAndFlush(FilmMapStruct.INSTANCE.toEntity(dtoExist));

            }
            return dtoExist;
        }
    }

    @Override
    public void createFilm(FilmDto dto) {
        // Vérifier si le DTO est nul
        if (dto == null) {
            throw new FilmCantBeNullException();
        } else {
            verifyDtoData(dto);
            // Création du film
            repository.saveAndFlush(FilmMapStruct.INSTANCE.toEntity(dto));
        }
    }

    /**
     * Vérifie les données de l'objet FilmDto
     * @param dto FilmDto
     */
    private static void verifyDtoData(FilmDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto.getTitre() == null){
            errors.add("titre");
        }
        if (dto.getDateSortie() == null){
            errors.add("dateSortie");
        }
        if (dto.getDuree() == 0){
            errors.add("duree");
        }
        if (dto.getSynopsis() == null){
            errors.add("synopsis");
        }
        if (dto.getRealisateur() == null){
            errors.add("realisateur");
        }
        if (!errors.isEmpty()){
            throw new FilmCantBeNullException(errors);
        }
    }

    @Override
    public void updateFilm(FilmDto dto) {
        if (dto.getId() == null) {
            // Exception si envoie d'un Film null
            throw new FilmCantBeNullException();
        } else {
            // Recherche du Film existant dans la bdd, convertit en DTO
            FilmDto dtoExist = FilmMapStruct.INSTANCE.toDto(repository.findById(dto.getId()).orElse(null));
            if (dtoExist != null) {
                // Copie des propriétés non nulles du FilmDto vers dtoExist
                BeanUtils.copyProperties(dto, dtoExist, utils.getNullPropertyNames(dto));

                // Enregistrement du Film mis à jour
                repository.saveAndFlush(FilmMapStruct.INSTANCE.toEntity(dtoExist));
            } else {
                // Exception si le Film n'existe pas en bdd
                throw new FilmNotFoundException(dto.getId());
            }
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        } else {
            throw new FilmNotFoundException(id);
        }
    }
}
