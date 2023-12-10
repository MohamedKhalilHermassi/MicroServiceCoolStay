package com.microservices.reclamationms.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Reponse {
    private String message;
    private String Auteur;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

}
