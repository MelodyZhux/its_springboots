package com.bezkoder.spring.jdbc.oracle.repository;

import java.util.List;
import com.bezkoder.spring.jdbc.oracle.model.People;

public interface PeopleRepository {
    int save(People book);
    List<People> findAll();
    List<People> findPeopleByPersonName(String personName);
    People findPeopleById(Long id);

    int update(People book);

    int deleteById(Long id);



}
