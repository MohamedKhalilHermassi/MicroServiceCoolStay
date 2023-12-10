package com.microservices.reclamationms.controllers;

import com.microservices.reclamationms.entities.FullReclamationWithResponse;
import com.microservices.reclamationms.entities.Reclamation;
import com.microservices.reclamationms.services.ServiceReclamation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reclamations")
public class ReclamationController {
    private ServiceReclamation serviceReclamation;

    @PostMapping("/add-reclamation")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
        return serviceReclamation.add(reclamation);
    }

    @GetMapping("/get-all-reclamations")
    public List<Reclamation> getAllReclamation() {
        return serviceReclamation.getAllReclamation();
    }

    @PutMapping("/update-reclamtion")
    public Reclamation updateReclamaton(@RequestBody Reclamation reclamation) {
        reclamation.setDate(LocalDate.now());
        return serviceReclamation.update(reclamation);
    }

    @GetMapping("/get-by-id/{id}")
    public Reclamation getReclamationById(@PathVariable("id") Long id) {
        return serviceReclamation.getbyId(id);

    }




    @GetMapping("/user/{user-id}")
    public ResponseEntity<List<Reclamation>> findReclamationbyUser(
            @PathVariable("user-id")  Long userId)
    {
        return ResponseEntity.ok(serviceReclamation.FindAllReclamationByUser(userId));
    }
    @GetMapping("/with-reponse/{reclamation-id}")
    public ResponseEntity<FullReclamationWithResponse> findReclamationwithResponse(@PathVariable("reclamation-id") Long reclamationId){
        return  ResponseEntity.ok(serviceReclamation.findReclamationsWithReponses(reclamationId));
    }


}
