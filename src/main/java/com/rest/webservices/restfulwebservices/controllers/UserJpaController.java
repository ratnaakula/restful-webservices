package com.rest.webservices.restfulwebservices.controllers;

import com.rest.webservices.restfulwebservices.beans.Post;
import com.rest.webservices.restfulwebservices.beans.User;
import com.rest.webservices.restfulwebservices.services.PostJpaDaoSerivce;
import com.rest.webservices.restfulwebservices.services.UserJpaDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaController {

    @Autowired
    private UserJpaDaoService userDaoService;

    @Autowired
    private PostJpaDaoSerivce postJpaDaoService;

    @GetMapping("/jpa/users")
    public List<User> findUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> findUser(@PathVariable Integer id) {
        User user = userDaoService.findUser(id);
        EntityModel<User> model = EntityModel.of(user);
        WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).findUsers());
        model.add(linkToUsers.withRel("all-users"));
        return model;
    }

    @PostMapping("/jpa/users")
    public User createUser(@Valid @RequestBody User user) {
        return userDaoService.save(user);
    }

    @DeleteMapping("/jpa/users/{id}")
    public List<User> deleteUser(@PathVariable Integer id) {
        return userDaoService.deleteUser(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveAllPosts(@PathVariable Integer id) {
        return userDaoService.findById(id);
    }

    @PostMapping("/jpa/users/{id}/posts")
    public User createPost(@PathVariable Integer id, @RequestBody Post post) {
        User user = userDaoService.findUser(id);
        return postJpaDaoService.save(user, post);
    }

}
