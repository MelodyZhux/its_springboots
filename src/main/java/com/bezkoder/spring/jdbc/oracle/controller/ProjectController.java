package com.bezkoder.spring.jdbc.oracle.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.bezkoder.spring.jdbc.oracle.model.Project;
import com.bezkoder.spring.jdbc.oracle.service.ProjectService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/project/add")
    public ResponseEntity<String> createProject(@RequestBody Project project) {

        System.out.println("project edit date mapping");
        System.out.println(project.getProjectName());
        System.out.println(project.getStartDate());
        System.out.println(project.getTargetEndDate());
        System.out.println(project.getCreatedBy());

        String result = projectService.createProject(project);

        System.out.println("add result = "+result);
        if (StringUtils.hasText(result)) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/project/{id}")
    public ResponseEntity<String> updateProject(@PathVariable("id") long id, @RequestBody Project project) {
        System.out.println("putMapping" + id);
        System.out.println("putMapping" + project.getStartDate());
        String result = projectService.updateProject(project);
        System.out.println(result);
        if (StringUtils.hasText(result)) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/project/{id}")
    public ResponseEntity<String> deleteProjectById(@PathVariable("id") long id) {
            System.out.println("Delete mapping " + id);
            String result = projectService.deleteById(id);
            if (StringUtils.hasText(result)) {
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }

    @GetMapping("/project")
    public ResponseEntity<List<Project>> getProjectsByName(@RequestParam(required = false) String name) {
        try {
            System.out.println("get Project mapping");
            List<Project> projects = projectService.findProjectsByName(name);
            return new ResponseEntity<>(projects, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects() {
        try {
            System.out.println("get all Project mapping");
            List<Project> projects = projectService.findAll();
            return new ResponseEntity<>(projects, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/project/{id}")
    public ResponseEntity <Project> getProjectById(@PathVariable("id") Long id) {
        try {

            System.out.println("getProject By Id id == "+ id);
            Project project = projectService.findProjectById(id);
            if (project != null) {
                System.out.println("find project by ID===========");
                System.out.println(project.getStartDate());
                return new ResponseEntity<>(project, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
