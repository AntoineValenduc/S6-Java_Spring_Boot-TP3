package org.example.s6tp3cinema.films.services;

import org.example.s6tp3cinema.films.dtos.salle.SalleDto;
import org.example.s6tp3cinema.films.dtos.salle.SalleReduitDto;

import java.util.List;
import java.util.Optional;

public interface SalleService {

    /**
     * Retourne la liste des SallesDto Reduites
     * @return Liste SalleReduitDto
     */
    public List<SalleReduitDto> getAllSalle();

    /**
     * Retourne une SalleDto Complète, à partir de son ID
     * @param id Integer
     * @return SalleDto
     */
    public Optional<SalleDto> getById(Integer id);

    /**
     * Crée une nouvelle Salle Complète
     * @param dto SalleDto
     */
    public void createSalle(SalleDto dto);

    /**
     * Modifie une Salle déjà existante
     * @param dto SalleDto
     */
    public void updateSalle(SalleDto dto);

    /**
     * Supprime une Salle déjà existante, à partir de son ID
     * @param id Integer
     */
    public void deleteById(Integer id);

}
