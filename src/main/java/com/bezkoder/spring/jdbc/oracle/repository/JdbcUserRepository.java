package com.bezkoder.spring.jdbc.oracle.repository;

import com.bezkoder.spring.jdbc.oracle.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserRepository implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(User user) {
        return jdbcTemplate.update("INSERT INTO userlogin (username, password) VALUES(?,?)",
                new Object[] { user.getUser_name(),user.getUser_password() });
    }


}
