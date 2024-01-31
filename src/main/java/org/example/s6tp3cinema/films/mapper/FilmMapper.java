package org.example.s6tp3cinema.films.mapper;

import org.example.s6tp3cinema.films.dto.FilmDto;
import org.example.s6tp3cinema.films.entities.Film;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {

    private final ActeurMapper acteurMapper;

    private final RealisateurMapper realisateurMapper;

    public FilmMapper(ActeurMapper acteurMapper, RealisateurMapper realisateurMapper) {
        this.acteurMapper = acteurMapper;
        this.realisateurMapper = realisateurMapper;
    }

    /**
     * Mapper pour retourner un Film DTO à partir d'un ENTITY
     * @param entity Film
     * @return FilmDto
     */
    public FilmDto toDto(Film entity){
        FilmDto dto = new FilmDto();
        dto.setId(entity.getId());
        dto.setTitre(entity.getTitre());
        dto.setDuree(entity.getDuree());
        dto.setSynopsis(entity.getSynopsis());
        dto.setDateSortie(entity.getDateSortie());
        dto.setRealisateur(realisateurMapper.toDto(entity.getRealisateur()));
        dto.setActeurs(acteurMapper.toDtoList(entity.getActeurs()));
        return dto;
    }

    /**
     * Mapper pour retourner un Film ENTITY à partir d'un DTO
     * @param dto FilmDto
     * @return Film
     */
    public Film toEntity(FilmDto dto){
        Film entity = new Film();
        entity.setId(dto.getId());
        entity.setTitre(dto.getTitre());
        entity.setDuree(dto.getDuree());
        entity.setSynopsis(dto.getSynopsis());
        entity.setDateSortie(dto.getDateSortie());
        entity.setRealisateur(realisateurMapper.toEntity(dto.getRealisateur()));
        entity.setActeurs(acteurMapper.toEntityList(dto.getActeurs()));
        return entity;
    }
}
