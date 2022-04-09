package com.rest.webservices.restfulwebservices.controllers;

import com.rest.webservices.restfulwebservices.beans.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {



    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean sayHelloWorldBean() {
        return new HelloWorldBean("Hello-World-Bean");
    }

    @GetMapping("/hello-world-bean/{name}")
    public HelloWorldBean sayHelloWorldBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello-World-Bean %s", name));
    }
}
