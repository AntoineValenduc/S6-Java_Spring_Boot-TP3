package org.example.s6tp3cinema.films.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "film")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "titre", nullable = false)
    private String titre;

    @Column(name = "dateSortie", nullable = false)
    private LocalDate dateSortie;

    @Column(name = "duree", nullable = false)
    private int duree;

    @Column(name = "synopsis", nullable = false, length = 500)
    private String synopsis;

    @ManyToOne
    @JoinColumn(name = "realisateur_id", nullable = false)
    private Realisateur realisateur;

    @ManyToMany
    @JoinTable(
            name = "acteur_film",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "acteur_id", referencedColumnName = "id")
    )
    private List<Acteur> acteurs = new ArrayList<>();

    @OneToMany(mappedBy = "film")
    private List<Seance> seances = new ArrayList<>();

}
