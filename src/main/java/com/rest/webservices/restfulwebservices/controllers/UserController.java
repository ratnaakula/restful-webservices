package com.rest.webservices.restfulwebservices.controllers;

import com.rest.webservices.restfulwebservices.beans.User;
import com.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import com.rest.webservices.restfulwebservices.services.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> findUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User findUser(@PathVariable Integer id) {
        User user = userDaoService.findUser(id);
        if (null == user) {
            throw new UserNotFoundException("id_" + id);
        }
        return user;
    }

    @PostMapping("/user")
    public User findUser(@Valid @RequestBody User user) {
        return userDaoService.save(user);
    }

    @DeleteMapping("/users/{id}")
    public List<User> deleteUser(@PathVariable Integer id) {
        List<User> user = userDaoService.deleteUser(id);
        return user;
    }


}
