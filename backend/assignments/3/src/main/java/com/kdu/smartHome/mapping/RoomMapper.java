package com.kdu.smartHome.mapping;

import com.kdu.smartHome.entity.HouseEntity;
import com.kdu.smartHome.entity.RoomEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RoomMapper {
    public RoomEntity roomMapping(String roomName, HouseEntity house){
        RoomEntity room = new RoomEntity();
        room.setRoomName(roomName);
        room.setHouse(house);
        return room;
    }
}