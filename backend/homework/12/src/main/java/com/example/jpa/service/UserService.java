package com.example.jpa.service;

import com.example.jpa.dto.Users;
import com.example.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users saveUser(Users users) {
        // Additional logic before saving if needed
        return userRepository.save(users);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserById(UUID userId) {
        Optional<Users> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }



    public boolean deleteUser(UUID userId) {
        Optional<Users> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            userRepository.deleteById(userId);
            return true;
        } else {
            return false;
        }
    }
    @Transactional
    public void updateUserDetails(UUID userId, String username, short loggedIn, String timeZone) {
        userRepository.updateUserDetails(userId, username, loggedIn, timeZone);
    }

    public Page<Users> findAllUsersPaginated(int pageNumber, int pageSize) {
        pageNumber = Math.max(0, pageNumber);
        pageSize = Math.min(50, Math.max(1, pageSize));

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAll(pageable);
    }
}
