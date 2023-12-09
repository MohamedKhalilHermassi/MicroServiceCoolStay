package com.microservices.reservationms.services;

import com.microservices.reservationms.entities.Reservation;
import com.microservices.reservationms.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {
    private ReservationRepository reservationRepository;
    public Reservation add(Reservation reservation)
    {
       return reservationRepository.save(reservation);
    }

    public List<Reservation> getAll()
    {
        return reservationRepository.findAll();
    }

    public Reservation getbyId(Long id)
    {
        return reservationRepository.findById(id).get();
    }
    public Reservation update(Reservation reservation)
    {
        return reservationRepository.save(reservation);
    }

    public void delete(Long id)
    {
        reservationRepository.deleteById(id);
    }
}
