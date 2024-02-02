package org.example.s6tp3cinema.films.dtos.salle;

import lombok.Data;
import org.example.s6tp3cinema.films.dtos.seance.SeanceDto;

import java.util.List;

@Data
public class SalleDto {

    private Integer id;
    private String nom;
    private int capacite;
    private List<String> equipements;
    private List<SeanceDto> seances;
}
