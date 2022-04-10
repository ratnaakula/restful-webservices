package com.rest.webservices.restfulwebservices.services;

import com.rest.webservices.restfulwebservices.beans.Post;
import com.rest.webservices.restfulwebservices.beans.User;
import com.rest.webservices.restfulwebservices.repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserJpaDaoService {

   @Autowired
    private UserJpaRepository userJpaRepository;

    public List<User> findAll() {
       return userJpaRepository.findAll();
    }

    public User save(User user) {
        userJpaRepository.save(user);
        return user;
    }

    public User findUser(Integer id) {
        return userJpaRepository.findById(id).get();
    }


    public List<User> deleteUser(Integer id) {
        userJpaRepository.deleteById(id);
        return userJpaRepository.findAll();
    }

    public List<Post> findById(Integer id) {
        return userJpaRepository.findById(id).get().getPosts();
    }
}
