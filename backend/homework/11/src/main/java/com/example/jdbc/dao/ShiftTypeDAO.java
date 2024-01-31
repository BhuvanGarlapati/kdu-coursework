package com.example.jdbc.dao;

import com.example.jdbc.dto.ShiftTypeDTO;
import com.example.jdbc.mapper.ShiftTypeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Repository
public class ShiftTypeDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void save(ShiftTypeDTO shiftType) {
        String sql = "INSERT INTO shift_types (id, uq_name, description, active, created_at, updated_at, time_zone, tenant_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, shiftType.getId());
            preparedStatement.setString(2, shiftType.getUqName());
            preparedStatement.setString(3, shiftType.getDescription());
            preparedStatement.setBoolean(4, shiftType.isActive());
            preparedStatement.setTimestamp(5, Timestamp.from(shiftType.getCreatedAt()));
            preparedStatement.setTimestamp(6, Timestamp.from(shiftType.getUpdatedAt()));
            preparedStatement.setString(7, shiftType.getTimeZone());
            preparedStatement.setObject(8, shiftType.getTenantId());
            return preparedStatement;
        });
    }

    public ShiftTypeDTO getById(UUID shiftTypeId) {
        String sql = "SELECT * FROM shift_types WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{shiftTypeId}, new ShiftTypeRowMapper());
    }

    public List<ShiftTypeDTO> getAllByTenant(UUID tenantId) {
        String sql = "SELECT * FROM shift_types WHERE tenant_id = ?";
        return jdbcTemplate.query(sql, new Object[]{tenantId}, new ShiftTypeRowMapper());
    }

    @Transactional
    public void update(UUID id,ShiftTypeDTO shiftType) {
        String sql = "UPDATE shift_types SET uq_name = ?, description = ?, active = ?, time_zone = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql,
                shiftType.getUqName(),
                shiftType.getDescription(),
                shiftType.isActive(),
                shiftType.getTimeZone(),
                shiftType.getId());
    }

    @Transactional
    public void delete(UUID shiftTypeId) {
        String sql = "DELETE FROM shift_types WHERE id = ?";
        jdbcTemplate.update(sql, shiftTypeId);
    }
}