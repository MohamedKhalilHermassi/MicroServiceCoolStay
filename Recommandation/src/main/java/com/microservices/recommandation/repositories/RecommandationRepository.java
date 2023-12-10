package com.microservices.recommandation.repositories;


import com.microservices.recommandation.entities.Recommandation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommandationRepository extends JpaRepository<Recommandation, Long> {
    List<Recommandation> findAllByIdHebergement(Long heberegementId);
}
