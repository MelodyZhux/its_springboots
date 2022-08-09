package com.bezkoder.spring.jdbc.oracle.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.bezkoder.spring.jdbc.oracle.model.People;
import com.bezkoder.spring.jdbc.oracle.service.PeopleService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PeopleController {

//    @Autowired
//    PeopleRepository PeopleRepository;

    @Autowired
    PeopleService peopleService;

    @PostMapping("/people/add")
    public ResponseEntity<String> createPeople(@RequestBody People people) {

        System.out.println("people edit date mapping");
        System.out.println(people.getPersonName());
        System.out.println(people.getPersonEmail());
        System.out.println(people.getPersonRole());
        System.out.println(people.getUserName());
        System.out.println(people.getAssignedProject());
        String result = peopleService.createPeople(people);

        System.out.println("add result = "+result);
        if (StringUtils.hasText(result)) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/people/{id}")
    public ResponseEntity<String> updatePeople(@PathVariable("id") long id, @RequestBody People people) {
        System.out.println("people putMapping" + id);

        String result = peopleService.updatePeople(people);
        System.out.println(result);
        if (StringUtils.hasText(result)) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/people/{id}")
    public ResponseEntity<String> deletePeopleById(@PathVariable("id") long id) {
        System.out.println("deletePeopleById mapping " + id);
        String result = peopleService.deleteById(id);
        if (StringUtils.hasText(result)) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/peoples")
    public ResponseEntity<List<People>> getAllPeoples() {
        try {
            System.out.println("get all People mapping");
            List<People> peoples = peopleService.findAll();
            return new ResponseEntity<>(peoples, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/people")
    public ResponseEntity <List<People>> getPeopleByPersonName(@RequestParam(required = false) String personName) {
        try {

            System.out.println("getPeople By Id id == "+ personName);
            List<People> people = peopleService.findPeopleByName(personName);
            if (people != null) {
                System.out.println("find People by name===========");
                return new ResponseEntity<>(people, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/people/{id}")
    public ResponseEntity <People> getPeopleById(@PathVariable("id") Long id) {
        try {

            System.out.println("getPeople By Id id == "+ id);
            People people = peopleService.findPeopleById(id);
            if (people != null) {
                System.out.println("find People by ID===========");
                return new ResponseEntity<>(people, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
