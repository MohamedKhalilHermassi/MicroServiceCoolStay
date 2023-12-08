package com.microservice.hebergementms.services;

import com.microservice.hebergementms.entities.Hebergement;
import com.microservice.hebergementms.repositories.HebergementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceHebergement {
   private HebergementRepository hebergementRepository;

   public Hebergement add(Hebergement hebergement)
   {
      return hebergementRepository.save(hebergement);
   }
   public List<Hebergement> getAll()
   {

       return hebergementRepository.findAll();
   }
   public Hebergement getbyId(Long id)
   {

       return  hebergementRepository.findById(id).get();
   }

   public void delete(Long id)
   {
       hebergementRepository.deleteById(id);
   }
   public Hebergement update(Hebergement hebergement)
   {
  return  hebergementRepository.save(hebergement);
   }

}
