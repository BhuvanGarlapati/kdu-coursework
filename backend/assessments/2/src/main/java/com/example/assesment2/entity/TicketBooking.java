package com.example.assesment2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TicketBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private int amount;
    private LocalDate bookDate;
    private int numberTickets;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="catalog_id")
    private Catalog catalog;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="user_id")
    private Users users;
}
