package com.example.jdbc.mapper;

import com.example.jdbc.dto.UserDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserRowMapper implements RowMapper<UserDTO> {

    @Override
    public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDTO user = new UserDTO();
        user.setId(UUID.fromString(rs.getString("id")));
        user.setUsername(rs.getString("username"));
        user.setLoggedIn(rs.getInt("loggedin"));
        user.setTimeZone(rs.getString("time_zone"));
        user.setTenantId(UUID.fromString(rs.getString("tenant_id")));
        return user;
    }
}
