package com.kdu.smartHome.service;

import com.kdu.smartHome.dao.UserRepository;
import com.kdu.smartHome.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DefaultUsers implements CommandLineRunner {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    @Autowired
    public DefaultUsers(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args)  {
        UserEntity admin = new UserEntity();
        admin.setUsername("ankush");
        admin.setPassword(passwordEncoder.encode("ankush"));
        admin.setEmail("ankush@gmail.com");
        admin.setFirstName("bhuvan");
        admin.setName("bhuvan");
        admin.setLastName("Garla");
        admin.setRole("ROLE_ADMIN");
        userRepository.save(admin);

        UserEntity normal = new UserEntity();
        normal.setUsername("customer");
        normal.setPassword("customer@gmail.com");
        normal.setRole("ROLE_BASIC");
        normal.setFirstName("bhuvan");
        normal.setLastName("Garla");
        normal.setPassword(passwordEncoder.encode("password"));
        userRepository.save(normal);
    }
}
