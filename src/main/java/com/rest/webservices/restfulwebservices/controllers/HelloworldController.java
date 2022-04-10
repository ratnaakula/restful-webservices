package com.rest.webservices.restfulwebservices.controllers;

import com.rest.webservices.restfulwebservices.beans.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloworldController {

    @Autowired
    private MessageSource messageSource;

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

    @GetMapping("/hello-international")
    public String sayHelloInternational(@RequestHeader(name="Accept-Language") Locale locale) {
        return messageSource.getMessage("good.morning.message", null, "Default Message", LocaleContextHolder.getLocale());
    }
}
