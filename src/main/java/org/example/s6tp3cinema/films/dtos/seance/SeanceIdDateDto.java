package org.example.s6tp3cinema.films.dtos.seance;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SeanceIdDateDto {

    private Integer id;
    private LocalDate date;
}
