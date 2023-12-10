package com.microservices.reclamationms.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FullReclamationWithResponse {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private Boolean status;
    private String message;
    private String type;
    private Reponse reponse;
}
