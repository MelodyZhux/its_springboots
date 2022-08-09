package com.bezkoder.spring.jdbc.oracle.service;
import com.bezkoder.spring.jdbc.oracle.model.Issue;
import com.bezkoder.spring.jdbc.oracle.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;

    public String updateIssue(Issue issue) {
        try {
            System.out.println("issue service update mapping");
            System.out.println("Issue id::" + issue.getIssueId());
            reportRepository.update(issue);
            return ("issue was updated successfully.");
        } catch (Exception e) {
            return "can not update issue";
        }
    }
    public List<Issue> findIssueByAssignTo() {
        List<Issue> list = null;
        try {
            System.out.println("issue service find all mapping");
            list = reportRepository.findIssueByAssignTo();
        } catch (Exception e) {
            System.out.println("error");

        }
        return list;
    }
    public Issue findIssueById(Long id) {
        Issue issue = null;
        try {
            System.out.println("issue service findissueById mapping" + id);
            issue = reportRepository.findIssueById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");

        }
        return issue;
    }

}


