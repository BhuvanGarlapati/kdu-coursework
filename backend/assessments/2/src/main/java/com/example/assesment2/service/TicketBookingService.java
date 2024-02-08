package com.example.assesment2.service;

import com.example.assesment2.entity.Catalog;
import com.example.assesment2.entity.Reservation;
import com.example.assesment2.entity.TicketBooking;
import com.example.assesment2.entity.Users;
import com.example.assesment2.exception.ErrorWhileExecutingQuery;
import com.example.assesment2.repository.CatalogRepository;
import com.example.assesment2.repository.ReservationRepository;
import com.example.assesment2.repository.TicketBookingRepository;
import com.example.assesment2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;



@Service
public class TicketBookingService {

    private UserRepository userRepository;
    private ReservationRepository reservationRepository;
    private CatalogRepository catalogRepository;

    private TicketBookingRepository ticketBookingRepository;

    @Autowired
    public TicketBookingService(TicketBookingRepository ticketBookingRepository){
        this.ticketBookingRepository = ticketBookingRepository;
    }


    public TicketBooking getTickets(int Id){
        try {
            Reservation reservation = reservationRepository.getReferenceById(Id);
            Users users = userRepository.getReferenceById(reservation.getUsers().getUserId());
            int total = 0;

            for (Catalog products : reservation.getCatalogs()) {
                total += products.getAvailableTickets();
            }
            TicketBooking orders = new TicketBooking();
            orders.setBookDate(LocalDate.now());
            orders.setAmount(total);
            orders.setUsers(users);
            return ticketBookingRepository.save(orders);
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while creating Ticket");
        }
    }
}

