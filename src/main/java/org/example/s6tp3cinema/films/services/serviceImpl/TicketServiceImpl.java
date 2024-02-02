package org.example.s6tp3cinema.films.services.serviceImpl;

import org.example.s6tp3cinema.films.dtos.seance.SeanceDto;
import org.example.s6tp3cinema.films.dtos.ticket.TicketDto;
import org.example.s6tp3cinema.films.dtos.ticket.TicketReduitDto;
import org.example.s6tp3cinema.films.exceptions.seance.SeanceNotFoundException;
import org.example.s6tp3cinema.films.exceptions.ticket.TicketCantBeNullException;
import org.example.s6tp3cinema.films.exceptions.ticket.TicketNotFoundException;
import org.example.s6tp3cinema.films.mappers.SeanceMapper;
import org.example.s6tp3cinema.films.mappers.TicketMapper;
import org.example.s6tp3cinema.films.repositories.TicketRepository;
import org.example.s6tp3cinema.films.services.SeanceService;
import org.example.s6tp3cinema.films.services.TicketService;
import org.example.s6tp3cinema.films.utils.SearchNullPropertiesName;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository repository;

    private final SeanceService seanceService;

    private  final SearchNullPropertiesName utils;

    public TicketServiceImpl(TicketRepository repository, SeanceService seanceService, SearchNullPropertiesName utils) {
        this.repository = repository;
        this.seanceService = seanceService;
        this.utils = utils;
    }

    @Override
    public List<TicketReduitDto> getAllTickets() {
        return repository.findAll()
                .stream()
                .map(TicketMapper.INSTANCE::toDtoReduit)
                .toList();
    }

    @Override
    public Optional<TicketDto> getById(Integer id) {
        return Optional.ofNullable(TicketMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(
                () -> new TicketNotFoundException(id))));
    }

    @Override
    public void createTicket(TicketDto dto) {
        //Vérifie si le DTO est null
        if (dto == null){
            throw new TicketCantBeNullException();
        } else {
            //Vérifie les données de chaque propriété non null
            verifyTicketDtoData(dto);

            //Modifie le nombre de place disponible pour la Seance lié au Ticket
            updateNbrPlaceDisponibleSeance(dto);

            //Enregistrement du Ticket
            repository.saveAndFlush(TicketMapper.INSTANCE.toEntity(dto));
        }
    }

    @Override
    public void createTicket(Integer id, TicketReduitDto dto) {
        //Vérifie si le DTO est null
        if (dto == null){
            throw new TicketCantBeNullException();
        } else {
            //Vérifie les données de chaque propriété non null
            verifyTicketReduitDtoData(dto);

            //Modifie le nombre de places disponibles pour la Seance lié au Ticket
            Optional<SeanceDto> seanceDto = updateNbrPlaceDisponibleSeanceReduit(id, dto);

            Optional<TicketDto> dtoComplet = Optional.ofNullable(TicketMapper.INSTANCE.fromDtoReduitToDto(dto));
            dtoComplet.ifPresent(ticketDto -> ticketDto.setSeance(SeanceMapper.INSTANCE.fromDtoToDtoReduit(seanceDto.get())));

            //Enregistrement du Ticket
            repository.saveAndFlush(TicketMapper.INSTANCE.toEntity(dtoComplet.get()));
        }
    }

    /**
     * Méthode interne permettant de vérifier les données de chaques propriétés du TicketReduitDto ne pouvant pas être null
     * @param dto TicketReduitDto
     */
    private static void verifyTicketReduitDtoData(TicketReduitDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto.getNomClient() == null){
            errors.add("nomClient");
        }
        if(!errors.isEmpty()){
            throw new TicketCantBeNullException(errors);
        }
    }

    /**
     * Soustrait le nombre de places disponibles de la Séance, par le nombre de places réservé dans le TicketReduit
     * @param dto
     */
    private Optional<SeanceDto> updateNbrPlaceDisponibleSeanceReduit(Integer id, TicketReduitDto dto) {
        Optional<SeanceDto> seanceDto = seanceService.getById(id);

        if (seanceDto.isPresent()){
            seanceDto.get().setPlaceDisponibles(seanceDto.get().getPlaceDisponibles() - dto.getNbrPlaces());
            seanceService.updateSeance(seanceDto.get());
        } else {
            throw new SeanceNotFoundException(id);
        }

        return seanceDto;
    }

    /**
     * Soustrait le nombre de places disponibles de la Séance, par le nombre de places réservé dans le Ticket
     * @param dto
     */
    private void updateNbrPlaceDisponibleSeance(TicketDto dto) {
        Optional<SeanceDto> seanceDto = seanceService.getById(dto.getSeance().getId());

        if (seanceDto.isPresent()){
            seanceDto.get().setPlaceDisponibles(seanceDto.get().getPlaceDisponibles() - dto.getNbrPlaces());
            seanceService.updateSeance(seanceDto.get());
        } else {
            throw new SeanceNotFoundException(dto.getSeance().getId());
        }
    }

    /**
     * Méthode interne permettant de vérifier les données de chaques propriétés du TicketDto ne pouvant pas être null
     * @param dto TicketDto
     */
    private static void verifyTicketDtoData(TicketDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto.getSeance() == null){
            errors.add("seance");
        }
        if(dto.getNomClient() == null){
            errors.add("nomClient");
        }
        if(!errors.isEmpty()){
            throw new TicketCantBeNullException(errors);
        }
    }

    @Override
    public void updateTicket(TicketDto dto) {
        //Vérifie si le dto envoi un Ticket null
        if(dto.getId() == null){
            throw new TicketCantBeNullException();
        } else {
            //Récupère le Ticket en BDD
            TicketDto dtoExist = TicketMapper.INSTANCE.toDto(repository.findById(dto.getId())
                    .orElseThrow(() -> new TicketNotFoundException(dto.getId())));

            //Compare le Ticket request et bdd, enregistre le Ticket
            compareAndsaveTicket(dto, dtoExist);
        }

    }

    /**
     * Méthode interne permettant de comparer les données du Ticket existant avec le DTO,<br>
     * de remplacer les données par celles du DTO
     * @param dto TicketDto request
     * @param dtoExist TicketDto bdd
     */
    private void compareAndsaveTicket(TicketDto dto, TicketDto dtoExist) {
        if (dtoExist != null) {
            // Copie des propriétés non nulles du TicketDto vers dtoExist
            BeanUtils.copyProperties(dto, dtoExist, utils.getNullPropertyNames(dto));

            // Enregistrement de l'acteur mis à jour
            repository.saveAndFlush(TicketMapper.INSTANCE.toEntity(dtoExist));
        } else {
            // Exception si l'Acteur n'existe pas en bdd
            throw new TicketNotFoundException(dto.getId());
        }
    }

    @Override
    public void deleteById(Integer id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        } else {
            throw new TicketNotFoundException(id);
        }
    }
}
