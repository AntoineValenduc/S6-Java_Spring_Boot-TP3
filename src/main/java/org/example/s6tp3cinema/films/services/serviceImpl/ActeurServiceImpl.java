package org.example.s6tp3cinema.films.services.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.example.s6tp3cinema.films.dto.ActeurDtoWithoutFilm;
import org.example.s6tp3cinema.films.entities.Acteur;
import org.example.s6tp3cinema.films.repositories.ActeurRepository;
import org.example.s6tp3cinema.films.services.ActeurService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ActeurServiceImpl implements ActeurService {

    private final ActeurRepository repository;

    private final ObjectMapper mapper;

    public ActeurServiceImpl(ActeurRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ActeurDtoWithoutFilm> getAllActeur() {
        return repository.findAll()
                .stream()
                .map(acteur -> mapper.convertValue(acteur, ActeurDtoWithoutFilm.class))
                .toList();
    }

    @Override
    public Optional<ActeurDtoWithoutFilm> getById(Integer id) {
        return Optional.ofNullable(mapper.convertValue(repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Film non trouvé pour l'id" + id)), ActeurDtoWithoutFilm.class));
    }

    @Override
    public void createActeur(ActeurDtoWithoutFilm dto) {
        repository.saveAndFlush(mapper.convertValue(dto, Acteur.class));
    }

    @Override
    public void updateActeur(ActeurDtoWithoutFilm dto) {
        repository.saveAndFlush(mapper.convertValue(dto, Acteur.class));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
