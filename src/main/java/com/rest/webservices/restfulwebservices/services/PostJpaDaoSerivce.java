package com.rest.webservices.restfulwebservices.services;

import com.rest.webservices.restfulwebservices.beans.Post;
import com.rest.webservices.restfulwebservices.beans.User;
import com.rest.webservices.restfulwebservices.repositories.PostJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostJpaDaoSerivce {

    @Autowired
    private PostJpaRepository postJpaRepository;

    public User save(User user, Post post) {
        post.setUser(user);
        postJpaRepository.save(post);
        return user;
    }
}
