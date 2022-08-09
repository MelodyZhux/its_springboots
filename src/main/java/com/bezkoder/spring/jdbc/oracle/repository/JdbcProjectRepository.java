package com.bezkoder.spring.jdbc.oracle.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.jdbc.oracle.model.Project;


@Repository
public class JdbcProjectRepository implements ProjectRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Project project) {

        System.out.println("project save ");



      //  String q = " INSERT INTO project(project_id,project_name,start_date,target_end_date,created_on,created_by) VALUES(project_id_seq.nextval,?,?,?,sysdate,?)";
        String q = " INSERT INTO project(project_id,project_name,start_date,target_end_date,created_on,created_by) VALUES(project_id_seq.nextval,?,?,?,sysdate,?)";
        System.out.println(q);
        System.out.println(project.getProjectName());
        System.out.println(project.getStartDate());
        System.out.println(project.getTargetEndDate());
        System.out.println(project.getCreatedBy());
        return jdbcTemplate.update(q, new Object[] { project.getProjectName(),project.getStartDate(),project.getTargetEndDate(),project.getCreatedBy() });

    }

    @Override
    public int update(Project project) {

        System.out.println("project update ");

        String q = "UPDATE project SET project_name= ?, start_date=?, target_end_date=?, modified_on= SYSDATE , modified_by=?  WHERE PROJECT_ID=?";
         System.out.println(q);
        System.out.println("id====="+project.getProjectId());
        System.out.println("id====="+project.getProjectName());
        System.out.println("id====="+project.getStartDate());
        System.out.println("id====="+project.getTargetEndDate());
        System.out.println("id====="+project.getModifiedOn());
        System.out.println("id====="+project.getModifiedBy());

        return jdbcTemplate.update(q, new Object[] { project.getProjectName(),project.getStartDate(),project.getTargetEndDate(),project.getModifiedBy(),project.getProjectId()});
    }
    @Override
    public int deleteById(Long id) {
        String q = "DELETE FROM project WHERE project_id=?";

        System.out.println(q);
        return jdbcTemplate.update(q, id);
    }
    @Override
    public List<Project> findAll() {

        String q = "SELECT * from project";
        System.out.println(q);
        List<Project> list = jdbcTemplate.query(q, new ProjectRowMapper());
        for (Project p : list) {
            System.out.println("listP ID:" + p.getProjectId() +"  list name: "+p.getProjectName() + "list date:" + p.getStartDate());
        }
        return list;
    }

    @Override
    public List<Project> findProjectByName(String name) {

        String q = "SELECT * from project where project_name LIKE '%" + name + "%' collate binary_ci";

        System.out.println(q);
        List<Project> list = jdbcTemplate.query(q, new ProjectRowMapper());
        for (Project p : list) {
            System.out.println("listP ID:" + p.getProjectId() +"  list name: "+p.getProjectName() + "list date:" + p.getStartDate());
        }
        return list;
    }

    @Override
    public Project findProjectById(Long id) {

       String q = "SELECT * from project where project_id =?";

    //    String q = " select project_id, project_name,to_date(start_date, 'dd-mm-yyyy'),to_date(target_end_date, 'dd-mm-yyyy'),to_date(actual_end_date, 'dd-mm-yyyy'),to_date(created_on, 'dd-mm-yyyy'),created_by,to_date(modified_on, 'dd-mm-yyyy'), modified_by from project where project_id=？";
        System.out.println(q);
        Project project = jdbcTemplate.queryForObject(q,new ProjectRowMapper(), id);
        System.out.println("find project by ID repository ===========");
        System.out.println(project.getProjectId());

        return project;
    }


}
