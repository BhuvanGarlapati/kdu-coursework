package com.example.assesment2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reservationNo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="user_id")
    private Users users;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Catalog> catalogs;
}
