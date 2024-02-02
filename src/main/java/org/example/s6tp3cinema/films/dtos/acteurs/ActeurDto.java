package org.example.s6tp3cinema.films.dtos.acteurs;

import lombok.Data;
import org.example.s6tp3cinema.films.dtos.films.FilmWithoutActeursDto;

import java.util.List;

@Data
public class ActeurDto {

    private Integer id;
    private String prenom;
    private String nom;
    private List<FilmWithoutActeursDto> films;
}
