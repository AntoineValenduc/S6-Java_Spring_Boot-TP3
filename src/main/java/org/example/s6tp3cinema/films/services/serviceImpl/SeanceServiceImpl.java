package org.example.s6tp3cinema.films.services.serviceImpl;

import org.example.s6tp3cinema.films.dtos.salle.SalleDto;
import org.example.s6tp3cinema.films.dtos.seance.SeanceDto;
import org.example.s6tp3cinema.films.dtos.seance.SeanceReduitDto;
import org.example.s6tp3cinema.films.dtos.ticket.TicketDto;
import org.example.s6tp3cinema.films.dtos.ticket.TicketReduitDto;
import org.example.s6tp3cinema.films.exceptions.salle.SalleExceededCapacityException;
import org.example.s6tp3cinema.films.exceptions.seance.SeanceCantBeNullException;
import org.example.s6tp3cinema.films.exceptions.seance.SeanceNotFoundException;
import org.example.s6tp3cinema.films.mappers.SeanceMapper;
import org.example.s6tp3cinema.films.repositories.SeanceRepository;
import org.example.s6tp3cinema.films.services.SalleService;
import org.example.s6tp3cinema.films.services.SeanceService;
import org.example.s6tp3cinema.films.services.TicketService;
import org.example.s6tp3cinema.films.utils.SearchNullPropertiesName;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SeanceServiceImpl implements SeanceService {

    private final SeanceRepository repository;

    private final SearchNullPropertiesName utils;

    private final SalleService salleService;


    public SeanceServiceImpl(SeanceRepository repository, SearchNullPropertiesName utils, SalleService salleService) {
        this.repository = repository;
        this.utils = utils;
        this.salleService = salleService;
    }

    @Override
    public List<SeanceReduitDto> getAllSeance() {
        return repository.findAll()
                .stream()
                .map(SeanceMapper.INSTANCE::toDtoReduit)
                .toList();
    }

    @Override
    public List<SeanceDto> getListSeanceFromFilmId(Integer id, LocalDate date) {
        return repository.findAllByFilm_IdAndDateAfterAndPlaceDisponiblesNotEmpty(id, date)
                .stream()
                .map(SeanceMapper.INSTANCE::toDto)
                .toList();
    }

    @Override
    public Optional<SeanceDto> getById(Integer id) {
        return Optional.ofNullable(SeanceMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(
                () -> new SeanceNotFoundException(id))));
    }

    @Override
    public List<TicketReduitDto> getListTicketsFromSeanceById(Integer id) {
        return getById(id).get().getTickets();
    }

    @Override
    public void createSeance(SeanceDto dto) {
        //Vérifie si le DTO est null
        if (dto == null){
            throw new SeanceCantBeNullException();
        } else {
            //Vérifie les données de chaque propriété non null
            verifySeanceDtoData(dto);

            //Vérifie que le nombre de places disponibles de la séance est <= à la capacité de la salle liée
            verifyNbrPlaceSalle(dto);

            //Enregistrement de la Séance
            repository.saveAndFlush(SeanceMapper.INSTANCE.toEntity(dto));
        }
    }

    /**
     * Vérifie la cohérence du nombre de places de la salle et des places disponibles de la séance
     * @param dto SeanceDto
     * @return SeanceDto
     */
    private void verifyNbrPlaceSalle(SeanceDto dto) {
        Optional<SalleDto> salleDto = salleService.getById(dto.getSalle().getId());

        if (salleDto.isPresent()){
            if (salleDto.get().getCapacite() < dto.getPlaceDisponibles()){
                throw new SalleExceededCapacityException(salleDto.get().getCapacite(), dto.getPlaceDisponibles());
            }
        }
    }

    /**
     * Méthode interne permettant de vérifier les données de chaques propriétés de la SeanceDto ne pouvant pas être null
     * @param dto SeanceDto
     */
    private static void verifySeanceDtoData(SeanceDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto.getDate() == null){
            errors.add("date");
        }
        if(dto.getPrix() == 0){
            errors.add("prix");
        }
        if(dto.getPlaceDisponibles() == 0){
            errors.add("prix");
        }
        if(dto.getFilm() == null){
            errors.add("film");
        }
        if(!errors.isEmpty()){
            throw  new SeanceCantBeNullException(errors);
        }
    }

    @Override
    public void updateSeance(SeanceDto dto) {
        //Vérifie si le dto envoi un Séance null
        if(dto.getId() == null){
            throw new SeanceCantBeNullException();
        } else {
            //Récupère la Séance en BDD
            SeanceDto dtoExist = SeanceMapper.INSTANCE.toDto(repository.findById(dto.getId())
                    .orElseThrow(() -> new SeanceNotFoundException(dto.getId())));

            //Compare la Seance request et bdd, enregistre la Séance
            compareAndSaveSeance(dto, dtoExist);
        }

    }

    /**
     * Méthode interne permettant de comparer les données du Séance existant avec le DTO,<br>
     * de remplacer les données par celles du DTO
     * @param dto SeanceDto request
     * @param dtoExist SeanceDto bdd
     */
    private void compareAndSaveSeance(SeanceDto dto, SeanceDto dtoExist) {
        if (dtoExist != null) {
            // Copie des propriétés non nulles du SeanceDto vers dtoExist
            BeanUtils.copyProperties(dto, dtoExist, utils.getNullPropertyNames(dto));

            // Enregistrement de la Séance mis à jour
            repository.saveAndFlush(SeanceMapper.INSTANCE.toEntity(dtoExist));
        } else {
            // Exception si la Seance n'existe pas en bdd
            throw new SeanceNotFoundException(dto.getId());
        }
    }

    @Override
    public void deleteById(Integer id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        } else {
            throw new SeanceNotFoundException(id);
        }
    }
}
