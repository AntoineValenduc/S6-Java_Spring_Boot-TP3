package org.example.s6tp3cinema.films.mapper;

import org.example.s6tp3cinema.films.dto.films.FilmDto;
import org.example.s6tp3cinema.films.entities.Film;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FilmMapStruct {

    public FilmMapStruct INSTANCE = Mappers.getMapper(FilmMapStruct.class);

    /**
     * Convertit un Film ENTITY vers un DTO Complet
     * @param entity Film
     * @return FilmDto
     */
    @Mapping(source = "id", target = "id")
    public FilmDto toDto(Film entity);

    /**
     * Convertit un Film DTO Complet vers un ENTITY
     * @param dto FilmDto
     * @return Film
     */
    @Mapping(source = "id", target = "id")
    public Film toEntity(FilmDto dto);
}
