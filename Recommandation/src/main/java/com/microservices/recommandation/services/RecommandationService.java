package com.microservices.recommandation.services;



import com.microservices.recommandation.entities.Recommandation;
import com.microservices.recommandation.repositories.RecommandationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommandationService {



    @Autowired
    RecommandationRepository recommandationRepository;

    public List<Recommandation> getAllRecommandations() {
        return recommandationRepository.findAll();
    }

    public Recommandation addRecommandation(Recommandation recommandation) {
        return recommandationRepository.save(recommandation);
    }

    public Recommandation updateRecommandation(long id, Recommandation newRecommandation) {

        if (recommandationRepository.findById(id).isPresent()) {
            Recommandation existingRecommandation = recommandationRepository.findById(id).get();

            existingRecommandation.setCommentaire(newRecommandation.getCommentaire());
            existingRecommandation.setRating(newRecommandation.getRating());
            existingRecommandation.setAuteur(newRecommandation.getAuteur());

            return recommandationRepository.save(existingRecommandation);
        } else {
            return null;
        }
    }

    public String deleteRecommandation(long id) {

        if ( recommandationRepository.findById(id).isPresent()) {
            recommandationRepository.deleteById(id);
            return "Recommandation supprimée avec succès.";
        } else {
            return "La recommandation à supprimer n'a pas été trouvée.";
        }
    }
}
