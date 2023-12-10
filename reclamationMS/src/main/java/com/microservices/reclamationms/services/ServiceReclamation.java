package com.microservices.reclamationms.services;

import com.microservices.reclamationms.client.ClientReponse;
import com.microservices.reclamationms.entities.FullReclamationWithResponse;
import com.microservices.reclamationms.entities.Reclamation;
import com.microservices.reclamationms.repositories.ReclamationRepository;
import com.netflix.discovery.converters.Auto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceReclamation {
@Autowired
   private ReclamationRepository reclamationRepository;
@Autowired

    private ClientReponse clientReponse;

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


    public List<Reclamation> FindAllReclamationByUser(Long userId) {
        return reclamationRepository.findAllByUserId(userId);

    }



    public FullReclamationWithResponse findReclamationsWithReponses(Long reclamationId) {

        var reclamation = reclamationRepository.findById(reclamationId)
                .orElse(Reclamation.builder()
                        .type("NOT_FOUND")
                        .status(null)
                        .date(null)
                        .message("NOT_FOUND")
                        .build()
                );
        var reponse = clientReponse.findReclamationWithReponse(reclamationId); // get all reservation from ReservationMS
        return FullReclamationWithResponse.builder()
                .type(reclamation.getType())
                .status(reclamation.getStatus())
                .message(reclamation.getMessage())
                .date(reclamation.getDate())
                .reponse(reponse)


                .build();
    }
    }

