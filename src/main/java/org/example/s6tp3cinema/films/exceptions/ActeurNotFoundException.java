package org.example.s6tp3cinema.films.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ActeurNotFoundException extends NullPointerException {

    public ActeurNotFoundException(Integer id){
        super("L'acteur n'existe pas en bdd pour l'id : " +id);
    }
}
