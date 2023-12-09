package com.microservice.hebergementms.services;

import com.microservice.hebergementms.client.ReservationClient;
import com.microservice.hebergementms.entities.FullHebergementResponse;
import com.microservice.hebergementms.entities.Hebergement;
import com.microservice.hebergementms.repositories.HebergementRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceHebergement {
   private HebergementRepository hebergementRepository;
    private ReservationClient reservationClient;
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

    public FullHebergementResponse findHebergementWithReservations(Long hebergementId) {
        var hebergement = hebergementRepository.findById(hebergementId)
                .orElse(Hebergement.builder().nom("NOT_FOUND")
                        .libelle("NOT_FOUND")
                        .adresse("NOT_FOUND")
                        .capacite(null)
                        .prix(null)
                        .build()
                );
        var reservation = reservationClient.findAllReservationbyHebergement(hebergementId); // get all reservation from ReservationMS
        return FullHebergementResponse.builder()
                .nom(hebergement.getNom())
                .adresse(hebergement.getAdresse())
                .reservations(reservation)
                .prix(hebergement.getPrix())
                .libelle(hebergement.getLibelle())
                .capacite(hebergement.getCapacite())

                    .build();
    }
}
