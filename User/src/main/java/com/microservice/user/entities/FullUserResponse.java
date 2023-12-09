package com.microservice.user.entities;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FullUserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    List<Reservation> reservations;
}
