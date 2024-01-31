package org.example.s6tp3cinema.films.repositories;

import jakarta.transaction.Transactional;
import org.example.s6tp3cinema.films.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface FilmRepository extends JpaRepository <Film, Integer> {

    Optional<Film> findByTitre(String title);
}
