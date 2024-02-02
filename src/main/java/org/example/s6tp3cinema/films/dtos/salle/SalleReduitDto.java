package org.example.s6tp3cinema.films.dtos.salle;

import lombok.Data;

import java.util.List;

@Data
public class SalleReduitDto {

    private Integer id;
    private String nom;
    private int capacite;
    private List<String> equipements;
}
