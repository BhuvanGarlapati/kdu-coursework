package com.kdu.smartHome.mapping;

import com.kdu.smartHome.dto.HouseDto;

import com.kdu.smartHome.entity.HouseEntity;
import com.kdu.smartHome.entity.UserEntity;
import org.springframework.stereotype.Component;


@Component
public class HouseMapper {
    public HouseEntity houseMapping(HouseDto houseRequestDTO, UserEntity userModel){
        HouseEntity house = new HouseEntity();
        house.setHouseName(houseRequestDTO.getHouseName());
        house.setAddress(houseRequestDTO.getAddress());
        house.getUsersList().add(userModel);
        return house;
    }
}