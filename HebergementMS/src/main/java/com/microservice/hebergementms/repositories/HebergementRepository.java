package com.microservice.hebergementms.repositories;

import com.microservice.hebergementms.entities.Hebergement;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HebergementRepository extends JpaRepository<Hebergement,Long> {

}
