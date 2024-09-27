package com.example.assesment2.service;

import com.example.assesment2.entity.Reservation;
import com.example.assesment2.exception.ErrorWhileExecutingQuery;
import com.example.assesment2.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    public Reservation addReservation(Reservation reservation){
        try {
            return reservationRepository.save(reservation);
        }catch (Exception e){
            throw  new ErrorWhileExecutingQuery("error while saving reservation");
        }
    }

    public boolean deleteReservation(Integer Id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(Id);

        if (optionalReservation.isPresent()) {
            reservationRepository.deleteById(Id);
            return true;
        } else {
            return false;
        }
    }
}

