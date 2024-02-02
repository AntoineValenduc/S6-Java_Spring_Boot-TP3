package org.example.s6tp3cinema.films.mappers;

import org.example.s6tp3cinema.films.dtos.acteurs.ActeurDto;
import org.example.s6tp3cinema.films.dtos.acteurs.ActeurWithoutFilmsDto;
import org.example.s6tp3cinema.films.entities.Acteur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ActeurMapStruct {

    public ActeurMapStruct INSTANCE = Mappers.getMapper(ActeurMapStruct.class);

    /**
     * Convertit un Acteur ENTITY vers un DTO Complet
     * @param entity Acteur
     * @return ActeurDto
     */
    @Mapping(source = "id",target ="id")
    public ActeurDto toDtoComplet(Acteur entity);

    /**
     * Convertit un Acteur DTO Complet vers un ENTITY
     * @param dto ActeurDto
     * @return Acteur
     */
    @Mapping(source = "id",target = "id")
    public Acteur toEntityComplet(ActeurDto dto);

    /**
     * Convertit un Acteur ENTITY en DTO Réduit
     * @param entity Acteur
     * @return ActeurWithoutFilmsDto
     */
    @Mapping(source = "id",target = "id")
    public ActeurWithoutFilmsDto toDtoReduit(Acteur entity);

}
