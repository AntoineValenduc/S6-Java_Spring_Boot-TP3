package org.example.s6tp3cinema.films.exceptions.seance;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SeanceCantBeNullException extends IllegalArgumentException {

    public SeanceCantBeNullException(){
        super("La séance ne peut pas être null");
    }

    public SeanceCantBeNullException(List<String> properties){
        super("Les propriétés ne peuvent pas être null : " + properties);
    }
}
