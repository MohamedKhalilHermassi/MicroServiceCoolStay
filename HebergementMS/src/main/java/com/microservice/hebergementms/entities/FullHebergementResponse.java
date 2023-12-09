package com.microservice.hebergementms.entities;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullHebergementResponse {
    private String adresse;
    private String libelle;
    private String nom;
    private Integer capacite;
    private Float prix;
    List<Reservation> reservations;
}
