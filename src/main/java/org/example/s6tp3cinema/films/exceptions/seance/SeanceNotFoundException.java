package org.example.s6tp3cinema.films.exceptions.seance;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SeanceNotFoundException extends NullPointerException{

    public SeanceNotFoundException(Integer id){
        super("La séance n'existe pas en bdd pour l'id : " + id);
    }
}