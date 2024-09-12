package com.example.jdbc.dao;

import com.example.jdbc.dto.UserDTO;
import com.example.jdbc.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void save(UserDTO user) {
        String sql = "INSERT INTO users (id, username, loggedin, time_zone, tenant_id) " +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                user.getId(),
                user.getUsername(),
                user.getLoggedIn(),
                user.getTimeZone(),
                user.getTenantId());
    }

    public UserDTO getById(UUID userId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new UserRowMapper());
    }

    public List<UserDTO> getAllByTenant(UUID tenantId) {
        String sql = "SELECT * FROM users WHERE tenant_id = ?";
        return jdbcTemplate.query(sql, new Object[]{tenantId}, new UserRowMapper());
    }

    @Transactional
    public void update(UUID userId,UserDTO user) {
        String sql = "UPDATE users SET username = ?, loggedin = ?, time_zone = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql,
                user.getUsername(),
                user.getLoggedIn(),
                user.getTimeZone(),
                user.getId());
    }

    @Transactional
    public void delete(UUID userId) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, userId);
    }
}
