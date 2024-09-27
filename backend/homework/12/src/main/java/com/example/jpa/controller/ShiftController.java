package com.example.jpa.controller;

import com.example.jpa.dto.Shift;
import com.example.jpa.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.util.List;


@RestController
@RequestMapping("/api/shifts")
public class ShiftController {

    @Autowired
    private ShiftService shiftService;

    // Endpoint to save a shift
    @PostMapping
    public ResponseEntity<Shift> saveShift(@RequestBody Shift shiftDto) {
        Shift savedShiftDto = shiftService.saveShift(shiftDto);
        return new ResponseEntity<>(savedShiftDto, HttpStatus.CREATED);
    }

    // Endpoint to get all shifts
    @GetMapping
    public ResponseEntity<List<Shift>> getAllShifts() {
        List<Shift> shifts = shiftService.getAllShifts();
        return new ResponseEntity<>(shifts, HttpStatus.OK);
    }


    @GetMapping("/top3")
    public ResponseEntity<List<Shift>> findTop3ShiftsByDateRange(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate) {
        List<Shift> top3Shifts = shiftService.findTop3ShiftsByDateRange(startDate, endDate);
        return new ResponseEntity<>(top3Shifts, HttpStatus.OK);
    }

}
