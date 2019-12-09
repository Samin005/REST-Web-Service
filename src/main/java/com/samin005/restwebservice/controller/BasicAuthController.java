package com.samin005.restwebservice.controller;

import com.samin005.restwebservice.model.BasicAuthBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthController {

    @GetMapping(path = "/basicAuth")
    public BasicAuthBean logIn(){
        return new BasicAuthBean("You Are Authenticated");
    }
}
