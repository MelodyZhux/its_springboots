package com.bezkoder.spring.jdbc.oracle.repository;

import java.util.List;
import com.bezkoder.spring.jdbc.oracle.model.Issue;

public interface ReportRepository {
    Issue findIssueById(Long id);
    List<Issue> findIssueByAssignTo();

    int update(Issue book);
}
