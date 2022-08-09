package com.bezkoder.spring.jdbc.oracle.repository;

import java.util.List;

import com.bezkoder.spring.jdbc.oracle.model.Issue;
import com.bezkoder.spring.jdbc.oracle.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcIssueRepository implements IssueRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Issue issue) {

        System.out.println("issue save ");

        String q ="INSERT INTO issue(issue_id,issue_summary,issue_description,identified_by_person_id,identified_date,related_project,priority,target_resolution_date,created_on,created_by)  VALUES(issue_id_seq.nextval,?,?,?,?,?,?,?,sysdate,?)";

        System.out.println(issue.toString());
        System.out.println(q);


        return jdbcTemplate.update(q,
                new Object[] { issue.getIssueSummary(),issue.getIssueDescription(),issue.getIdentifiedByPersonId(),issue.getIdentifiedDate(), issue.getRelatedProject(),issue.getPriority(),
                issue.getTargetResolutionDate(),issue.getCreatedBy() });

    }

    @Override
    public int update(Issue issue) {

        System.out.println("issue update ");

        String q = "UPDATE issue SET issue_summary= ?, issue_description=?,"+
                "identified_by_person_id=?,identified_date=?, related_project=?,"+
                "priority=?,target_resolution_date=?,"+
                "modified_on= SYSDATE , modified_by=?  WHERE issue_id=?";
        System.out.println(q);
        System.out.println("id====="+issue.toString());
        return jdbcTemplate.update(q,
                new Object[] {
                        issue.getIssueSummary(),issue.getIssueDescription(),
                        issue.getIdentifiedByPersonId(),issue.getIdentifiedDate(),
                        issue.getRelatedProject(),
                        issue.getPriority(), issue.getTargetResolutionDate(),
                        issue.getModifiedBy(),issue.getIssueId()
                    });
    }
    @Override
    public int deleteById(Long id) {
        String q = "DELETE FROM issue WHERE issue_id=?";

        System.out.println(q);
        return jdbcTemplate.update(q, id);
    }
    @Override
    public List<Issue> findAll() {

        String q = "SELECT * from issue";
        System.out.println(q);
        List<Issue> list = jdbcTemplate.query(q, new IssueRowMapper());
        for (Issue p : list) {
            System.out.println("listP ID:" + p.getIssueId() +"  list name: "+p.getIssueSummary());
        }
        return list;
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
    public List<Issue> findIssueByCreatedBy(String personName) {

        System.out.println("person name ==="+ personName);

        String q = "SELECT * from issue where created_by LIKE '%" + personName + "%' collate binary_ci";

        System.out.println(q);
        List<Issue> list  = jdbcTemplate.query(q, new IssueRowMapper());

        return list;
    }


    @Override
    public List<Issue> findIssueByRelatedProject(long projectId) {

        String q = "SELECT * from issue where related_project=?";


        System.out.println(q);
        System.out.println("projectId===="+projectId);
        List<Issue> list = jdbcTemplate.query(q, new IssueRowMapper(),projectId );
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
