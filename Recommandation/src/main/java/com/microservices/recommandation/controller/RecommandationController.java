package com.microservices.recommandation.controller;

import com.microservices.recommandation.entities.Recommandation;
import com.microservices.recommandation.services.RecommandationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommandations")
public class RecommandationController {
    @Autowired
    private RecommandationService recommandationService;

    @GetMapping("/list-recommandations")
    public List<Recommandation> getListRecommandation() {
        return recommandationService.getAllRecommandations();
    }

    @PostMapping("/ajouter-recommandation")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Recommandation> createRecommandation(@RequestBody Recommandation recommandation) {
        return new ResponseEntity<>(recommandationService.addRecommandation(recommandation), HttpStatus.OK);
    }


    @PutMapping("/modifier-recommandation/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Recommandation> updateRecommandation(@PathVariable(value = "id") int id,
                                                   @RequestBody Recommandation recommandation){
        return new ResponseEntity<>(recommandationService.updateRecommandation(id, recommandation), HttpStatus.OK);
    }


    @DeleteMapping("/delete-recommandation/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(recommandationService.deleteRecommandation(id), HttpStatus.OK);
    }
}
