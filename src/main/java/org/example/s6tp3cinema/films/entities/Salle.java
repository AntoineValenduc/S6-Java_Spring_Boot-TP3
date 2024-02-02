package org.example.s6tp3cinema.films.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name ="salle")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "capacite", nullable = false)
    private int capacite;

    @ElementCollection
    @Column(name = "equipements")
    private List<String> equipements = new ArrayList<>();

    @OneToMany(mappedBy = "salle")
    private List<Seance> seances = new ArrayList<>();
}
