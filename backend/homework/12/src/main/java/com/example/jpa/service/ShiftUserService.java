package com.example.jpa.service;

import com.example.jpa.dto.ShiftUser;
import com.example.jpa.repository.ShiftUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShiftUserService {

    @Autowired
    private ShiftUserRepository shiftUserRepository;

    public ShiftUser saveShiftUser(ShiftUser shiftUser) {
        // Additional logic before saving if needed
        return shiftUserRepository.save(shiftUser);
    }

    public List<ShiftUser> getAllShiftUsers() {
        return shiftUserRepository.findAll();
    }

    public ShiftUser getShiftUserById(UUID shiftUserId) {
        Optional<ShiftUser> optionalShiftUser = shiftUserRepository.findById(shiftUserId);
        return optionalShiftUser.orElse(null);
    }

    public List<ShiftUser> getShiftUsersByShiftEndTime(LocalTime timeEnd) {
        return shiftUserRepository.findByShift_TimeEnd(timeEnd);
    }

    public boolean deleteShiftUser(UUID shiftUserId) {
        Optional<ShiftUser> optionalShiftUser = shiftUserRepository.findById(shiftUserId);

        if (optionalShiftUser.isPresent()) {
            shiftUserRepository.deleteById(shiftUserId);
            return true;
        } else {
            return false;
        }
    }
}
