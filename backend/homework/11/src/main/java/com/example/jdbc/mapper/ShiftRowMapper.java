package com.example.jdbc.mapper;

import com.example.jdbc.dto.ShiftDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ShiftRowMapper implements RowMapper<ShiftDTO> {

    @Override
    public ShiftDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        ShiftDTO shift = new ShiftDTO();
        shift.setId(resultSet.getString("id"));
        shift.setShiftTypeId(resultSet.getString("shift_type_id"));
        shift.setName(resultSet.getString("name"));
        shift.setDateStart(resultSet.getString("date_start"));
        shift.setDateEnd(resultSet.getString("date_end"));
        shift.setTimeStart(resultSet.getString("time_start"));
        shift.setTimeEnd(resultSet.getString("time_end"));
        shift.setCreatedAt(resultSet.getTimestamp("created_at").toInstant());
        shift.setUpdatedAt(resultSet.getTimestamp("updated_at").toInstant());
        shift.setTimeZone(resultSet.getString("time_zone"));
        shift.setTenantId(resultSet.getString("tenant_id"));
        return shift;
    }
}
