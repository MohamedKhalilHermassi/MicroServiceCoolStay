package com.microservices.recommandation.repositories;


import com.microservices.recommandation.entities.Recommandation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommandationRepository extends JpaRepository<Recommandation, Long> {
}
