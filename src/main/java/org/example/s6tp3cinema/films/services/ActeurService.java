package org.example.s6tp3cinema.films.services;

import org.example.s6tp3cinema.films.dto.ActeurDtoWithoutFilm;

import java.util.List;
import java.util.Optional;

public interface ActeurService {

    public List<ActeurDtoWithoutFilm> getAllActeur();

    public Optional<ActeurDtoWithoutFilm> getById(Integer id);

    public void createActeur(ActeurDtoWithoutFilm dto);

    public void updateActeur(ActeurDtoWithoutFilm dto);

    public void deleteById(Integer id);
}
