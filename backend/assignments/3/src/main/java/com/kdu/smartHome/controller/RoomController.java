package com.kdu.smartHome.controller;

import com.kdu.smartHome.dto.RoomDeviceDto;
import com.kdu.smartHome.dto.RoomDto;
import com.kdu.smartHome.entity.RoomEntity;
import com.kdu.smartHome.service.RoomService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/room")
    public ResponseEntity<RoomDeviceDto> addRoom(@RequestParam String houseId, @RequestBody RoomDto roomDTO, HttpServletRequest request) {


        return new ResponseEntity<>(roomService.addRoom(Long.parseLong(houseId), roomDTO.getRoomName()), HttpStatus.OK);
    }
}