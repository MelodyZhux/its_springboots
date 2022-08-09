package com.bezkoder.spring.jdbc.oracle.repository;

import com.bezkoder.spring.jdbc.oracle.model.User;

public interface UserRepository {
    int save(User book);
}
