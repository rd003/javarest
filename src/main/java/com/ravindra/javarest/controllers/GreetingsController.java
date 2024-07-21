package com.ravindra.javarest.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class GreetingsController {
    @GetMapping("/")

    public String greeting() {
        return "Hello world";
    }
}
