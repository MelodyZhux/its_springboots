package com.bezkoder.spring.jdbc.oracle.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.bezkoder.spring.jdbc.oracle.model.Issue;
import com.bezkoder.spring.jdbc.oracle.service.IssueService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class IssueController {

//    @Autowired
//    IssueRepository IssueRepository;

    @Autowired
    IssueService issueService;

    @PostMapping("/issue/add")
    public ResponseEntity<String> createIssue(@RequestBody Issue issue) {

        System.out.println("issue edit date mapping");

        String result = issueService.createIssue(issue);

        System.out.println("add result = "+result);
        if (StringUtils.hasText(result)) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/issue/{id}")
    public ResponseEntity<String> updateIssue(@PathVariable("id") long id, @RequestBody Issue issue) {
        System.out.println("issue putMapping" + id);

        String result = issueService.updateIssue(issue);
        System.out.println(result);
        if (StringUtils.hasText(result)) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/issue/{id}")
    public ResponseEntity<String> deleteIssueById(@PathVariable("id") long id) {
        System.out.println("deleteIssueById mapping " + id);
        String result = issueService.deleteById(id);
        if (StringUtils.hasText(result)) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/issues")
    public ResponseEntity<List<Issue>> getAllIssues() {
        try {
            System.out.println("get all Issue mapping");
            List<Issue> issues = issueService.findAll();
            return new ResponseEntity<>(issues, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/issue/{id}")
    public ResponseEntity <Issue> getIssueById(@PathVariable("id") Long id) {
        try {

            System.out.println("getIssue By Id id == "+ id);
            Issue issue = issueService.findIssueById(id);
            if (issue != null) {
                System.out.println("find Issue by ID===========");
                return new ResponseEntity<>(issue, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/issue")
    public ResponseEntity <List<Issue>> getIssueByParam(
            @RequestParam (required = false) String createdBy,
            @RequestParam (required = false) Long projectId,
            @RequestParam (required = false) Long assignedTo
    ) {
        try {
            System.out.println("get People By Id id == "+ createdBy);
            List<Issue> issue = null;
            if(createdBy !="" && createdBy!=null) {
                issue = issueService.findIssueByCreatedBy(createdBy);
                return new ResponseEntity<>(issue, HttpStatus.OK);
            } else if (projectId !=-1) {
                issue = issueService.findIssueByRelatedProject(projectId);
                return new ResponseEntity<>(issue, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(issue, HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
