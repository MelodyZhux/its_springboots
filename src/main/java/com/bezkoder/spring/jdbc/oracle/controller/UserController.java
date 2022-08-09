package com.bezkoder.spring.jdbc.oracle.controller;

import com.bezkoder.spring.jdbc.oracle.model.User;
import com.bezkoder.spring.jdbc.oracle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {

//    @Autowired
//    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody User user) {

        System.out.println("register mapping");
        String result = userService.createUser(user);

        if (StringUtils.hasText(result)) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

//        try {
//            //System.out.println(user.toString());
//            userRepository.save(new User(user.getUser_name(), user.getUser_Email(), user.getUser_password()));
//            return new ResponseEntity<>("User was created successfully.", HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }

}
