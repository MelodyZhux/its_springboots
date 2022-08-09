package com.bezkoder.spring.jdbc.oracle.repository;

import org.springframework.jdbc.core.RowMapper;
import com.bezkoder.spring.jdbc.oracle.model.Project;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProjectRowMapper implements RowMapper<Project> {

    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {

        Project project = new Project();
        project.setProjectId(rs.getLong("project_id"));
        project.setProjectName(rs.getString("project_name"));
        project.setStartDate(rs.getDate("start_date"));
        project.setTargetEndDate(rs.getDate("target_end_date"));
        project.setActualEndDate(rs.getDate("actual_end_date"));
        project.setCreatedOn(rs.getDate("created_on"));
        project.setCreatedBy(rs.getString("created_by"));
        project.setModifiedOn(rs.getDate("modified_on"));
        project.setModifiedBy(rs.getString("modified_by"));

        return project;

    }

}