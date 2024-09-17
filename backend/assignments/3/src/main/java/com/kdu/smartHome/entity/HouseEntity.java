package com.kdu.smartHome.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import java.util.ArrayList;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String houseName;
    private double latitude;
    private double longitude;
    @ManyToMany(mappedBy = "houses",cascade = CascadeType.ALL)
    private List<UserEntity> usersList = new ArrayList<>();
    @OneToMany(mappedBy = "house")
    @JsonManagedReference
    private List<RoomEntity> rooms = new ArrayList<>();
}