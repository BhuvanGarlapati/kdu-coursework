package com.kdu.smartHome.service;

import com.kdu.smartHome.dao.HouseRepository;
import com.kdu.smartHome.dao.RoomRepository;
import com.kdu.smartHome.dto.RoomDeviceDto;
import com.kdu.smartHome.entity.HouseEntity;
import com.kdu.smartHome.entity.RoomEntity;
import com.kdu.smartHome.mapping.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final HouseRepository houseRepository;
    private final RoomMapper mapper;

    @Autowired
    public RoomService(RoomRepository roomRepository, HouseRepository houseRepository, RoomMapper mapper) {
        this.roomRepository = roomRepository;
        this.houseRepository = houseRepository;
        this.mapper = mapper;
    }

    /**
     * Adds a room to a particular house using the house ID.
     *
     * @param id       The ID of the house.
     * @param roomName The name of the room to be added.
     * @return The response containing information about the added room.
     */
    public RoomDeviceDto addRoom(Long id, String roomName) {
        Optional<HouseEntity> optionalHouse = houseRepository.findById(id);
            HouseEntity house = optionalHouse.get();
            RoomEntity room = mapper.roomMapping(roomName, house);
            roomRepository.save(room);
            return new RoomDeviceDto("Room added successfully!", room, HttpStatus.OK);
    }
}
