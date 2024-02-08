package com.example.assesment2.repository;

import com.example.assesment2.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    @Query
    public Users findByUsername(String username);

}
