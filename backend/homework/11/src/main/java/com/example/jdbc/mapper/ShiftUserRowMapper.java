package com.example.jdbc.mapper;

import com.example.jdbc.dto.ShiftUserDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ShiftUserRowMapper implements RowMapper<ShiftUserDTO> {

    @Override
    public ShiftUserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        ShiftUserDTO shiftUser = new ShiftUserDTO();
        shiftUser.setId(UUID.fromString(rs.getString("id")));
        shiftUser.setShiftId(UUID.fromString(rs.getString("shift_id")));
        shiftUser.setUserId(UUID.fromString(rs.getString("user_id")));
        shiftUser.setTenantId(UUID.fromString(rs.getString("tenant_id")));
        return shiftUser;
    }
}
