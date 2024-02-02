package org.example.s6tp3cinema.films.exceptions.salle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SalleCantBeNullException extends IllegalArgumentException {

    public SalleCantBeNullException(){
        super("La salle ne peut pas être null");
    }

    public SalleCantBeNullException(List<String> properties){
        super("Les propriétés ne peuvent pas être null : " + properties);
    }
}
