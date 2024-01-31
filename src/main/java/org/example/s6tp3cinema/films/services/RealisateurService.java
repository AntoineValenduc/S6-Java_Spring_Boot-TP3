package org.example.s6tp3cinema.films.services;

import org.example.s6tp3cinema.films.dto.RealisateurDto;

import java.util.List;
import java.util.Optional;

public interface RealisateurService {

    public List<RealisateurDto> getAllRealisateur();

    public Optional<RealisateurDto> getById(Integer id);

    public void createRealisateur(RealisateurDto dto);

    public void updateRealisateur(RealisateurDto dto);

    public void deleteById(Integer id);
}
