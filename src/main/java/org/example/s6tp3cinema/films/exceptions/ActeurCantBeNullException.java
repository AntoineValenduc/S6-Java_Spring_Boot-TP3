package org.example.s6tp3cinema.films.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ActeurCantBeNullException extends IllegalArgumentException {

    public ActeurCantBeNullException(){
        super("L'Acteur ne peux pas être null");
    }

    public ActeurCantBeNullException(List<String> proprietes){
        super("La propriété ne peux pas être null : " + proprietes);
    }
}
