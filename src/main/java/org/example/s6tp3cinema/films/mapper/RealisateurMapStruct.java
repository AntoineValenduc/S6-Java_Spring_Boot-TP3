package org.example.s6tp3cinema.films.mapper;

import org.example.s6tp3cinema.films.dto.films.FilmOnlyTitreAndDateSortieAndDureeDto;
import org.example.s6tp3cinema.films.dto.realisateur.RealisateurDto;
import org.example.s6tp3cinema.films.dto.realisateur.RealisateurDtoWithoutFilm;
import org.example.s6tp3cinema.films.entities.Film;
import org.example.s6tp3cinema.films.entities.Realisateur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface RealisateurMapStruct {

    public RealisateurMapStruct INSTANCE = Mappers.getMapper(RealisateurMapStruct.class);

    /**
     * Convertit un Realisateur ENTITE vers un DTO Complet
     * @param entity Realisateur
     * @return RealisateurDto
     */
    @Mapping(source = "id",target ="id")
    RealisateurDto toDtoComplet(Realisateur entity);

    /**
     * Convertit un Realisateur DTO Complet vers un ENTITY
     * @param dto RealisateurDto
     * @return Realisateur
     */
    @Mapping(source = "id", target = "id")
    Realisateur toEntityComplet(RealisateurDto dto);

    /**
     * Convertit un Realisateur ENTITE vers un DTO Reduit (id, nom, prenom)
     * @param entity Realisateur
     * @return RealisateurDtoWithoutFilm (id, nom, prenom)
     */
    @Mapping(source = "id", target = "id")
    RealisateurDtoWithoutFilm toDtoReduit(Realisateur entity);

    /**
     * Convertir une liste de Films ENTITY en liste de Films Réduit
     * @param entityList List Film
     * @return List FilmOnlyTitreAndDateSortieAndDureeDto
     */
    @Mapping(source = "id", target = "id")
    List<FilmOnlyTitreAndDateSortieAndDureeDto> toDtoListFilm(List<Film> entityList);

}
