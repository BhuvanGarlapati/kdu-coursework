package com.example.assesment2.service;


import com.example.assesment2.entity.Users;
import com.example.assesment2.repository.UserRepository;
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
        Users admin = new Users();
        admin.setUsername("bhuvan");
        admin.setPassword(passwordEncoder.encode("password"));
        admin.setEmail("bbhuvan@gmail.com");
        admin.setRole("ROLE_ADMIN");
        userRepository.save(admin);

        Users normal = new Users();
        normal.setUsername("customer");
        normal.setEmail("customer@gmail.com");
        normal.setRole("ROLE_BASIC");
        normal.setPassword(passwordEncoder.encode("password"));
        userRepository.save(normal);
    }
}
