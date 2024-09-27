package com.example.assesment2.service;

import com.example.assesment2.dto.UserDto;
import com.example.assesment2.entity.Users;
import com.example.assesment2.exception.ErrorWhileExecutingQuery;
import com.example.assesment2.mapper.Mapper;
import com.example.assesment2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDto addUser(Users users){
        try {
            return Mapper.convertToUserDto(userRepository.save(users));
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while adding user");
        }
    }
}
