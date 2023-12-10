package com.microservice.user.entities;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FullUserWithReclamationResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    private List<Reclamation> reclamations;
}
