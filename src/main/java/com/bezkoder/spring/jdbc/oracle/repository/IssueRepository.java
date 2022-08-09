package com.bezkoder.spring.jdbc.oracle.repository;

import java.util.List;
import com.bezkoder.spring.jdbc.oracle.model.Issue;

public interface IssueRepository {
    int save(Issue book);
    List<Issue> findAll();
    List<Issue> findIssueByAssignTo();
    //List<Issue> findIssueByPersonName(String personName);
    Issue findIssueById(Long id);
    List<Issue> findIssueByCreatedBy(String personName);

    List<Issue> findIssueByRelatedProject(long projectId );

    int update(Issue book);

    int deleteById(Long id);



}
