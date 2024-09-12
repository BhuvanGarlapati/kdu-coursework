package com.example.jdbc.dao;

import com.example.jdbc.dto.ShiftUserDTO;
import com.example.jdbc.mapper.ShiftUserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class ShiftUserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void save(ShiftUserDTO shiftUser) {
        String sql = "INSERT INTO shift_users (id, shift_id, user_id, tenant_id) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                shiftUser.getId(),
                shiftUser.getShiftId(),
                shiftUser.getUserId(),
                shiftUser.getTenantId());
    }

    public ShiftUserDTO getById(UUID shiftUserId) {
        String sql = "SELECT * FROM shift_users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{shiftUserId}, new ShiftUserRowMapper());
    }

    public List<ShiftUserDTO> getAllByTenant(UUID tenantId) {
        String sql = "SELECT * FROM shift_users WHERE tenant_id = ?";
        return jdbcTemplate.query(sql, new Object[]{tenantId}, new ShiftUserRowMapper());
    }

    @Transactional
    public void update(UUID id,ShiftUserDTO shiftUser) {
        String sql = "UPDATE shift_users SET shift_id = ?, user_id = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql,
                shiftUser.getShiftId(),
                shiftUser.getUserId(),
                shiftUser.getId());
    }

    @Transactional
    public void delete(UUID shiftUserId) {
        String sql = "DELETE FROM shift_users WHERE id = ?";
        jdbcTemplate.update(sql, shiftUserId);
    }
}
