package com.example.jdbc.dao;

import com.example.jdbc.dto.ShiftDTO;
import com.example.jdbc.mapper.ShiftRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Repository
public class ShiftDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void save(ShiftDTO shift) {
        String sql = "INSERT INTO shifts (id, shift_type_id, name, date_start, date_end, " +
                "time_start, time_end, created_at, updated_at, time_zone, tenant_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                shift.getId(),
                shift.getShiftTypeId(),
                shift.getName(),
                shift.getDateStart(),
                shift.getDateEnd(),
                shift.getTimeStart(),
                shift.getTimeEnd(),
                Timestamp.from(Instant.now()), // created_at
                Timestamp.from(Instant.now()), // updated_at
                shift.getTimeZone(),
                shift.getTenantId()
        );
    }

    public ShiftDTO getById(UUID shiftId) {
        String sql = "SELECT * FROM shifts WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{shiftId}, new ShiftRowMapper());
    }

    public List<ShiftDTO> getAllByTenant(UUID tenantId) {
        String sql = "SELECT * FROM shifts WHERE tenant_id = ?";
        return jdbcTemplate.query(sql, new Object[]{tenantId}, new ShiftRowMapper());
    }

    @Transactional
    public void update(UUID id,ShiftDTO shift) {
        String sql = "UPDATE shifts SET shift_type_id = ?, name = ?, date_start = ?, " +
                "date_end = ?, time_start = ?, time_end = ?, time_zone = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql,
                shift.getShiftTypeId(),
                shift.getName(),
                shift.getDateStart(),
                shift.getDateEnd(),
                shift.getTimeStart(),
                shift.getTimeEnd(),
                shift.getTimeZone(),
                shift.getId());
    }

    @Transactional
    public void delete(UUID shiftId) {
        String sql = "DELETE FROM shifts WHERE id = ?";
        jdbcTemplate.update(sql, shiftId);
    }
}
