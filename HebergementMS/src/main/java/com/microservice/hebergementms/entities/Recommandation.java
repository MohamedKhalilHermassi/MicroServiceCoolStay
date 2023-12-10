package com.microservice.hebergementms.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recommandation {

    private String commentaire;
    private Float rating;
    private String auteur;

    private Long idHebergement;
}
