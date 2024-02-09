package com.kdu.smartHome.dto;

import com.kdu.smartHome.entity.RoomEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDeviceDto
{
    private String message;
    private RoomEntity room;
    private HttpStatus httpStatus;
}