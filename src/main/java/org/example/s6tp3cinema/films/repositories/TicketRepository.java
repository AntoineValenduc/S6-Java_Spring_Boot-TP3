package org.example.s6tp3cinema.films.repositories;

import jakarta.transaction.Transactional;
import org.example.s6tp3cinema.films.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
