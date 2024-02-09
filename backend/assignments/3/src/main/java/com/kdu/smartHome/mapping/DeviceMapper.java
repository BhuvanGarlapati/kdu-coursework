package com.kdu.smartHome.mapping;

import com.kdu.smartHome.dto.DeviceRequestDto;
import com.kdu.smartHome.entity.DeviceEntity;
import org.springframework.stereotype.Component;

@Component
public class DeviceMapper {
    public DeviceEntity deviceMapping(DeviceRequestDto deviceRequestDTO){
        DeviceEntity device = new DeviceEntity();
        device.setDeviceUsername(deviceRequestDTO.getDeviceUsername());
        device.setDevicePassword(deviceRequestDTO.getDevicePassword());
        device.setKickstonId(deviceRequestDTO.getKickstonId());
        return device;
    }

    }