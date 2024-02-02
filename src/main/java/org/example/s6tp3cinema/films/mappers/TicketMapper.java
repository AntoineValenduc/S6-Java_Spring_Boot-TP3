package org.example.s6tp3cinema.films.mappers;

import org.example.s6tp3cinema.films.dtos.ticket.TicketDto;
import org.example.s6tp3cinema.films.dtos.ticket.TicketReduitDto;
import org.example.s6tp3cinema.films.entities.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    public TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    /**
     * Convertit un Ticket ENTITY vers un DTO Complet
     * @param entity Ticket
     * @return TicketDto
     */
    @Mapping(source = "id", target = "id")
    public TicketDto toDto(Ticket entity);

    /**
     * Convertit un Ticket DTO Complet vers un ENTITY
     * @param dto Ticket
     * @return TicketDto
     */
    @Mapping(source = "id", target = "id")
    public Ticket toEntity(TicketDto dto);

    /**
     * Convertit un Ticket ENTITY vers un DTO Reduit
     * @param entity Ticket
     * @return TicketReduitDto
     */
    @Mapping(source = "id", target = "id")
    public TicketReduitDto toDtoReduit(Ticket entity);

    /**
     * Convertit un Ticket DTO Reduit vers un ENTITY
     * @param dtoReduit TicketReduitDto
     * @return Ticket
     */
    @Mapping(source = "id", target = "id")
    public Ticket toEntityReduit(TicketReduitDto dtoReduit);

    /**
     * Convertit un Ticket DTO Reduit en Ticket DTO Complet
     * @param dtoReduit TicketReduitDto
     * @return TicketDto
     */
    @Mapping(source = "id", target = "id")
    public TicketDto fromDtoReduitToDto(TicketReduitDto dtoReduit);


}
