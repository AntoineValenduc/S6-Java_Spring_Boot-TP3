package org.example.s6tp3cinema.films.services.serviceImpl;

import org.example.s6tp3cinema.films.dtos.salle.SalleDto;
import org.example.s6tp3cinema.films.dtos.salle.SalleReduitDto;
import org.example.s6tp3cinema.films.exceptions.salle.SalleCantBeNullException;
import org.example.s6tp3cinema.films.exceptions.salle.SalleNotFoundException;
import org.example.s6tp3cinema.films.mappers.SalleMapper;
import org.example.s6tp3cinema.films.repositories.SalleRepository;
import org.example.s6tp3cinema.films.services.SalleService;
import org.example.s6tp3cinema.films.utils.SearchNullPropertiesName;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalleServiceImpl implements SalleService {

    private final SalleRepository repository;

    private final SearchNullPropertiesName utils;

    public SalleServiceImpl(SalleRepository repository, SearchNullPropertiesName utils) {
        this.repository = repository;
        this.utils = utils;
    }

    @Override
    public List<SalleReduitDto> getAllSalle() {
        return repository.findAll()
                .stream()
                .map(SalleMapper.INSTANCE::toDtoReduit)
                .toList();
    }

    @Override
    public Optional<SalleDto> getById(Integer id) {
        return Optional.ofNullable(SalleMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(
                () -> new SalleNotFoundException(id))));
    }

    @Override
    public void createSalle(SalleDto dto) {
        //Vérifie si le DTO est null
        if (dto == null){
            throw new SalleCantBeNullException();
        } else {
            //Vérifie les données de chaque propriété non null
            verifySalleDtoData(dto);

            //Enregistrement de la Salle
            repository.saveAndFlush(SalleMapper.INSTANCE.toEntity(dto));
        }
    }

    /**
     * Méthode interne permettant de vérifier les données de chaques propriétés de la Salle Dto ne pouvant pas être null
     * @param dto SalleDto
     */
    private static void verifySalleDtoData(SalleDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto.getCapacite() == 0){
            errors.add("capacite");
        }
        if(dto.getNom() == null){
            errors.add("numero");
        }
        if(!errors.isEmpty()){
            throw  new SalleCantBeNullException(errors);
        }
    }

    @Override
    public void updateSalle(SalleDto dto) {
        //Vérifie si le dto envoi un Salle null
        if(dto.getId() == null){
            // Exception si envoie Salle null
            throw new SalleCantBeNullException();
        } else {
            verifyDtoData(dto);
        }

    }

    private void verifyDtoData(SalleDto dto) {
        //Récupère la Salle en BDD
        SalleDto dtoExist = SalleMapper.INSTANCE.toDto(repository.findById(dto.getId())
                .orElseThrow(() -> new SalleNotFoundException(dto.getId())));

        //Compare la Salle request et bdd, enregistre la Salle
        compareAndsaveSalle(dto, dtoExist);
    }

    /**
     * Méthode interne permettant de comparer les données du Salle existant avec le DTO,<br>
     * de remplacer les données par celles du DTO
     * @param dto SalleDto request
     * @param dtoExist SalleDto bdd
     */
    private void compareAndsaveSalle(SalleDto dto, SalleDto dtoExist) {
        if (dtoExist != null) {
            // Copie des propriétés non nulles de la SalleDto vers dtoExist
            BeanUtils.copyProperties(dto, dtoExist, utils.getNullPropertyNames(dto));

            // Enregistrement de la Salle mis à jour
            repository.saveAndFlush(SalleMapper.INSTANCE.toEntity(dtoExist));
        } else {
            // Exception si la Salle n'existe pas en bdd
            throw new SalleNotFoundException(dto.getId());
        }
    }

    @Override
    public void deleteById(Integer id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        } else {
            throw new SalleNotFoundException(id);
        }
    }
}
