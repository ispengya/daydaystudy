package com.ispengya.controller;

import com.ispengya.mapper.UserMapper;
import com.ispengya.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/insert")
    public User insert() {
        User user = new User();
        user.setUsername("ispengya");
        user.setPassword("ispengya");
        user.setName("ispengya");
        userMapper.insertUser(user);
        return user;
    }

    @GetMapping("/get")
    public User get() {
        return userMapper.selectUserByUserName("ispengya").get(0);
    }
}
