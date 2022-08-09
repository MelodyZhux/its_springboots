package com.bezkoder.spring.jdbc.oracle.repository;

import java.util.List;

import com.bezkoder.spring.jdbc.oracle.model.Issue;
import com.bezkoder.spring.jdbc.oracle.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcReportRepository implements ReportRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int update(Issue issue) {

        System.out.println("issue update ");

        String q = "UPDATE issue SET assigned_to= ?,"+
                "related_project=?, status=?, priority=?,"+
                "modified_on= SYSDATE , modified_by=?  WHERE issue_id=?";
        System.out.println(q);
        System.out.println("id====="+issue.toString());
        return jdbcTemplate.update(q,
                new Object[] {
                        issue.getAssignedTo(),
                        issue.getRelatedProject(),
                        issue.getStatus(),
                        issue.getPriority(),
                        issue.getModifiedBy(),
                        issue.getIssueId()
                });
    }
    @Override
    public List<Issue> findIssueByAssignTo() {

        String q = "SELECT * from issue where assigned_to IS NULL";
        System.out.println(q);
        List<Issue> list = jdbcTemplate.query(q, new IssueRowMapper());
        for (Issue p : list) {
            System.out.println("listP ID:" + p.getIssueId() +"  list name: "+p.getIssueSummary());
        }
        return list;
    }

    @Override
    public Issue findIssueById(Long id) {

        String q = "SELECT * from issue where issue_id =?";
        System.out.println(q);
        Issue issue = jdbcTemplate.queryForObject(q,new IssueRowMapper(), id);
        System.out.println("find Issue by ID repository ===========");
        System.out.println(issue.getIssueId());

        return issue;
    }


}
