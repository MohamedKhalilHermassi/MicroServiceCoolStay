package com.microservice.hebergementms.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

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
