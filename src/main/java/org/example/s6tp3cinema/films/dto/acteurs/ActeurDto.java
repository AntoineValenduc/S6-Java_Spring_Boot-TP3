package org.example.s6tp3cinema.films.dto.acteurs;

import lombok.Data;
import org.example.s6tp3cinema.films.dto.films.FilmWithoutActeursDto;

import java.util.ArrayList;
import java.util.List;

@Data
public class ActeurDto {

    private Integer id;
    private String prenom;
    private String nom;
    private List<FilmWithoutActeursDto> films = new ArrayList<>();
}
