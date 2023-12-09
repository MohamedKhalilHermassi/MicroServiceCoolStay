package com.microservices.reservationms.repositories;

import com.microservices.reservationms.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    List<Reservation> findAllByHebergementId(Long hebergementId);
}
