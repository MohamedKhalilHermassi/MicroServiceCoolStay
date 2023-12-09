package com.microservices.reclamationms.services;

import com.microservices.reclamationms.entities.Reclamation;
import com.microservices.reclamationms.repositories.ReclamationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceReclamation {
   private ReclamationRepository reclamationRepository;

   public Reclamation add(Reclamation reclamation)
   {
       reclamation.setDate(LocalDate.now());
    return   reclamationRepository.save(reclamation);
   }

   public List<Reclamation> getAllReclamation()
   {
       return reclamationRepository.findAll();
   }

   public Reclamation getbyId(Long id)
   {
       return reclamationRepository.findById(id).get();
   }

   public Reclamation update(Reclamation reclamation)
   {
       return reclamationRepository.save(reclamation);
   }



}
