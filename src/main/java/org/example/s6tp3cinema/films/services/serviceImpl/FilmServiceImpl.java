package org.example.s6tp3cinema.films.services.serviceImpl;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.s6tp3cinema.films.dto.FilmDto;
import org.example.s6tp3cinema.films.entities.Acteur;
import org.example.s6tp3cinema.films.entities.Film;
import org.example.s6tp3cinema.films.mapper.ActeurMapper;
import org.example.s6tp3cinema.films.mapper.FilmMapper;
import org.example.s6tp3cinema.films.repositories.FilmRepository;
import org.example.s6tp3cinema.films.services.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository repository;

    private final FilmMapper mapper;

    public FilmServiceImpl(FilmRepository repository, FilmMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<FilmDto> getAllFilms() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public Optional<FilmDto> getFilmById(Integer id) {
        return  Optional.ofNullable(mapper.toDto(repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Film non trouvé pour l'id" + id))));
    }

    @Override
    public Optional<FilmDto> getFilmByTitle(String title) {
        return Optional.ofNullable(mapper.toDto(repository.findByTitre(title).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Film non trouvé pour le titre" + title))));
    }

    @Override
    @Transactional
    public void createFilm(FilmDto dto) {
        repository.saveAndFlush(mapper.toEntity(dto));
    }

    @Override
    public void updateFilm(FilmDto dto) {
        repository.saveAndFlush(mapper.toEntity(dto));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);

    }
}
