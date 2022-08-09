package com.bezkoder.spring.jdbc.oracle.service;
import com.bezkoder.spring.jdbc.oracle.model.Issue;
import com.bezkoder.spring.jdbc.oracle.model.People;
import com.bezkoder.spring.jdbc.oracle.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IssueService {

    @Autowired
    IssueRepository issueRepository;

    public String createIssue(Issue issue) {
        try {
            System.out.println("issue service mapping");
            issueRepository.save(issue);
            return ("issue was created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return "fail to add issue";
        }
    }

    public String updateIssue(Issue issue) {
        try {
            System.out.println("issue service update mapping");
            System.out.println("Issue id::" + issue.getIssueId());
            issueRepository.update(issue);
            return ("issue was updated successfully.");
        } catch (Exception e) {
            return "can not update issue";
        }
    }

    public String deleteById(Long id) {
        try {
            System.out.println("issue service delete ");

            issueRepository.deleteById(id);
            return ("issue was deleted successfully.");
        } catch (Exception e) {
            return "";
        }
    }



    public List<Issue> findAll() {
        List<Issue> list = null;
        try {
            System.out.println("issue service find all mapping");
            list = issueRepository.findAll();
        } catch (Exception e) {
            System.out.println("error");

        }
        return list;
    }

    public List<Issue> findIssueByAssignTo() {
        List<Issue> list = null;
        try {
            System.out.println("issue service find all mapping");
            list = issueRepository.findIssueByAssignTo();
        } catch (Exception e) {
            System.out.println("error");

        }
        return list;
    }
    public Issue findIssueById(Long id) {
        Issue issue = null;
        try {
            System.out.println("issue service findissueById mapping" + id);
            issue = issueRepository.findIssueById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");

        }
        return issue;
    }


    public List<Issue> findIssueByCreatedBy(String personName) {
        List<Issue> list = null;
        try {
            System.out.println("people service findIssueByCreatedBy mapping" + personName);
            list = issueRepository.findIssueByCreatedBy(personName);
        } catch (Exception e) {
            System.out.println("error");

        }
        return list;
    }

    public List<Issue> findIssueByRelatedProject(long projectId) {
        List<Issue> list = null;
        try {
            System.out.println("people service findIssueByRelatedProject mapping" + projectId);
            list = issueRepository.findIssueByRelatedProject(projectId);
        } catch (Exception e) {
            System.out.println("error");

        }
        return list;
    }
}


