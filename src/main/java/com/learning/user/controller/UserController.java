package com.learning.user.controller;

import com.learning.user.VO.ResponseTemplate;
import com.learning.user.entity.User;
import com.learning.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public ResponseTemplate findUserById(@PathVariable Long userId){
        log.info("Inside findUserById of UserController");
        return userService.findUserById(userId);
    }
}
