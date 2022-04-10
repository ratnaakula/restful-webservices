package com.rest.webservices.restfulwebservices.controllers;

import com.rest.webservices.restfulwebservices.beans.SomeBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    /**SimpleBeanPropertyFilter**/

    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean() {
        return new SomeBean("val1", "val2", "val3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveSomeBeanList() {
        return Arrays.asList(new SomeBean("val1", "val2", "val3"),
                new SomeBean("val12", "val22", "val32"));
    }
}
