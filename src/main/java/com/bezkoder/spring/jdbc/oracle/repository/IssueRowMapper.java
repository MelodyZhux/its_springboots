package com.bezkoder.spring.jdbc.oracle.repository;

import org.springframework.jdbc.core.RowMapper;
import com.bezkoder.spring.jdbc.oracle.model.Issue;

import java.sql.ResultSet;
import java.sql.SQLException;


public class IssueRowMapper implements RowMapper<Issue> {

    @Override
    public Issue mapRow(ResultSet rs, int rowNum) throws SQLException {

        Issue issue = new Issue();
        issue.setIssueId(rs.getLong("issue_id"));
        issue.setIssueSummary(rs.getString("issue_summary"));
        issue.setIssueDescription(rs.getString("issue_description"));
        issue.setIdentifiedByPersonId(rs.getLong("identified_by_person_id"));
        issue.setIdentifiedDate(rs.getDate("identified_date"));
        issue.setRelatedProject(rs.getLong("related_project"));
        issue.setAssignedTo(rs.getLong("assigned_to"));
        issue.setStatus(rs.getString("status"));
        issue.setPriority(rs.getString("priority"));
        issue.setTargetResolutionDate(rs.getDate("target_resolution_date"));
        issue.setProgress(rs.getString("progress"));
        issue.setActualResolutionDate(rs.getDate("actual_resolution_date"));
        issue.setResolutionSummary(rs.getString("resolution_summary"));
        issue.setCreatedOn(rs.getDate("created_on"));
        issue.setCreatedBy(rs.getString("created_by"));
        issue.setModifiedOn(rs.getDate("modified_on"));
        issue.setModifiedBy(rs.getString("modified_by"));

        return issue;

    }

}
