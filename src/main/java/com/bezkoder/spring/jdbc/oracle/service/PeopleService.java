package com.bezkoder.spring.jdbc.oracle.service;
import com.bezkoder.spring.jdbc.oracle.model.People;
import com.bezkoder.spring.jdbc.oracle.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeopleService {

    @Autowired
    PeopleRepository peopleRepository;

    public String createPeople(People people) {
        try {
            System.out.println("people service mapping");
            peopleRepository.save(people);
            return ("people was created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return "fail to add people";
        }
    }

    public String updatePeople(People people) {
        try {
            System.out.println("people service update mapping");
            System.out.println("People id::" + people.getPersonId());
            peopleRepository.update(people);
            return ("people was updated successfully.");
        } catch (Exception e) {
            return "can not update people";
        }
    }

    public String deleteById(Long id) {
        try {
            System.out.println("people service delete ");

            peopleRepository.deleteById(id);
            return ("people was deleted successfully.");
        } catch (Exception e) {
            return "";
        }
    }



    public List<People> findAll() {
        List<People> list = null;
        try {
            System.out.println("people service find all mapping");
            list = peopleRepository.findAll();
        } catch (Exception e) {
            System.out.println("error");

        }
        return list;
    }

    public List<People> findPeopleByName(String personName) {
        List<People> list = null;
        try {
            System.out.println("people service findpeople mapping" + personName);
            list = peopleRepository.findPeopleByPersonName(personName);
        } catch (Exception e) {
            System.out.println("error");

        }
        return list;
    }

    public People findPeopleById(Long id) {
        People people = null;
        try {
            System.out.println("people service findpeopleById mapping" + id);
            people = peopleRepository.findPeopleById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");

        }
        return people;
    }

}


