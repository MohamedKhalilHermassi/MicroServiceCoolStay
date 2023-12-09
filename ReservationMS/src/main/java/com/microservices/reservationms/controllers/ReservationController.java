package com.microservices.reservationms.controllers;

import com.microservices.reservationms.entities.Reservation;
import com.microservices.reservationms.services.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    private ReservationService reservationService;
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation reservation)
    {
        return reservationService.add(reservation);
    }

    @GetMapping("/get-all")
    public List<Reservation> getAllReservation()
    {
        return reservationService.getAll();
    }

    @GetMapping("/get-by-id/{id}")
    public Reservation getById(@PathVariable("id") Long id)
    {
        return reservationService.getbyId(id);
    }
    @PutMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation reservation)
    {
       return reservationService.update(reservation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable("id") Long id)
    {
        reservationService.delete(id);
    }

    @GetMapping("/hebergement/{hebergement-id}")
    public ResponseEntity<List<Reservation>> findReservationByHebergement(
            @PathVariable("hebergement-id") Long hebergementId){
        return ResponseEntity.ok(reservationService.FindAllReservationByHebergement(hebergementId));

    }

}
