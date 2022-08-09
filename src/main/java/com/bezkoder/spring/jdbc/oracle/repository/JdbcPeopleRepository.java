package com.bezkoder.spring.jdbc.oracle.repository;

import java.util.List;

import com.bezkoder.spring.jdbc.oracle.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.jdbc.oracle.model.People;


@Repository
public class JdbcPeopleRepository implements PeopleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(People people) {

        System.out.println("people save ");
        String q = " INSERT INTO people(person_id,person_name,person_email,person_role,username,assigned_project,created_on,created_by) VALUES(person_id_seq.nextval,?,?,?,?,?,sysdate,?)";
        System.out.println(q);

        return jdbcTemplate.update(q, new Object[] { people.getPersonName(),people.getPersonEmail(),people.getPersonRole(),people.getUserName(),people.getAssignedProject(),people.getCreatedBy() });

    }

    @Override
    public int update(People people) {

        System.out.println("people update ");
        System.out.println(people.toString());

        String q = "UPDATE people SET person_name= ?, person_email=?, person_role=?,username=?,  assigned_project=?,modified_on= SYSDATE , modified_by=?  WHERE person_id=?";
        System.out.println(q);
        System.out.println("id====="+people.getPersonId());


        return jdbcTemplate.update(q, new Object[] { people.getPersonName(),people.getPersonEmail(),people.getPersonRole(),people.getUserName(),people.getAssignedProject(),people.getModifiedBy(),people.getPersonId()});
    }
    @Override
    public int deleteById(Long id) {
        String q = "DELETE FROM people WHERE person_id=?";

        System.out.println(q);
        return jdbcTemplate.update(q, id);
    }
    @Override
    public List<People> findAll() {

        String q = "SELECT * from people";
        System.out.println(q);
        List<People> list = jdbcTemplate.query(q, new PeopleRowMapper());
        for (People p : list) {
            System.out.println("listP ID:" + p.getPersonId() +"  list name: "+p.getPersonName());
        }
        return list;
    }

    @Override
    public List<People> findPeopleByPersonName(String personName) {

        System.out.println("person name ==="+ personName);

        String q = "SELECT * from people where person_name LIKE '%" + personName + "%' collate binary_ci";

        System.out.println(q);
        List<People> list  = jdbcTemplate.query(q, new PeopleRowMapper());

        return list;
    }

    @Override
    public People findPeopleById(Long id) {

        String q = "SELECT * from people where person_id =?";

        //    String q = " select people_id, people_name,to_date(start_date, 'dd-mm-yyyy'),to_date(target_end_date, 'dd-mm-yyyy'),to_date(actual_end_date, 'dd-mm-yyyy'),to_date(created_on, 'dd-mm-yyyy'),created_by,to_date(modified_on, 'dd-mm-yyyy'), modified_by from people where people_id=？";
        System.out.println(q);
        People people = jdbcTemplate.queryForObject(q,new PeopleRowMapper(), id);
        System.out.println("find People by ID repository ===========");
        System.out.println(people.getPersonId());

        return people;
    }


}
