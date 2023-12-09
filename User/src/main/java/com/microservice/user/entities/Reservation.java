package com.microservice.user.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date_debut;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate  date_fin;
    private String detail;
}
