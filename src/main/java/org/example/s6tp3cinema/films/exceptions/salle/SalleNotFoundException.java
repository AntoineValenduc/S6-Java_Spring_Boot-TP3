package org.example.s6tp3cinema.films.exceptions.salle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SalleNotFoundException extends NullPointerException{

    public SalleNotFoundException(Integer id){
        super("La salle n'existe pas en bdd pour l'id : " + id);
    }
}
