package com.example.jpa.service;

import com.example.jpa.dto.Shift;
import com.example.jpa.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShiftService {

    @Autowired
    private ShiftRepository shiftRepository;

    public Shift saveShift(Shift shift) {
        // Additional logic before saving if needed
        return shiftRepository.save(shift);
    }

    public List<Shift> getAllShifts() {
        return (List<Shift>) shiftRepository.findAll();
    }

    public Shift getShiftById(UUID shiftId) {
        Optional<Shift> optionalShift = shiftRepository.findById(shiftId);
        return optionalShift.orElse(null);
    }



    public boolean deleteShift(UUID shiftId) {
        Optional<Shift> optionalShift = shiftRepository.findById(shiftId);

        if (optionalShift.isPresent()) {
            shiftRepository.deleteById(shiftId);
            return true;
        } else {
            return false;
        }
    }
    public List<Shift> findTop3ShiftsByDateRange(LocalDate startDate, LocalDate endDate) {
        Pageable pageable = PageRequest.of(0, 3); // Retrieve top 3
        return shiftRepository.findTop3ShiftsByDateRange(startDate, endDate, pageable);
    }
}
