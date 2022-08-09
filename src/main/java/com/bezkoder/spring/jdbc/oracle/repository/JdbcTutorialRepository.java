package com.bezkoder.spring.jdbc.oracle.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.bezkoder.spring.jdbc.oracle.model.Tutorial;


@Repository
public class JdbcTutorialRepository implements TutorialRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public int save(Tutorial tutorial) {
    System.out.println("tutorials save");
    return jdbcTemplate.update("INSERT INTO tutorials (id,title, description, published) VALUES(tur_sql.nextval,?,?,?)",
        new Object[] { tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished() });
  }

  @Override
  public int update(Tutorial tutorial) {
    return jdbcTemplate.update("UPDATE tutorials SET title=?, description=?, published=? WHERE id=?",
        new Object[] { tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished(), tutorial.getId() });
  }

  @Override
  public Tutorial findById(Long id) {
    try {
      Tutorial tutorial = jdbcTemplate.queryForObject("SELECT * FROM tutorials WHERE id=?",
          BeanPropertyRowMapper.newInstance(Tutorial.class), id);

      return tutorial;
    } catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  @Override
  public int deleteById(Long id) {
    return jdbcTemplate.update("DELETE FROM tutorials WHERE id=?", id);
  }

  @Override
  public List<Tutorial> findAll() {
    String q = "SELECT * from tutorials";
    System.out.println(q);
    List<Tutorial> list = jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Tutorial.class));
    //System.out.println("database:" + list.for;)

    for (Tutorial t : list) {
      System.out.println("list title:" + t.getTitle());
    }
    return list;
   // return jdbcTemplate.query("SELECT * from tutorials", BeanPropertyRowMapper.newInstance(Tutorial.class));
  }

  @Override
  public List<Tutorial> findByPublished(boolean published) {
    return jdbcTemplate.query("SELECT * from tutorials WHERE published=?",
        BeanPropertyRowMapper.newInstance(Tutorial.class), published);
  }

  @Override
  public List<Tutorial> findByTitleContaining(String title) {
    String q = "SELECT * from tutorials WHERE title LIKE '%" + title + "%' collate binary_ci";
    System.out.println(q);
    List<Tutorial> list = jdbcTemplate.query(q,new TutorialRowMapper());
   // List<Tutorial> list = jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Tutorial.class));
    //System.out.println("database:" + list.for;)
    for (Tutorial t : list) {
      System.out.println("list title:" + t.getTitle());
    }
    return list;
  }

  @Override
  public int deleteAll() {
    return jdbcTemplate.update("DELETE from tutorials");
  }
}
