package com.example.jpa.service;

import com.example.jpa.dto.ShiftType;
import com.example.jpa.repository.ShiftTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ShiftTypeService {

    @Autowired
    private ShiftTypeRepository shiftTypeRepository;

    public ShiftType saveShiftType(ShiftType shiftType) {
        // Additional logic before saving if needed
        return shiftTypeRepository.save(shiftType);
    }

    public List<ShiftType> getAllShiftTypes() {
        return shiftTypeRepository.findAll();
    }

    public ShiftType getShiftTypeById(UUID shiftTypeId) {
        Optional<ShiftType> optionalShiftType = shiftTypeRepository.findById(shiftTypeId);
        return optionalShiftType.orElse(null);
    }


    public boolean deleteShiftType(UUID shiftTypeId) {
        Optional<ShiftType> optionalShiftType = shiftTypeRepository.findById(shiftTypeId);

        if (optionalShiftType.isPresent()) {
            shiftTypeRepository.deleteById(shiftTypeId);
            return true;
        } else {
            return false;
        }
    }
}
