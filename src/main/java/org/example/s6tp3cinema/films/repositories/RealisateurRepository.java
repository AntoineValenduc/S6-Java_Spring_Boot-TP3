package org.example.s6tp3cinema.films.repositories;

import jakarta.transaction.Transactional;
import org.example.s6tp3cinema.films.entities.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface RealisateurRepository extends JpaRepository<Realisateur, Integer> {
}
