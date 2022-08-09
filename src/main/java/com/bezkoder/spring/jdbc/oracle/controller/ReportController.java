package com.bezkoder.spring.jdbc.oracle.controller;
import com.bezkoder.spring.jdbc.oracle.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.bezkoder.spring.jdbc.oracle.model.Issue;
import com.bezkoder.spring.jdbc.oracle.service.ReportService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ReportController {

//    @Autowired
//    ReportRepository ReportRepository;

    @Autowired
    ReportService reportService;


    @PutMapping("/report/{id}")
    public ResponseEntity<String> updateReport(@PathVariable("id") long id, @RequestBody Issue issue) {
        System.out.println("report putMapping" + id);

        String result = reportService.updateIssue(issue);
        System.out.println(result);
        if (StringUtils.hasText(result)) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reports")
    public ResponseEntity<List<Issue>> getAllReportsByAssignedTo() {
        try {
            System.out.println("get all Report mapping");
            List<Issue> reports = reportService.findIssueByAssignTo();
            return new ResponseEntity<>(reports, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/report/{id}")
    public ResponseEntity <Issue> getReportById(@PathVariable("id") Long id) {
        try {

            System.out.println("getReport By Id id == "+ id);
            Issue report = reportService.findIssueById(id);
            if (report != null) {
                System.out.println("find Report by ID===========");
                return new ResponseEntity<>(report, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
