package com.bezkoder.spring.jdbc.oracle.repository;

import org.springframework.jdbc.core.RowMapper;
import com.bezkoder.spring.jdbc.oracle.model.People;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PeopleRowMapper implements RowMapper<People> {

    @Override
    public People mapRow(ResultSet rs, int rowNum) throws SQLException {

        People people = new People();

        people.setPersonId(rs.getLong("person_id"));
        people.setPersonName(rs.getString("person_name"));
        people.setPersonEmail(rs.getString("person_email"));
        people.setPersonRole(rs.getString("person_role"));
        people.setUserName(rs.getString("username"));
        people.setAssignedProject(rs.getInt("assigned_project"));
        people.setCreatedOn(rs.getDate("created_on"));
        people.setCreatedBy(rs.getString("created_by"));
        people.setModifiedOn(rs.getDate("modified_on"));
        people.setModifiedBy(rs.getString("modified_by"));

        return people;

    }

}