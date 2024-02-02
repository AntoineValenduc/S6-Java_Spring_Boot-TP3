package org.example.s6tp3cinema.films.exceptions.acteur;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ActeurAlreadyAttributException extends RuntimeException {

    public ActeurAlreadyAttributException(Integer id){
        super("L'acteur est déjà attribué pour l'id : " + id);
    }
}
