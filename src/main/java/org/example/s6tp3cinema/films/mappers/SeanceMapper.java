package org.example.s6tp3cinema.films.mappers;

import org.example.s6tp3cinema.films.dtos.seance.SeanceDto;
import org.example.s6tp3cinema.films.dtos.seance.SeanceIdDateDto;
import org.example.s6tp3cinema.films.dtos.seance.SeanceReduitDto;
import org.example.s6tp3cinema.films.entities.Seance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SeanceMapper {

    public SeanceMapper INSTANCE = Mappers.getMapper(SeanceMapper.class);

    /**
     * Convertit une Seance ENTITY vers un DTO Complet
     * @param entity Seance
     * @return SeanceDto
     */
    @Mapping(source = "id", target = "id")
    public SeanceDto toDto(Seance entity);

    /**
     * Convertit une Seance DTO Complet vers un ENTITY
     * @param dto SeanceDto
     * @return Seance
     */
    @Mapping(source = "id", target = "id")
    public Seance toEntity(SeanceDto dto);

    /**
     * Convertit une Seance ENTITY vers un DTO Reduit
     * @param entity Seance
     * @return SeanceDto
     */
    @Mapping(source = "id", target = "id")
    public SeanceReduitDto toDtoReduit(Seance entity);

    /**
     * Convertit une Seance DTO Reduit vers un ENTITY
     * @param dtoReduit SeanceDto
     * @return Seance
     */
    @Mapping(source = "id", target = "id")
    public Seance toEntityReduit(SeanceReduitDto dtoReduit);

    /**
     * Convertit une SeanceDto Complet en SeanceDtoReduit
     * @param dto SeanceDto
     * @return SeanceDtoReduit
     */
    @Mapping(source = "id", target = "id")
    public SeanceReduitDto fromDtoToDtoReduit(SeanceDto dto);

    @Mapping(source = "id", target = "id")
    public SeanceIdDateDto toDtoIdDate(SeanceReduitDto dto);

}
