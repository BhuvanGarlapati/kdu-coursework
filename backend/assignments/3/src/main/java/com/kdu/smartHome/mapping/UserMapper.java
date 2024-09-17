package com.kdu.smartHome.mapping;

import com.kdu.smartHome.dto.UserDto;
import com.kdu.smartHome.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    PasswordEncoder passwordEncoder;
    public UserEntity userMapping(UserDto userRequestDTO) {
        UserEntity userModel = new UserEntity();
        userModel.setUsername(userRequestDTO.getUsername());
        userModel.setFirstName(userRequestDTO.getFirstName());
        userModel.setLastName(userRequestDTO.getLastName());
        userModel.setEmail(userRequestDTO.getEmail());
        userModel.setName(userRequestDTO.getName());
        userModel.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));

        return userModel;
    }
}