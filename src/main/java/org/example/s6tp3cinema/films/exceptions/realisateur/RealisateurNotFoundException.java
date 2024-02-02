package org.example.s6tp3cinema.films.exceptions.realisateur;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RealisateurNotFoundException extends NullPointerException{

    public RealisateurNotFoundException(Integer id ){
        super("Réalisateur introuvable pour l'id : " + id);
    }
}
