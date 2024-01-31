package org.example.s6tp3cinema.films.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "realisateur")
public class Realisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "nom", nullable = false)
    private String nom;

}
