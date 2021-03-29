package com.recipebook.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControllers {

    @GetMapping("")
    public String test(){
        return "Hello World";
    }

}
