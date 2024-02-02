package org.example.s6tp3cinema.films.exceptions.realisateur;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RealisateurCantBeNullException extends IllegalArgumentException {

    public RealisateurCantBeNullException(){
        super("Le réalisateur ne peut pas être null");
    }

    public RealisateurCantBeNullException(List<String> proprietes){
        super("Les propriétées du réalisateur ne peuvent pas être null : " + proprietes);
    }
}
