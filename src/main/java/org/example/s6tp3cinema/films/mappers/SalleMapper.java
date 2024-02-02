package org.example.s6tp3cinema.films.mappers;

import org.example.s6tp3cinema.films.dtos.salle.SalleDto;
import org.example.s6tp3cinema.films.dtos.salle.SalleReduitDto;
import org.example.s6tp3cinema.films.entities.Salle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SalleMapper {

    public SalleMapper INSTANCE = Mappers.getMapper(SalleMapper.class);

    /**
     * Convertit une Salle ENTITY vers un DTO Complet
     * @param entity Salle
     * @return SalleDto
     */
    @Mapping(source = "id", target = "id")
    public SalleDto toDto(Salle entity);

    /**
     * Convertit une Salle DTO Complet vers un ENTITY
     * @param dto SalleDto
     * @return Salle
     */
    @Mapping(source = "id", target = "id")
    public Salle toEntity(SalleDto dto);

    /**
     * Convertit une Salle ENTITY vers un DTO Reduit
     * @param entity Salle
     * @return SalleDto
     */
    @Mapping(source = "id", target = "id")
    public SalleReduitDto toDtoReduit(Salle entity);

    /**
     * Convertit une Salle DTO Reduit vers un ENTITY
     * @param dtoReduit SalleDto
     * @return Salle
     */
    @Mapping(source = "id", target = "id")
    public Salle toEntityReduit(SalleReduitDto dtoReduit);
}
