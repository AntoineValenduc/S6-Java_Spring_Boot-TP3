package org.example.s6tp3cinema.films.mapper;

import org.example.s6tp3cinema.films.dto.ActeurDtoWithoutFilm;
import org.example.s6tp3cinema.films.entities.Acteur;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActeurMapper {

    /**
     * Mapper pour retourner un Acteur DTO à partir de ENTITY
     * @param entity Acteur
     * @return ActeurDtoWithoutFilm
     */
    public ActeurDtoWithoutFilm toDto(Acteur entity){
        ActeurDtoWithoutFilm dto = new ActeurDtoWithoutFilm();
        dto.setId(entity.getId());
        dto.setNom(entity.getNom());
        dto.setPrenom(entity.getPrenom());
        return dto;
    }

    /**
     * Mapper pour retourner une liste d'Acteur DTO à partir d'une liste d'acteur ENTITY
     * @param entityList List<Acteur>
     * @return List<ActeurDtoWithoutFilm>
     */
    public List<ActeurDtoWithoutFilm> toDtoList(List<Acteur> entityList){
        ActeurDtoWithoutFilm dto = new ActeurDtoWithoutFilm();
        List<ActeurDtoWithoutFilm> dtoList = new ArrayList<>();
        for (Acteur entity : entityList){
            dto.setId(entity.getId());
            dto.setNom(entity.getNom());
            dto.setPrenom(entity.getPrenom());
            dtoList.add(dto);
        }
        return dtoList;
    }

    /**
     * Mapper pour retourner une liste d'Acteur ENTITY à partir d'une liste d'acteur DTO
     * @param dto ActeurDtoWithoutFilm
     * @return Acteur
     */
    public Acteur toEntity(ActeurDtoWithoutFilm dto){
        Acteur entity = new Acteur();
        entity.setId(dto.getId());
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        return entity;
    }

    /**
     * Mapper pour retourner une liste d'Acteur ENTITY à partir d'une liste d'acteur DTO
     * @param dtoList List<ActeurDtoWithoutFilm>
     * @return List<Acteur>
     */
    public List<Acteur> toEntityList(List<ActeurDtoWithoutFilm> dtoList){
        Acteur entity = new Acteur();
        List<Acteur> entityList = new ArrayList<>();
        for (ActeurDtoWithoutFilm dto : dtoList){
            entity.setId(dto.getId());
            entity.setNom(dto.getNom());
            entity.setPrenom(dto.getPrenom());
            entityList.add(entity);
        }
        return entityList;
    }
}
