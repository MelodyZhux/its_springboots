package com.bezkoder.spring.jdbc.oracle.repository;

import java.util.List;
import com.bezkoder.spring.jdbc.oracle.model.Project;

public interface ProjectRepository {
    int save(Project book);
    List<Project> findAll();
    List<Project> findProjectByName(String name);
    Project findProjectById(Long id);

    int update(Project book);

    int deleteById(Long id);



}
