package org.example.s6tp3cinema.films.repositories;

import jakarta.transaction.Transactional;
import org.example.s6tp3cinema.films.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface SeanceRepository extends JpaRepository<Seance, Integer> {

    public List<Seance> findAllByDate(LocalDate date);

    public List<Seance> findAllByFilm_IdAndDateAfterAndPlaceDisponiblesNotEmpty(Integer id, LocalDate dateNow);
}
