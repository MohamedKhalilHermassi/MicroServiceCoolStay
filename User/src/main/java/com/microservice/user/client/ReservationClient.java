package com.microservice.user.client;

import com.microservice.user.entities.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-service", url = "${application.config.reservation-url}")
public interface ReservationClient {

    @GetMapping("/user/{user-id}")
    List<Reservation> findAllUsersWithReservations(@PathVariable("user-id") Long userId);
}