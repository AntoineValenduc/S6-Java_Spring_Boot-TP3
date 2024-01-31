package org.example.s6tp3cinema.films.mapper;

import org.example.s6tp3cinema.films.dto.RealisateurDto;
import org.example.s6tp3cinema.films.entities.Realisateur;
import org.springframework.stereotype.Component;

@Component
public class RealisateurMapper {

    public RealisateurDto toDto(Realisateur entity){
        RealisateurDto dto = new RealisateurDto();
        dto.setId(entity.getId());
        dto.setPrenom(entity.getPrenom());
        dto.setNom(entity.getNom());
        return dto;
    }

    public Realisateur toEntity(RealisateurDto dto){
        Realisateur entity = new Realisateur();
        entity.setId(dto.getId());
        entity.setPrenom(dto.getPrenom());
        entity.setNom(entity.getNom());
        return entity;
    }

    
}
