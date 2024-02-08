package com.example.assesment2.controller;

import com.example.assesment2.dto.CatalogDto;
import com.example.assesment2.dto.UserDto;
import com.example.assesment2.entity.Catalog;
import com.example.assesment2.entity.Reservation;
import com.example.assesment2.entity.TicketBooking;
import com.example.assesment2.entity.Users;
import com.example.assesment2.service.CatalogService;
import com.example.assesment2.service.ReservationService;
import com.example.assesment2.service.TicketBookingService;
import com.example.assesment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class BookingController {

    @Autowired
    private UserService userService;
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private TicketBookingService ticketBookingService;


    @PostMapping("app/users")
    public UserDto addUser(@RequestBody Users users) {
        return userService.addUser(users);
    }
    @PostMapping("app/catalog")
    public CatalogDto addProduct(@RequestBody Catalog catalog){
        return catalogService.addProduct(catalog);
    }

    @DeleteMapping("app/{Id}")
    public ResponseEntity<Void> deleteCatalog(@PathVariable Integer Id) {
        boolean deleted = catalogService.deleteCatalog(Id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("app/event")
    public ResponseEntity<?> updateCatalog(@RequestParam Integer Id, @RequestBody CatalogDto catalogDto) {
        Catalog updatedCatalog = catalogService.updateCatalog(Id, catalogDto.getName());
        return ResponseEntity.ok().body("House address updated successfully");
    }

    @PostMapping("app/reservation")
    public Reservation addCart(@RequestBody Reservation reservation){
        return reservationService.addReservation(reservation);
    }


    @DeleteMapping("app/reservation/{Id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Integer Id) {
        boolean deleted = reservationService.deleteReservation(Id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("app/get")
    public TicketBooking getTickets(@RequestParam int Id){
        return ticketBookingService.getTickets(Id);
    }
}


