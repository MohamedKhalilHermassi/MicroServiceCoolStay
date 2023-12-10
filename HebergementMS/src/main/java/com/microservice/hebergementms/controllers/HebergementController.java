package com.microservice.hebergementms.controllers;

import com.microservice.hebergementms.entities.FullHebergementResponse;
import com.microservice.hebergementms.entities.FullHebergementWithRecommandationResponse;
import com.microservice.hebergementms.entities.Hebergement;
import com.microservice.hebergementms.services.ServiceHebergement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/hebergement")
public class HebergementController {
    private ServiceHebergement serviceHebergement;
    @GetMapping("/get-all")
    public List<Hebergement> getAllHebergement()
    {
       return serviceHebergement.getAll();
    }

    @PostMapping("/add-hebergement")
    public Hebergement addHebergement(@RequestBody Hebergement hebergement)
    {
        return serviceHebergement.add(hebergement);
    }

    @GetMapping("/get-by-id/{id}")
    public Hebergement getHebergementById(@PathVariable("id") Long id)
    {
        return serviceHebergement.getbyId(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteHebergement(@PathVariable("id") Long id)
    {
        serviceHebergement.delete(id);
    }
    @PutMapping("/update")
    public Hebergement updateHebergement(@RequestBody Hebergement hebergement)
    {
        return serviceHebergement.update(hebergement);
    }

    @GetMapping("/with-reservation/{hebergement-id}")
    public ResponseEntity<FullHebergementResponse> findAllHebergement(@PathVariable("hebergement-id") Long hebergementId){
        return  ResponseEntity.ok(serviceHebergement.findHebergementWithReservations(hebergementId));
    }

    @GetMapping("/with-recommandation/{hebergement-id}")
    public ResponseEntity<FullHebergementWithRecommandationResponse> findAllRecommandation(@PathVariable("hebergement-id") Long hebergementId){
        return  ResponseEntity.ok(serviceHebergement.findHebergementWithRecommandation(hebergementId));
    }
}
