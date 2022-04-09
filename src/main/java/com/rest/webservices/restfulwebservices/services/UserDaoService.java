package com.rest.webservices.restfulwebservices.services;

import com.rest.webservices.restfulwebservices.beans.User;
import com.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static Integer count = 4;

    static {
        users.add(new User(1, "ratna", new Date()));
        users.add(new User(2, "akula", new Date()));
        users.add(new User(3, "raj", new Date()));
        users.add(new User(4, "venkata", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++count);
        }
        user.setDate(new Date());
        users.add(user);
        return user;
    }

    public User findUser(Integer id) {
        return users.stream()
                .filter(p -> p.getId() == id)
                .findFirst().get();
    }


    public List<User> deleteUser(Integer id) {
        users.removeIf(e -> e.getId() == id);
        return users;
    }
}
