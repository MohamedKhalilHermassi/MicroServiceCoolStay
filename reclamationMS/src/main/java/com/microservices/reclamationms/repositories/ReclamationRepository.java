package com.microservices.reclamationms.repositories;

import com.microservices.reclamationms.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {
    List<Reclamation> findAllByUserId(Long userId);
}
