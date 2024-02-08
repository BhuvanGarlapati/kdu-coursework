package com.example.assesment2.repository;

import com.example.assesment2.entity.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface TicketBookingRepository extends JpaRepository<TicketBooking,Integer> {

    }


