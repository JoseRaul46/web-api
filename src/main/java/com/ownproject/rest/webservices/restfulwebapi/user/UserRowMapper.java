package com.ownproject.rest.webservices.restfulwebapi.user;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId((int) rs.getLong("ID"));
        user.setName(rs.getString("NAME_COL"));
        user.setBirthDate(rs.getDate("BIRTHDATE_COL").toLocalDate());

        return user;
    }
}
