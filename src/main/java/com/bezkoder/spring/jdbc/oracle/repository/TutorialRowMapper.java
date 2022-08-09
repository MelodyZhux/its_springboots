package com.bezkoder.spring.jdbc.oracle.repository;

import org.springframework.jdbc.core.RowMapper;
import com.bezkoder.spring.jdbc.oracle.model.Tutorial;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TutorialRowMapper implements RowMapper<Tutorial> {

    @Override
    public Tutorial mapRow(ResultSet rs, int rowNum) throws SQLException {

        Tutorial Tutorial = new Tutorial();
        Tutorial.setId(rs.getLong("id"));
        Tutorial.setTitle(rs.getString("title"));
        Tutorial.setDescription(rs.getString("description"));
        Tutorial.setPublished(rs.getBoolean("published"));
        return Tutorial;

    }
}