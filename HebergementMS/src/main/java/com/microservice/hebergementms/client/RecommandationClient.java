package com.microservice.hebergementms.client;

import com.microservice.hebergementms.entities.Recommandation;
import com.microservice.hebergementms.entities.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "recommandation-service", url = "${application.config.recommandation-url}")
public interface RecommandationClient {
    @GetMapping("/hebergement/{hebergement-id}")
    List<Recommandation> findRecommandationByHebregement(@PathVariable("hebergement-id") Long hebergementId);
}
