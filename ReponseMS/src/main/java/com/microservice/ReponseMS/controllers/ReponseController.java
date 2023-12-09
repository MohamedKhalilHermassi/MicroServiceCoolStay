package com.microservice.ReponseMS.controllers;

import com.microservice.ReponseMS.entities.Reponse;
import com.microservice.ReponseMS.services.ReponseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reponse")
public class ReponseController {
  private ReponseService reponseService ;
    @GetMapping("/get-all")
    public List<Reponse> getAllReponse()
    {
        return reponseService.getAll();
    }
    @PostMapping("/add-reponse")
    public Reponse addReponse(@RequestBody Reponse reponse)
    {
        return reponseService.add(reponse);
    }
    @GetMapping("/get-by-id/{id}")
    public Reponse getReponseById(@PathVariable("id") Long id)
    {
        return reponseService.getbyId(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteReponse(@PathVariable("id") Long id)
    {
        reponseService.delete(id);
    }
    @PutMapping("/update")
    public Reponse updateReponse(@RequestBody Reponse reponse)
    {
        return reponseService.update(reponse);
    }
}
