package org.example.s6tp3cinema.films.dto.acteurs;


import lombok.Data;
import org.example.s6tp3cinema.films.dto.films.FilmDtoId;

import java.util.ArrayList;
import java.util.List;

@Data
public class ActeurCreateUpdateDto {
    private Integer id;
    private String prenom;
    private String nom;
    private List<FilmDtoId> films = new ArrayList<>();
}
