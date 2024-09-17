package com.kdu.smartHome.service;

import com.kdu.smartHome.dao.HouseRepository;
import com.kdu.smartHome.dao.UserRepository;
import com.kdu.smartHome.entity.HouseEntity;
import com.kdu.smartHome.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {
    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private UserRepository userRepository;

    public HouseEntity addHouse(HouseEntity house) {
        return houseRepository.save(house);
    }

    public HouseEntity addUserToHouse(String houseId, String username) {
        HouseEntity house = houseRepository.findById(Long.parseLong(houseId)).orElse(null);
        UserEntity user = userRepository.findByUsername(username);

        return house;
    }
    public List<HouseEntity> getHouses() {
        return houseRepository.findAll();
    }

    public HouseEntity updateHouseAddress(String houseId, String newAddress) {
        HouseEntity house = houseRepository.findById(Long.parseLong(houseId)).orElse(null);
        if (house != null) {
            house.setAddress(newAddress);
            houseRepository.save(house);
        }
        return house;
    }

    public HouseEntity getHouseById(String houseId) {
        return houseRepository.findById(Long.parseLong(houseId)).orElse(null);
    }

    public List<HouseEntity> getAll() {
        return houseRepository.findAll();
    }
}
