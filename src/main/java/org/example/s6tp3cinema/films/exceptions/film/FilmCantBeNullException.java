package org.example.s6tp3cinema.films.exceptions.film;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FilmCantBeNullException extends IllegalArgumentException{

    public FilmCantBeNullException(){
        super("Le Film ne peut pas être null");
    }

    public FilmCantBeNullException(List<String> proprietes){
        super("Le Film ne peut pas être null : " + proprietes);
    }
}
