package com.kdu.smartHome.service;

import com.kdu.smartHome.dao.DeviceRepository;
import com.kdu.smartHome.dao.RoomRepository;
import com.kdu.smartHome.entity.DeviceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private RoomRepository roomRepository;

    public List<DeviceEntity> getInventory() {
        return deviceRepository.findAll();
    }



}