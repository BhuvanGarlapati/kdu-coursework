package com.kdu.smartHome.controller;

import com.kdu.smartHome.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {
    private final DeviceService deviceService;

    /**
     * Constructor for DeviceController.
     *
     * @param deviceService The service responsible for device operations.
     */
    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }



}