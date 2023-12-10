package com.microservice.user.client;

import com.microservice.user.entities.Reclamation;
import com.microservice.user.entities.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "reclamation-client-service", url = "${application.config.reclamation-url}")

public interface ReclamationClient {
    @GetMapping("/user/{user-id}")
    List<Reclamation> findAllUsersWithReclamations(@PathVariable("user-id") Long userId);
}
