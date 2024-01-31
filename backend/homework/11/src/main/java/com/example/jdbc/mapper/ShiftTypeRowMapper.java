package com.example.jdbc.mapper;

import com.example.jdbc.constant.ShiftType;
import com.example.jdbc.dto.ShiftTypeDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;



public class ShiftTypeRowMapper implements RowMapper<ShiftTypeDTO> {

    @Override
    public ShiftTypeDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        ShiftTypeDTO shiftTypeDTO = new ShiftTypeDTO();
        shiftTypeDTO.setId((UUID) resultSet.getObject("id"));
        shiftTypeDTO.setUqName(resultSet.getString("uq_name"));
        shiftTypeDTO.setDescription(resultSet.getString("description"));
        shiftTypeDTO.setActive(resultSet.getBoolean("active"));
        shiftTypeDTO.setCreatedAt(resultSet.getTimestamp("created_at").toInstant());
        shiftTypeDTO.setUpdatedAt(resultSet.getTimestamp("updated_at").toInstant());
        shiftTypeDTO.setTimeZone(resultSet.getString("time_zone"));
        shiftTypeDTO.setTenantId((UUID) resultSet.getObject("tenant_id"));
        return shiftTypeDTO;
    }
    private ShiftType getShiftType(String type){
        if(type.equals("Morning"))
        {
            return ShiftType.Morning;
        }else return (type.equals("Afternoon") ? ShiftType.Afternoon : ShiftType.Evening);
    }
}

