package com.microservices.reclamationms.client;

import com.microservices.reclamationms.entities.Reponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "reclamation-reponse-client-service", url = "${application.config.reponse-url}")

public interface ClientReponse {
    @GetMapping("/reclamation/{reclamation-id}")
    Reponse findReclamationWithReponse(@PathVariable("reclamation-id") Long reclamationId);
}
