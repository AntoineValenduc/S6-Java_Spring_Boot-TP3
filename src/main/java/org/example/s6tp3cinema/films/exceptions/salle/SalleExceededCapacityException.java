package org.example.s6tp3cinema.films.exceptions.salle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SalleExceededCapacityException extends IllegalArgumentException{

    public SalleExceededCapacityException(Integer capacite, Integer placeDispo ){
        super("Le nombre de place disponible de la séance est supérieur à la capacité de la salle : " + placeDispo + " > " + capacite);
    }
}
