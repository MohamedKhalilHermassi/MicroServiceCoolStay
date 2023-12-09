package com.microservices.reclamationms.repositories;

import com.microservices.reclamationms.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {
}
