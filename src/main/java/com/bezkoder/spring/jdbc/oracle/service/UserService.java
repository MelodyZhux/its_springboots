package com.bezkoder.spring.jdbc.oracle.service;

import com.bezkoder.spring.jdbc.oracle.model.User;
import com.bezkoder.spring.jdbc.oracle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String createUser(User user) {
        try {
            System.out.println("service mapping");
            userRepository.save(new User(user.getUser_name(),user.getUser_password()));
            return ("User was created successfully.");
        } catch (Exception e) {
            return "";
        }
    }

}
