package org.example.s6tp3cinema.films.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FilmNotFoundException extends NullPointerException{

    public FilmNotFoundException(Integer id){
        super("Le Film n'existe pas en bdd pour l'id : " + id);
    }

    public FilmNotFoundException(String titre){
        super("Le Film n'existe pas en bdd pour le titre : " + titre);
    }
}
