package org.example.s6tp3cinema.films.services.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.s6tp3cinema.films.dto.RealisateurDto;
import org.example.s6tp3cinema.films.entities.Realisateur;
import org.example.s6tp3cinema.films.repositories.RealisateurRepository;
import org.example.s6tp3cinema.films.services.RealisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RealisateurServiceImpl implements RealisateurService {

    private final RealisateurRepository repository;

    private final ObjectMapper mapper;

    public RealisateurServiceImpl(RealisateurRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<RealisateurDto> getAllRealisateur() {
        return repository.findAll()
                .stream()
                .map(Realisateur -> mapper.convertValue(Realisateur, RealisateurDto.class))
                .toList();
    }

    @Override
    public Optional<RealisateurDto> getById(Integer id) {
        return Optional.ofNullable(mapper.convertValue(repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Film non trouvé pour l'id" + id)), RealisateurDto.class));
    }

    @Override
    public void createRealisateur(RealisateurDto dto) {
        repository.saveAndFlush(mapper.convertValue(dto, Realisateur.class));
    }

    @Override
    public void updateRealisateur(RealisateurDto dto) {
        repository.saveAndFlush(mapper.convertValue(dto, Realisateur.class));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
