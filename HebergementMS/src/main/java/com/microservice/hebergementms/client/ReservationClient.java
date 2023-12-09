package com.microservice.hebergementms.client;

import com.microservice.hebergementms.entities.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "reservation-service", url = "${application.config.reservation-url}")
public interface ReservationClient {

    @GetMapping("/hebergement/{hebergement-id}")
    List<Reservation> findAllReservationbyHebergement(@PathVariable("hebergement-id") Long hebergementId);
}
